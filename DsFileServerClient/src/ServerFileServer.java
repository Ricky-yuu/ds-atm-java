import java.io.*;
import java.net.*;

public class ServerFileServer {
  public static void main(String[] args) throws IOException {
    try (ServerSocket serverSocket = new ServerSocket(8000)) {
      System.out.println("Server started at " + new java.util.Date() + '\n');
      while(true){
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected from " + clientSocket.getInetAddress() + " at " + new java.util.Date() + '\n');

        OutputStream outputStream = clientSocket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while((bytesRead = fileInputStream.read(buffer)) != -1){
          outputStream.write(buffer, 0, bytesRead);
        }
        fileInputStream.close();
        outputStream.close();
        clientSocket.close();
        System.out.println("File sent to client at " + new java.util.Date() + '\n');
      }
    }
  }
}