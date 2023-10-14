import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentServer extends UnicastRemoteObject implements StudentInterface {

    private Student student;

    public StudentServer(Student student) throws RemoteException {
        this.student = student;
    }

    public Student getStudent() throws RemoteException {
        return student;
    }
}
