import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Calculator Interface
 */
public interface Calculator extends Remote{
    public String Add(String input) throws RemoteException;
    public String Subtract(String input) throws RemoteException;
    public String Multiply(String input) throws RemoteException;
    public String Divide(String input) throws RemoteException;

}
