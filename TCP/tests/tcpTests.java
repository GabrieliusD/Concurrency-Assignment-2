import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import Commons.Common;

public class tcpTests {

    //Run the server before running any of the tests
    public static final String host = "localhost";
    public static final String port = "2000";
    @Test
    public void TestClientValidInput() throws SocketException, IOException
    {
        String valid[] = {"1+1", "2.2-3.1", "123.21312*1321.124124", "1/1.0"};
        for (String v : valid) {
            assertTrue(Common.validateInput(v));
            
        }
    }
    @Test
    public void TestClientInvalidInput() throws SocketException, IOException
    {
        String invalid[] = {"+1+2+3", "+++1.0+2", "20" , "50 2 +"};
        for (String v : invalid) {
            assertFalse(Common.validateInput(v));
            
        }
    }
    @Test
    public void TestAdd() throws SocketException, IOException
    {
        tcpClientHelper helper = new tcpClientHelper(host, port);
        helper.SendEquation("123+123");
        String answ = helper.getAnswer();
        assertEquals("246", answ);
    }
    @Test
    public void TestSubtract() throws SocketException, IOException
    {
        tcpClientHelper helper = new tcpClientHelper(host, port);
        helper.SendEquation("123-123");
        String answ = helper.getAnswer();
        assertEquals("0", answ);
        
    }
    @Test
    public void TestMultiplay() throws SocketException, IOException
    {
        tcpClientHelper helper = new tcpClientHelper(host, port);
        helper.SendEquation("12*10");
        String answ = helper.getAnswer();
        assertEquals("120", answ);
    }
    @Test 
     public void TestDivide() throws SocketException, IOException
    {
        tcpClientHelper helper = new tcpClientHelper(host, port);
        helper.SendEquation("451.2/40");
        String answ = helper.getAnswer();
        assertEquals("11.28", answ);
    }
    @Test
    public void TestVariedRequests() throws SocketException, IOException
    {
        tcpClientHelper helper = new tcpClientHelper(host, port);
        String math[] = {"20+2", "12-2", "300-2", "40*20", "3*1.5", "1.2+2", "14.182 + 30.2223", "12.21/20", "75.345*345.123"};
        String expected[] = {"22","10", "298", "800", "4.5","3.2", "44.4043", "0.6105", "26003.292435"};
        List<String> answers = new ArrayList<>();
        
        
        for (String m : math) {
            helper.SendEquation(m);
            String answ = helper.getAnswer();
            answers.add(answ);
        }

        assertArrayEquals(expected, answers.toArray());

    }

    

}
