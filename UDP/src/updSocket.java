import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class updSocket extends DatagramSocket{
    DatagramSocket socket;
    InetAddress location;
    int port;

    updSocket(String serverPort) throws Exception
    {
        socket = new DatagramSocket(Integer.parseInt(serverPort));
    }
    updSocket(String hostName, String port) throws Exception
    {
        socket = new DatagramSocket();
        this.location = InetAddress.getByName(hostName);
        this.port = Integer.parseInt(port);
    }
    public void setSendLocation(String ip, String port) throws UnknownHostException
    {
        this.location = InetAddress.getByName(ip);
        this.port = Integer.parseInt(port);
    }
    public void SendEquation(String input) throws IOException
    {
        byte buff[] = input.getBytes();
        DatagramPacket packet = new DatagramPacket(buff, buff.length, location, port);
        socket.send(packet);
    }

    public String receiveAnswer() throws SocketException, IOException
    {
        byte buff[] = new byte[socket.getReceiveBufferSize()];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        
        socket.receive(packet);
        return new String(packet.getData());
    }
}
