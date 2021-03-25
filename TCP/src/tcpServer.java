import java.net.ServerSocket;

public class tcpServer {
    static final String port = "2000";
    static final String host = "localhost";

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            while(true)
            {
                tcpSocket clientSocket = new tcpSocket(serverSocket.accept());
                System.out.println("connected to the client");

                String message;
                message = clientSocket.receiveMessage();
                System.out.println("Client send: " + message);
                System.out.println("got equation");
                int answ = tcpServerHelper.evaluateExpression(message);

                clientSocket.sendOperations(Integer.toString(answ));
            } 
        } catch(Exception e) {}
    }
}
