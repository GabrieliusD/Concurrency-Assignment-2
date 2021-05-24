import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.SocketException;



import org.junit.Test;

import Commons.Common;

public class tcpTests {

    //Run the server before running any of the tests
    public static final String host = "localhost";
    public static final String port = "2000";
    @Test
    public void TestClientValidInput() throws SocketException, IOException
    {
        System.out.println("Testing Valid Inputs");
        String valid[] = {"1+1", "2.2-3.1", "123.21312*1321.124124", "1/1.0"};
        for (String v : valid) {
            assertTrue(Common.validateInput(v));
            System.out.println("Input: " + v + " Passed");
            
        }
        System.out.println("Valid Inputs Test End");
    }
    @Test
    public void TestClientInvalidInput() throws SocketException, IOException
    {
        System.out.println("Testing Invalid Inputs");
        String invalid[] = {"+1+2+3", "+++1.0+2", "20" , "50 2 +"};
        for (String v : invalid) {
            assertFalse(Common.validateInput(v));
            System.out.println("Invalid Input: " + v + " Passed");
            
        }
        System.out.println("Invalid Input Test End");
    }
    @Test
    public void TestAdd() throws SocketException, IOException
    {
        System.out.println("Testing Addition");
        tcpClientHelper helper = new tcpClientHelper(host, port);
        String math = "123+123";
        helper.SendEquation(math);
        String expected = "246";
        String actual = helper.getAnswer();
        assertEquals(expected, actual);
        System.out.println("Addition For: " + math + " Expected: " + expected + " Actual: " + actual);
        System.out.println("Addition Test End");
    }
    @Test
    public void TestSubtract() throws SocketException, IOException
    {
        System.out.println("Testing Subtraction");
        tcpClientHelper helper = new tcpClientHelper(host, port);
        String math = "123-123";
        String expected = "0";
        helper.SendEquation(math);
        String actual = helper.getAnswer();
        assertEquals(expected, actual);
        System.out.println("Subtraction For: " + math + " Expected: " + expected + " Actual: " + actual);
        System.out.println("Subtraction Test End");
        
    }
    @Test
    public void TestMultiplay() throws SocketException, IOException
    {
        System.out.println("Testing Multiplication");;
        tcpClientHelper helper = new tcpClientHelper(host, port);
        String math = "12*10";
        String expected = "120";
        helper.SendEquation(math);
        String actual = helper.getAnswer();
        System.out.println("Multiplication For: " + math + " Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual);
        System.out.println("Multiplication Test End");
    }
    @Test 
     public void TestDivide() throws SocketException, IOException
    {
        System.out.println("Division Test");
        tcpClientHelper helper = new tcpClientHelper(host, port);
        String math = "451.2/40";
        double expected = 11.28;
        helper.SendEquation(math);
        double actual = Double.parseDouble(helper.getAnswer());
        assertEquals(expected, actual, 0);
        System.out.println("Division For: " + math + " Expected: " + expected + " Actual: " + actual);
        System.out.println("Division Test End");
    }
    @Test
    public void TestVariedRequests() throws SocketException, IOException
    {
        System.out.println("Varied Test Start");
        tcpClientHelper helper = new tcpClientHelper(host, port);
        String math[] = {"20+2", "12-2", "300-2", "40*20", "3*1.5", "1.2+2", "14.182 + 30.2223", "12.21/20", "75.345*345.123"};
        double expected[] = {22,10, 298, 800, 4.5,3.2, 44.4043, 0.6105, 26003.292435};
        double actual[] = new double[9];
        
        int num = 0;
        for (String m : math) {
            helper.SendEquation(m);
            double answ = Double.parseDouble(helper.getAnswer());
            actual[num] = (answ);
            System.out.println("Math for: " + m + " Expected: " + expected[num] + " Actual: " + actual[num]);
            num++;
        }

        assertArrayEquals(expected, actual, 0);
        System.out.println("Test End");
    }

    

}
