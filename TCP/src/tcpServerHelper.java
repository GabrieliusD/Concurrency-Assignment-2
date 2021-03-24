import java.util.Scanner;

public class tcpServerHelper {
    public static int evaluateExpression(String expression)
    {
        Scanner sc = new Scanner(expression);

        int firstValue = Integer.parseInt(sc.findInLine("[0-9]*"));

        // get everything which follows and is not a number (might contain white spaces)
        String operator = sc.findInLine("[^0-9]*").trim();
        int secondValue = Integer.parseInt(sc.findInLine("[0-9]*"));
        switch (operator){
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "/":
                return firstValue / secondValue;
            case "*":
                return firstValue * secondValue;
            case "%":
                return firstValue % secondValue;
            // todo: add additional operators as needed..
            default:
                throw new RuntimeException("unknown operator: "+operator);
        }
    }
}
