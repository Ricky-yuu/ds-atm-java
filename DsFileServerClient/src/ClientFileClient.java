import java.io.*;
import java.net.*;

public class ClientFileClient {
  public static void main(String[] args) throws IOException {
    try (Socket socket = new Socket("localhost", 8000)) {
      System.out.println("Client started at " + new java.util.Date() + '\n');

      InputStream inputStream = socket.getInputStream();
      FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
      byte[] buffer = new byte[1024];
      int bytesRead;
      while((bytesRead = inputStream.read(buffer)) != -1){
        fileOutputStream.write(buffer, 0, bytesRead);
      }
      fileOutputStream.close();
      inputStream.close();
      System.out.println("File received from server at " + new java.util.Date() + '\n');
    }
  }
}
