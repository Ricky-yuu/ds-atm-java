import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientv2 {
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private BufferedReader console;

  public ChatClientv2(String serverAddress, int serverPort) throws IOException {
    socket = new Socket(serverAddress, serverPort);
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);
    console = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter your username: ");
    String username = console.readLine();
    out.println(username);

    System.out.println("Welcome to the chat room! Type 'exit' to leave.");
  }

  public void start() {
    String message;
    while (true) {
      try {
        message = console.readLine();
        if (message.equalsIgnoreCase("exit")) {
          break;
        }
        out.println(message);
        System.out.println(in.readLine());
      } catch (IOException e) {
        e.printStackTrace();
        break;
      }
    }

    try {
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    ChatClientv2 client = new ChatClientv2("localhost", 5999);
    client.start();
  }
}