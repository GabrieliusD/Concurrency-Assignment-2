import java.rmi.RemoteException;
import java.util.Scanner;

import Commons.Common;

public class CalculatorImp implements Calculator{
    class Numbers
    {
        public double firstNum = 0;
        public double secondNum = 0;
    }

    Numbers getNumbers(String input)
    {
        Scanner sc = new Scanner(input);
        Numbers n = new Numbers();
        n.firstNum = Double.parseDouble(sc.findInLine("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)"));
        sc.findInLine("[^0-9 .]").trim();
        n.secondNum = Double.parseDouble(sc.findInLine("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)"));
        sc.close();
        return n;
    }

    @Override
    public String Add(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum+n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }

    @Override
    public String Subtract(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum-n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }

    @Override
    public String Multiply(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum*n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }

    @Override
    public String Divide(String input) throws RemoteException {
        Numbers n = getNumbers(input);
        double answ = n.firstNum/n.secondNum;
        return Common.formatString(String.format("%.8f", answ));
    }
    
}
