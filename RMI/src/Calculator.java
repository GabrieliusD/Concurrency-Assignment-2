import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{
    public String calculate(String equation) throws RemoteException;
}
