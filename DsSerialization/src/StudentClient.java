import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            StudentInterface stub = (StudentInterface) registry.lookup("StudentInterface");
            Student student = stub.getStudent();
            System.out.println("Student ID: " + student.studentId);
            System.out.println("Student Name: " + student.name);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
