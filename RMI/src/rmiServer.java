import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class rmiServer {
    public static void main(String[] args) {
        try{
            //create registry at port 1099
            LocateRegistry.createRegistry(1099);
            //get the calculator implementation
            CalculatorImp cal = new CalculatorImp();
            //create a stub
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(cal, 1200);
            //get the created registry
            Registry registry = LocateRegistry.getRegistry();
            //bind the implementation to the name calculator 
            registry.bind("calculator", stub);

        } catch (Exception e) {System.out.println(e.getMessage());}

        System.out.println("server started");
    }
}
