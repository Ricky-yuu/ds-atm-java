import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public double add(double a, double b) throws RemoteException;
    public double subtract(double a, double b) throws RemoteException;
    public double multiply(double a, double b) throws RemoteException;
    public double divide(double a, double b) throws RemoteException;
    public double sqrt(double a) throws RemoteException;
    public double pow(double a, double b) throws RemoteException;
}
