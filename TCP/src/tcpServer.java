import java.net.ServerSocket;

import Commons.Common;
class MultiThreadSupport extends Thread
{
    protected tcpSocket client;
    MultiThreadSupport(tcpSocket client)
    {
        System.out.println("Client has Connected");
        this.client = client;
    }

    @Override
    public void run() {
        try {
            
            while(true)
            {
                String message = client.receiveMessage();
                if(message.contains("exit")) break;
                System.out.println("Client send: " + message);

                double answ = Common.evaluateExpression(message);

                client.sendOperations(String.format("%.8f", answ));
            }
            client.close();
            System.out.println("Client Disconnected");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
public class tcpServer {
    static final String port = "2000";
    static final String host = "localhost";

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            while(true)
            {
                System.out.println("Waiting for the client");
                tcpSocket clientSocket = new tcpSocket(serverSocket.accept());
                
                MultiThreadSupport threaded = new MultiThreadSupport(clientSocket);
                threaded.start();
            } 
        } catch(Exception e) {e.getMessage();}
    }
}
