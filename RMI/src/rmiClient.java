import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import Commons.Common;

public class rmiClient {
    static String host = "localhost";
    public static void main(String[] args) {

        try {
            //get the registry at the location
            Registry registry = LocateRegistry.getRegistry(host);
            //get the calculator implementation
            Calculator stub = (Calculator) registry.lookup("calculator");
            //allow user input
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            
            String input = null;
            //get user input until exit is entered
            while(true)
            {
                System.out.println("Enter numbers to calculate example 5+5 or type exit to quit");
                input = br.readLine();
                //validate input
                if(input.contentEquals("exit")) break; 
                if(!Common.validateInput(input)) { System.out.println(input + " is invalid Input Try again"); continue;}

                //get operator
                String op = getOperator(input);
                String answ;
                //call appropriate method based on the operator
                switch(op)
                {
                case "+":
                    answ = "The answer to Adding is: " + stub.Add(input);
                    break;
                case "-":
                    answ = "The answer to Subtracting is: " + stub.Subtract(input);
                    break;
                case "/":
                    answ = "The answer to Multiplication is: " + stub.Divide(input);
                    break;
                case "*":
                    answ = "The answer to Division is: " + stub.Multiply(input);
                    break;
                default: answ = "error";
                    break;
                }
    
                //print answer
                System.out.println(answ);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program End");
    }


    static public String getOperator(String input)
    {
        String op[] = input.split("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)\s*");
        return op[1];

    }


}