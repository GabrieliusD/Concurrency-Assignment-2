package Commons;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    /**
     * client side
     * @param input string input which is tested against regex to check if it is valid
     * @return return boolean depending on if the input is valid
     */
    public static boolean validateInput(String input)
    {
        Pattern pattern = Pattern.compile("^\\s*[+-]?(\\d+(?:\\.\\d+)?)\\s*[*\\/+-]\\s*[+-]?(\\d+(?:\\.\\d+)?)\\s*$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
        return true; 
        else return false;
    }
    /**
     * server side
     * @param expression calculates the expression. Must be validated first
     * @return returns the calculation
     */
    public static double evaluateExpression(String expression)
    {
        Scanner sc = new Scanner(expression);

        double firstNum = Double.parseDouble(sc.findInLine("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)"));
        String operator = sc.findInLine("[^0-9 .]").trim();
        double secondNum = Double.parseDouble(sc.findInLine("((?:(?<=[-+\\/*^]|^)\\s*[-+])?\\d+(?:[.]\\d+)?)"));
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
    /**
     * server side
     * removes decimal points if it is followed by 0
     * @param input number
     * @return returns different format
     */
    public static String formatString(String input)
    { 
        return input.replaceAll("[.][0]+$", "");    
    }
}
