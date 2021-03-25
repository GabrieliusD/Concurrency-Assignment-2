import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws Exception {
        getNumbers("5.5-5");
    }

    static public int testingScanner(String input)
    {
        Scanner sc = new Scanner(input);

        int firstValue = Integer.parseInt(sc.findInLine("[0-9]*"));
        
        // get everything which follows and is not a number (might contain white spaces)
        String operator = sc.findInLine("[^0-9 .]").trim();
        int secondValue = Integer.parseInt(sc.findInLine("[0-9]*"));

        sc.close();
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
    static void getNumbers(String input)
    {
        Scanner sc = new Scanner(input);


        float firstNum = Float.parseFloat(sc.findInLine("(?:\\d+[.]\\d+|\\d+)"));
        sc.findInLine("[^0-9 .]").trim();
        float secondNum = Float.parseFloat(sc.findInLine("(?:\\d+[.]\\d+|\\d+)"));

        float answ = firstNum - secondNum;
        System.out.println(answ);

        sc.close();
    }
    
    
}
