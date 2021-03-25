import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class rmiClient {
    static String host = "localhost";
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Calculator stub = (Calculator) registry.lookup("calculator");
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            
            String input = null;
            while(true)
            {
                System.out.println("Enter numbers to calculate example 5+5 or type exit to quit");
                input = br.readLine();

                if(input.contentEquals("exit")) break; 
                if(!validateInput(input)) { System.out.println(input + " is invalid Input Try again"); continue;}


                String op = getOperator(input);
                String answ;
                switch(op)
                {
                case "+":
                    answ = stub.Add(input);
                    break;
                case "-":
                    answ = stub.Subtract(input);
                    break;
                case "/":
                    answ = stub.Divide(input);
                    break;
                case "*":
                    answ = stub.Multiply(input);
                    break;
                default: answ = "error";
                    break;
                }
    
    
                System.out.println(answ);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program End");
    }
    static public boolean validateInput(String input)
    {
        Pattern pattern = Pattern.compile("^(?:\\d+|\\d+[.]\\d+)[*+-\\/](?:\\d+|\\d+[.]\\d+)$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
        return true; 
        else return false;
    }

    static public String getOperator(String input)
    {
        Scanner sc = new Scanner(input);
        String operator = sc.findInLine("[^0-9 .]");
        sc.close();
        return operator;

    }


}