import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
  private ServerSocket serverSocket;
  private List<ClientThread> clients = new ArrayList<>();

  public ChatServer(int port) throws IOException {
    serverSocket = new ServerSocket(port);
    System.out.println("Server started on port " + port);
  }

  public void start() {
    while (true) {
      try {
        Socket socket = serverSocket.accept();
        ClientThread client = new ClientThread(socket);
        clients.add(client);
        client.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void broadcast(String message) {
    for (ClientThread client : clients) {
      client.sendMessage(message);
    }     
  }

  private class ClientThread extends Thread {
    private Socket socket;
    private PrintWriter out;
    public ClientThread(Socket socket) throws IOException {
      this.socket = socket;
      out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
      try  (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
        String username = in.readLine();
        System.out.println(username + " has joined the chat");
        String message;
        while ((message = in.readLine()) != null) {
          System.out.println(username + ": " + message);
          broadcast(username + ": " + message);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

        clients.remove(this);
        System.out.println("Client disconnected");
      }
    }

    public void sendMessage(String message) {
      out.println(message);
    }
  }

  public static void main(String[] args) throws IOException {
    ChatServer server = new ChatServer(8080);
    server.start();
  }
}