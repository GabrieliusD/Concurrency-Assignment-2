import java.io.IOException;
import java.net.*;

import Commons.Common;
class MultiThreadSupportUDP extends Thread
{
    protected DatagramPacket packet;
    protected udpSocket socket;
    MultiThreadSupportUDP(udpSocket socket, DatagramPacket packet)
    {
        System.out.println("Handeling Clients Request");
        this.packet = packet;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            socket.setSendLocation(packet.getAddress(), packet.getPort());
            String clientRequest = new String(packet.getData());
            double answ = Common.evaluateExpression(clientRequest);
    
            socket.SendEquation(String.format("%.8f", answ));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            DatagramPacket packet = socket.receiveAnswer();
            MultiThreadSupportUDP thread = new MultiThreadSupportUDP(socket, packet);
            thread.start();
        }

    }
}
