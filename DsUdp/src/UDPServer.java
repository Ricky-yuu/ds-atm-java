import java.net.*;

public class UDPServer {
   public static void main(String args[]) {
      try {
         try (DatagramSocket serverSocket = new DatagramSocket(8888)) {
            System.out.println("Server is running and waiting for client connection...");
            byte[] receiveData = new byte[1024];
            while (true) {
               DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
               serverSocket.receive(receivePacket);
               String message = new String(receivePacket.getData());
               System.out.println("Received message from client: " + message);
            }
         }
      } catch (Exception e) {
         System.out.println("Exception caught: " + e.getMessage());
      }
   }
}
