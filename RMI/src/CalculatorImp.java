import java.rmi.RemoteException;
import java.util.Scanner;

import Commons.Common;

/**
 * Calculator implementation
 */
public class CalculatorImp implements Calculator{
    //get both numbers from GetNumbers method
    class Numbers
    {
        public double firstNum = 0;
        public double secondNum = 0;
    }
    /**
     * splits the string into 2 seperate numbers
     * @param input string with 2 numbers
     * @return
     */
    Numbers getNumbers(String input)
    {
        Scanner sc = new Scanner(input);
        Numbers n = new Numbers();
        //get first number
        n.firstNum = Double.parseDouble(sc.findInLine("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)"));
        //remove operator
        sc.findInLine("[^0-9 .]").trim();
        //get second number
        n.secondNum = Double.parseDouble(sc.findInLine("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)"));
        sc.close();
        return n;
    }
    
    @Override
    /**
     * Adds the input
     */
    public String Add(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum+n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }

    @Override
    /**
     * subtracts the input
     */
    public String Subtract(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum-n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }

    @Override
    /**
     * Multiplies the input
     */
    public String Multiply(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum*n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }

    @Override
    /**
     * Divides the input
     */
    public String Divide(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum/n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }
    
}
