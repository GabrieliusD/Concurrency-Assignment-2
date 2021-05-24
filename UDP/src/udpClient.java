import java.io.*;

import Commons.Common;

public class udpClient {
    static final String host = "localhost";
    static final String port = "2001";
    public static void main(String[] args) {
        //takes input from the user
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);      
        
        try
        {   
            //connect to the server
            udpClientHelper helper = new udpClientHelper(host, port);
            while(true)
            {
                System.out.println("Enter valid input for example 5+5 or type exit to quit");
                String input = br.readLine();
                //check inputs
                if(input.contains("exit")) break;
                if(!Common.validateInput(input)) continue;
                //send
                helper.SendEquation(input);
                //receive
                System.out.println("the answer is: " + helper.receiveAnswer());

            }

            helper.close();

        } catch (Exception e) {e.getStackTrace();}
    }
}
