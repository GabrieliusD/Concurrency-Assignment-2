import java.rmi.RemoteException;
import java.util.Scanner;

public class CalculatorImp implements Calculator{

    double firstNum = 0;
    double secondNum = 0;

    void getNumbers(String input)
    {
        Scanner sc = new Scanner(input);
        
        firstNum = Double.parseDouble(sc.findInLine("(?:\\d+[.]\\d+|\\d+)"));
        sc.findInLine("[^0-9 .]").trim();
        secondNum = Double.parseDouble(sc.findInLine("(?:\\d+[.]\\d+|\\d+)"));
        sc.close();
    }

    @Override
    public String Add(String input) throws RemoteException {
        getNumbers(input);
        double answ = firstNum+secondNum;
        return "The answer to Adding is: " + Double.toString(answ);
    }

    @Override
    public String Subtract(String input) throws RemoteException {
        getNumbers(input);
        double answ = firstNum-secondNum;
        return "The answer to Subtracting is: " + Double.toString(answ);
    }

    @Override
    public String Multiply(String input) throws RemoteException {
        getNumbers(input);
        return "The answer to Multiplication is: " + Double.toString(firstNum*secondNum);
    }

    @Override
    public String Divide(String input) throws RemoteException {
        getNumbers(input);
        return "The answer to Division is: " + Double.toString(firstNum/secondNum);
    }
    
}
