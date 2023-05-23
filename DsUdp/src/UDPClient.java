import java.net.*;

public class UDPClient {
   public static void main(String args[]) {
      try {
         try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            String sentence;
            while (true) {
               sentence = "Hello from client!";
               sendData = sentence.getBytes();
               DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8888);
               clientSocket.send(sendPacket);
            }
         }
      } catch (Exception e) {
         System.out.println("Exception caught: " + e.getMessage());
      }
   }
}
