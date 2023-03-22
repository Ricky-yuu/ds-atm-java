import java.io.IOException;
import java.util.Scanner;

public class ChatClient2 {
  public static void main(String[] args) throws IOException {
    ChatClient client = new ChatClient("Bangik", "localhost", 8080);
    client.start();
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        String message = scanner.nextLine();
        client.sendMessage(message);
      }
    }
  }
}
