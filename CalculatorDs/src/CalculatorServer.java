import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // create an instance of the CalculatorImpl class
            Calculator calculator = new CalculatorImpl();

            // create a registry with a custom port (2020)
            Registry registry = LocateRegistry.createRegistry(2020);

            // bind the CalculatorImpl object to the registry with a unique name
            Naming.bind("//localhost:2020/Calculator", calculator);

            System.out.println("Calculator server ready.");
        } catch (Exception e) {
            System.err.println("Calculator server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
