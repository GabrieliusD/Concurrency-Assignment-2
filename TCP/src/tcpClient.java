import java.io.*;

import Commons.Common;
public class tcpClient {
    static final String port = "2000";
    static final String host = "localhost";
    public static void main(String[] args) {
        //get input from the user
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try{
            //connect to the server
            tcpClientHelper helper = new tcpClientHelper(host, port);
            System.out.println("Connected to the Server");
            //while there is a connection the user can send multiple calculations
            while(true)
            {
                System.out.println("Enter valid input for example 5+5 or type exit to quit");
                String input = br.readLine();
                //quit
                if(input.contains("exit")) { break;}
                if(!Common.validateInput(input)) continue;
                //send
                helper.SendEquation(input);
                //receive
                System.out.println("the answer is: " + helper.getAnswer());

            }
            //close
            helper.close();
            
        } catch(IOException e) {}

        System.out.println("Program End");
    }
    

}
