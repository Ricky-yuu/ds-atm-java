import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
  public Student getStudent() throws RemoteException;
}
