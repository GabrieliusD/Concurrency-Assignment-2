import java.io.*;
import java.net.*;
import java.util.regex.*;

public class udpClientHelper {
    final DatagramSocket socket;
    final InetAddress serverHost;
    final int serverPort;
    udpClientHelper(String hostname, String port) throws Exception
    {
        socket = new DatagramSocket();
        serverHost = InetAddress.getByName(hostname);
        serverPort = Integer.parseInt(port);
    }

    public void SendEquation(String input) throws IOException
    {
        byte buff[] = input.getBytes();
        DatagramPacket packet = new DatagramPacket(buff, buff.length, serverHost, serverPort);
        socket.send(packet);
    }

    public String receiveAnswer() throws SocketException, IOException
    {
        byte buff[] = new byte[socket.getReceiveBufferSize()];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        
        socket.receive(packet);
        return new String(packet.getData());
    }

    public boolean validateInput(String input)
    {
        Pattern pattern = Pattern.compile("^\\s*([-+]?)(\\d+)(?:\\s*([-+*\\/])\s*((?:\\s[-+])?\\d+)\\s*)+$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
        return true; 
        else return false;
    }
}
