import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
  private String username;
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  public ChatClient(String username, String host, int port) throws IOException {
    this.username = username;
    socket = new Socket(host, port);
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);
    out.println(username);
  }
  public void start() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        String message;
        try {
          while ((message = in.readLine()) != null) {
            System.out.println(message);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
  public void sendMessage(String message) {
    out.println(message);
  }
  public static void main(String[] args) throws IOException {
    ChatClient client = new ChatClient("Alice", "localhost", 8080);
    client.start();
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        String message = scanner.nextLine();
        client.sendMessage(message);
      }
    }
  }
}
