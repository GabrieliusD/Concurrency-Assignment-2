import java.util.Scanner;

public class tcpServerHelper {
    public static double evaluateExpression(String expression)
    {
        Scanner sc = new Scanner(expression);

        double firstNum = Double.parseDouble(sc.findInLine("(?:\\d+[.]\\d+|\\d+)"));
        String operator = sc.findInLine("[^0-9 .]").trim();
        double secondNum = Double.parseDouble(sc.findInLine("(?:\\d+[.]\\d+|\\d+)"));
        sc.close();
        switch (operator){
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "/":
                return firstNum / secondNum;
            case "*":
                return firstNum * secondNum;

            default:
                throw new RuntimeException("unknown operator: "+operator);
        }
    }
}
