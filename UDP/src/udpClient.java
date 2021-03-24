import java.io.*;

public class udpClient {
    static final String host = "localhost";
    static final String port = "2001";
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);      
        
        try
        {
            udpClientHelper helper = new udpClientHelper(host, port);
            String input;
            do
            {
                System.out.println("enter valid input");
                input = br.readLine();

            } while(!helper.validateInput(input));

            helper.SendEquation(input);

            System.out.println(helper.receiveAnswer());
        } catch (Exception e) {}
    }
}
