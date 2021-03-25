import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class rmiServer {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            CalculatorImp cal = new CalculatorImp();

            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(cal, 1200);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("calculator", stub);

        } catch (Exception e) {System.out.println(e.getMessage());}

        System.out.println("server started");
    }
}
