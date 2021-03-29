import java.io.*;
import java.net.*;

import Commons.Common;

public class udpClientHelper {
    final udpSocket socket;

    udpClientHelper(String hostname, String port) throws Exception
    {
        socket = new udpSocket(hostname, port);
    }

    public void SendEquation(String input) throws IOException
    {
        socket.SendEquation(input);
    }

    public String receiveAnswer() throws SocketException, IOException
    {
        DatagramPacket packet = socket.receiveAnswer();
        return Common.formatString(new String(packet.getData(), 0, packet.getLength()));
    }


    public void close()
    {
        socket.close();
    }
}
