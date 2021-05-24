import java.io.IOException;
import java.net.*;

import Commons.Common;
/**
 * Allows for the server to handle the inputs from different clients with thread support
 */
class MultiThreadSupportUDP extends Thread
{
    protected DatagramPacket packet;
    protected udpSocket socket;
    //Constructor that takes a socket and a packet
    MultiThreadSupportUDP(udpSocket socket, DatagramPacket packet)
    {
        System.out.println("Handeling Clients Request");
        this.packet = packet;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //Set a location that the server will respond to
            socket.setSendLocation(packet.getAddress(), packet.getPort());
            //get the request in string format
            String clientRequest = new String(packet.getData());
            System.out.println("Client Send: "+ clientRequest);
            //calculate
            double answ = Common.evaluateExpression(clientRequest);
            //respond to the client
            socket.SendEquation(String.format("%.8f", answ));
            System.out.println("Server Responded: " + answ);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Request resolved");
    }
}

public class udpServer {
    static final String host = "localhost";
    static final String port = "2001";
    public static void main(String[] args) throws Exception
    {
        udpSocket socket = new udpSocket(port);
        while(true)
        {
            System.out.println("Waiting for the client to send");
            //receive the packet
            DatagramPacket packet = socket.receiveAnswer();
            System.out.println("Packet received");
            //when the packet is received a seperate thread is created which handles the output
            MultiThreadSupportUDP thread = new MultiThreadSupportUDP(socket, packet);
            thread.start();
        }
    }
}
