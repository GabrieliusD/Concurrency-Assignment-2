import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class udpTests {

    public static final String hostname = "localhost";
    public static final String port = "2001";


    //There is validation but it is identical to how TCP validates so it was left out.

    @Test
    public void TestAdd() throws Exception
    {
        udpClientHelper helper = new udpClientHelper(hostname, port);
        helper.SendEquation("14+15.2");
        String expected = "29.2";
        String actual = helper.receiveAnswer();

        assertEquals(expected, actual);
    }
    @Test
    public void TestSubtract() throws Exception
    {
        udpClientHelper helper = new udpClientHelper(hostname, port);
        helper.SendEquation("29-13");
        String expected = "16";
        String actual = helper.receiveAnswer();

        assertEquals(expected, actual);
    }
    @Test
    public void TestMultiply() throws Exception
    {
        udpClientHelper helper = new udpClientHelper(hostname, port);
        helper.SendEquation("3.7*5");
        String expected = "18.5";
        String actual = helper.receiveAnswer();

        assertEquals(expected, actual);
    }

    @Test
    public void TestDivide() throws Exception
    {
        udpClientHelper helper = new udpClientHelper(hostname, port);
        helper.SendEquation("17/2");
        String expected = "8.5";
        String actual = helper.receiveAnswer();

        assertEquals(expected, actual);
    }

    @Test
    public void TestVariedInput() throws Exception
    {
        String math[] = {"90+10","9000-1256.7", "5600*12", "154/4", "3000+5231", "400-321.44", "5/2", "8.3*1.2"};
        String expected[] = {"100", "7743.3", "67200", "38.5", "8231", "78.56", "2.5", "9.96"};
        List<String> actual = new ArrayList<>();
        udpClientHelper helper = new udpClientHelper(hostname, port); 

        for (String m : math) {
            helper.SendEquation(m);
            actual.add(helper.receiveAnswer());
        }

        assertArrayEquals(expected, actual.toArray());
    }
}