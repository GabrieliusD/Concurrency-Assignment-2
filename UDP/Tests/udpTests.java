import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;



import org.junit.Test;

public class udpTests {

    public static final String hostname = "localhost";
    public static final String port = "2001";


    //There is validation but it is identical to how TCP validates so it was left out.

    @Test
    public void TestAdd() throws Exception
    {
        System.out.println("Testing Addition");
        udpClientHelper helper = new udpClientHelper(hostname, port);
        String math = "14+15.2";
        helper.SendEquation(math);
        double expected = 29.2;
        double actual = Double.parseDouble(helper.receiveAnswer());
        System.out.println("Addition For: " + math + " Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, 0);
        System.out.println("Addition Test End");
    }
    @Test
    public void TestSubtract() throws Exception
    {
        System.out.println("Testing Subtraction");
        udpClientHelper helper = new udpClientHelper(hostname, port);
        String math = "19-13";
        helper.SendEquation(math);
        double expected = 6;
        double actual = Double.parseDouble(helper.receiveAnswer());
        System.out.println("Subtraction For: " + math + " Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, 0);
        System.out.println("Subtraction Test End");
    }
    @Test
    public void TestMultiply() throws Exception
    {
        System.out.println("Testing Multiplication");
        udpClientHelper helper = new udpClientHelper(hostname, port);
        String math = "3.7*5";
        helper.SendEquation(math);
        double expected = 18.5;
        double actual = Double.parseDouble(helper.receiveAnswer());
        System.out.println("Multiplication For: " + math + " Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, 0);
        System.out.println("Multiplication Test End");
    }

    @Test
    public void TestDivide() throws Exception
    {
        System.out.println("Testing Division");
        udpClientHelper helper = new udpClientHelper(hostname, port);
        String math = "17/2";
        helper.SendEquation(math);
        double expected = 8.5;
        double actual = Double.parseDouble(helper.receiveAnswer());
        System.out.println("Multiplication For: " + math + " Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, 0);
        System.out.println("Division Test End");
    }

    @Test
    public void TestVariedInput() throws Exception
    {
        System.out.println("Varied Input Test");
        String math[] = {"90+10","9000-1256.7", "5600*12", "154/4", "3000+5231", "400-321.44", "5/2", "8.3*1.2"};
        double expected[] = {100, 7743.3, 67200, 38.5, 8231, 78.56, 2.5, 9.96};
        double actual[] = new double[8];
        udpClientHelper helper = new udpClientHelper(hostname, port); 
        int num = 0;
        for (String m : math) {
            helper.SendEquation(m);
            actual[num] = Double.parseDouble(helper.receiveAnswer());
            System.out.println("Multiplication For: " + m + " Expected: " + expected[num] + " Actual: " + actual[num]);
            num++;
        }

        assertArrayEquals(expected, actual, 0);
        System.out.println("Varied Test End");
    }
}