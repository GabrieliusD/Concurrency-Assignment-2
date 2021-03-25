import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class rmiClient {
    public static void main(String[] args) {

        String hostname = "localhost";
        try {
            Registry registry = LocateRegistry.getRegistry();
            Calculator stub = (Calculator) registry.lookup("calculator");
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            String input = br.readLine();
            String answ = stub.calculate(input);

            System.out.println(answ);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}