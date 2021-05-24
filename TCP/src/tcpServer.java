import java.net.ServerSocket;

import Commons.Common;
/**
 * Adds multithread support for tcp solution
 */
class MultiThreadSupport extends Thread
{
    protected tcpSocket client;
    /**
     * 
     * @param client a client that the thread will take care of
     */
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
                //get the message from the socket
                String message = client.receiveMessage();
                //if the message is exit the client disconnects and quits the thread
                if(message.contains("exit")) break;
                System.out.println("Client send: " + message);
                //do calculation
                double answ = Common.evaluateExpression(message);
                //return the calculation to the client
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
            //create a server socket on the port
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            while(true)
            {
                System.out.println("Waiting for the client");
                //accepts the connection from the client
                tcpSocket clientSocket = new tcpSocket(serverSocket.accept());
                //passed the connection to the new thread
                MultiThreadSupport threaded = new MultiThreadSupport(clientSocket);
                threaded.start();
            } 
        } catch(Exception e) {e.getMessage();}
    }
}
