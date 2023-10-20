import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;

public class RmiServer extends UnicastRemoteObject implements ReceiveMessageInterface{
  String address;
  Registry registry;
  
  public void receiveMessage(String message) throws RemoteException {
    System.out.println("Message received: " + message);
  }

  public RmiServer() throws RemoteException {
    try {
      address = (InetAddress.getLocalHost()).toString();
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    }

    int port = 3232;
    System.out.println("RMI server started " + address + ":" + port);

    try {
      registry = LocateRegistry.createRegistry(port);
      registry.rebind("ReceiveMessage", this);
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    try {
      new RmiServer();
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
