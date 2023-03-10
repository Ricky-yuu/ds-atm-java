import java.rmi.*;

public interface ReceiveMessageInterface extends Remote {
    public void receiveMessage(String message) throws RemoteException;
}