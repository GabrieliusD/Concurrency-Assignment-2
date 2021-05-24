import java.io.*;
import java.net.*;

import Commons.Common;
/**
 * Helps the client to communicate with the server
 */
public class udpClientHelper {
    final udpSocket socket;
    //constructor takes in host and port, creates a socket.
    udpClientHelper(String hostname, String port) throws Exception
    {
        socket = new udpSocket(hostname, port);
    }
    //passed the input to the socket
    public void SendEquation(String input) throws IOException
    {
        socket.SendEquation(input);
    }
    //gets output from the socket
    public String receiveAnswer() throws SocketException, IOException
    {
        DatagramPacket packet = socket.receiveAnswer();
        return Common.formatString(new String(packet.getData(), 0, packet.getLength()));
    }

    //close the socket
    public void close()
    {
        socket.close();
    }
}
