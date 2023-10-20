import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // look up the CalculatorImpl object in the RMI registry with a custom port (2020)
            Calculator calculator = (Calculator) Naming.lookup("//localhost:2020/Calculator");

            // invoke each of its methods with some sample arguments
            double a = 10.0;
            double b = 5.0;
            System.out.println("a + b = " + calculator.add(a, b));
            System.out.println("a - b = " + calculator.subtract(a, b));
            System.out.println("a * b = " + calculator.multiply(a, b));
            System.out.println("a / b = " + calculator.divide(a, b));
            System.out.println("sqrt(a) = " + calculator.sqrt(a));
            System.out.println("pow(a, b) = " + calculator.pow(a, b));
        } catch (Exception e) {
            System.err.println("Calculator client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
