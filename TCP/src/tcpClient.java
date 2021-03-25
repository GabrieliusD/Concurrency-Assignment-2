import java.io.*;

public class tcpClient {
    static final String port = "2000";
    static final String host = "localhost";
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try{
            tcpClientHelper helper = new tcpClientHelper(host, port);
            while(true)
            {
                System.out.println("Enter valid input for example 5+5 or type exit to quit");
                String input = br.readLine();
                if(input.contains("exit")) {helper.SendEquation(input); break;}
                if(!helper.validateInput(input)) continue;

                helper.SendEquation(input);
                System.out.println("the answer is: " + helper.getAnswer());

            }

            helper.close();
            
        } catch(IOException e) {}

        System.out.println("Program End");
    }


}
