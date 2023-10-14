import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MyRemoteClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            MyRemoteInterface stub = (MyRemoteInterface) registry.lookup("MyRemoteInterface");
            String response = stub.sayHello();
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
