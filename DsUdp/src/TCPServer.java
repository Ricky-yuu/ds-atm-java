import java.net.*;
import java.io.*;

public class TCPServer {
   public static void main(String args[]) {
      try {
         ServerSocket serverSocket = new ServerSocket(8888);
         System.out.println("Server is running and waiting for client connection...");
         Socket clientSocket = serverSocket.accept();
         System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         String inputLine;
         while ((inputLine = in.readLine()) != null) {
            System.out.println("Received message from client: " + inputLine);
         }
         in.close();
         clientSocket.close();
         serverSocket.close();
      } catch (IOException e) {
         System.out.println("Exception caught when trying to listen on port or listening for a connection");
         System.out.println(e.getMessage());
      }
   }
}
