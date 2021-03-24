import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class udpServer {
    static final String host = "localhost";
    static final String port = "2001";
    public static void main(String[] args) throws SocketException, IOException
    {
        DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(port));
        System.out.println("trying to get buffer size");
        byte buff[] = new byte[serverSocket.getReceiveBufferSize()];
        System.out.println("buffer size is :" + buff.length);
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        serverSocket.receive(packet);

        String clientRequest = new String(packet.getData());
        System.out.println(clientRequest);

        int answ = evaluateExpression(clientRequest);
        buff = Integer.toString(answ).getBytes();
        DatagramPacket answPacket = new DatagramPacket(buff, buff.length, packet.getAddress(), packet.getPort());
        serverSocket.send(answPacket);
    }

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
