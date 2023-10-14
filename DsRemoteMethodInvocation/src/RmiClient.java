import java.rmi.*;
import java.rmi.registry.*;

public class RmiClient {
  public static void main (String args[]) {
    ReceiveMessageInterface rmiServer;
    Registry registry;
    String address = "localhost";
    String port = "3232";
    String message = args[0];
    System.out.println("Sending message: " + message + " to " + address + ":" + port);

    try {
      registry = LocateRegistry.getRegistry(address, Integer.parseInt(port));
      rmiServer = (ReceiveMessageInterface)(registry.lookup("ReceiveMessage"));
      rmiServer.receiveMessage(message);
    } catch (RemoteException e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    } catch (NotBoundException e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
