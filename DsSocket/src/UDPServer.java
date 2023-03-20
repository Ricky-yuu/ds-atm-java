import java.net.*;

public class UDPServer {
  public static void main(String args[]) throws Exception {
    try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];
      while(true) {
        System.out.println("Server is running...");
        DatagramPacket receivePacket = new DatagramPacket(receiveData,
        receiveData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String( receivePacket.getData());
        System.out.println("RECEIVED: " + sentence);
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        String capitalizedSentence = sentence.toUpperCase();
        sendData = capitalizedSentence.getBytes();
        DatagramPacket sendPacket =
        new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}