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
            while(true)
            {
                System.out.println("Enter valid input for example 5+5 or type exit to quit");
                String input = br.readLine();
                if(input.contains("exit")) break;
                if(!helper.validateInput(input)) continue;

                helper.SendEquation(input);
                System.out.println("the answer is: " + helper.receiveAnswer());

            }

            helper.close();

        } catch (Exception e) {}
    }
}
