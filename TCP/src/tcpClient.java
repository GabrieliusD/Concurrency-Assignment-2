import java.io.*;

public class tcpClient {
    static final String port = "2000";
    static final String host = "localhost";
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try{
            tcpClientHelper helper = new tcpClientHelper(host, port);
            String input;
            do{
                System.out.println("Enter valid input");
                input = br.readLine();
            }
            while(!helper.validateInput(input));

            helper.SendEquation(input);
            System.out.println(helper.getAnswer());

            
        } catch(IOException e) {}
    }


}
