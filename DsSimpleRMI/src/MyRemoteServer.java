import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class MyRemoteServer implements MyRemoteInterface {
    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
    public static void main(String[] args) {
        try {
            MyRemoteServer server = new MyRemoteServer();
            MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(server, 1099);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MyRemoteInterface", stub);
            System.out.println("Server ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
