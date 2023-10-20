import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class StudentServerMain {

    public static void main(String args[]) {
        try {
            Student student = new Student("John", "123456", "BSIT", new String[] {"Math", "Science", "English"});

            // Create RMI server
            StudentServer server = new StudentServer(student);
            StudentInterface stub = (StudentInterface) UnicastRemoteObject.exportObject(server, 0);

            // Register RMI interface
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("StudentInterface", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
