import static org.junit.Assert.assertArrayEquals;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import org.junit.Test;

public class rmiTests {

    public static final String host = "localhost"; 
    @Test
    public void TestAdd() throws AccessException, RemoteException, NotBoundException
    {
        System.out.println("Addition Test Start");
        String inputs[] = {"5+10", "-10+5", "20.4+0.4", "5+-10", "3.5+2.1"};
        double expected[] ={15.0,-5, 20.8,-5, 5.6};
        double actual[] = new double[5];
        Registry registry = LocateRegistry.getRegistry(host);
        Calculator stub = (Calculator) registry.lookup("calculator");
        int num = 0;
        for (String input : inputs) {
            actual[num] = Double.parseDouble(stub.Add(input));
            System.out.println("Addition for: " + input + " Expected: " + expected[num] + " Actual: " + actual[num]);
            num++;
        }
        
        assertArrayEquals(expected, actual, 0);
        System.out.println("Addition Test Pass");

    }
    @Test
    public void TestSubtract() throws RemoteException, NotBoundException
    {
        System.out.println("Subtraction Test Start");
        String inputs[] = {"5-10", "-10-5", "20.4-0.4", "5--10", "3.5-2.1"};
        double expected[] ={-5,-15, 20,15, 1.4};
        double actual[] = new double[5];
        Registry registry = LocateRegistry.getRegistry(host);
        Calculator stub = (Calculator) registry.lookup("calculator");
        int num = 0;
        for (String input : inputs) {
            actual[num] = Double.parseDouble(stub.Subtract(input));
            System.out.println("Subtraction for: " + input + " Expected: " + expected[num] + " Actual: " + actual[num]);
            num++;
        }

        assertArrayEquals(expected, actual, 0);
        System.out.println("Subtraction Test Pass");
    }
    @Test
    public void TestMultiply() throws RemoteException, NotBoundException
    {
        System.out.println("Multiplication Test Start");
        String inputs[] = {"5*10", "-10*-5", "20.4*0.4", "5*-10", "3.5*2.0"};
        double expected[] ={50,50, 8.16,-50, 7};
        double actual[] = new double[5];
        Registry registry = LocateRegistry.getRegistry(host);
        Calculator stub = (Calculator) registry.lookup("calculator");
        int num = 0;
        for (String input : inputs) {
            actual[num] = Double.parseDouble(stub.Multiply(input));
            System.out.println("Multiplication for: " + input + " Expected: " + expected[num] + " Actual: " + actual[num]);
            num++;
        }
        
        assertArrayEquals(expected, actual, 0);
        System.out.println("Multiplication Test Pass");
    }
    @Test 
    public void TestDivide() throws RemoteException, NotBoundException
    {
        System.out.println("Division Test Start");
        String inputs[] = {"5/10", "-10/5", "20.4/0.4", "5/-10", "3.5/2.0"};
        double expected[] ={0.5,-2, 51,-0.5, 1.75};
        double actual[] = new double[5];
        Registry registry = LocateRegistry.getRegistry(host);
        Calculator stub = (Calculator) registry.lookup("calculator");
        int num = 0;
        for (String input : inputs) {
            actual[num] = Double.parseDouble(stub.Divide(input));
            System.out.println("Division for: " + input + " Expected: " + expected[num] + " Actual: " + actual[num]);
            num++;        }

        assertArrayEquals(expected, actual, 0);
        System.out.println("Division Test Pass");
    }
}
