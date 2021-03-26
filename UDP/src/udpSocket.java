import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class udpSocket extends DatagramSocket{
    DatagramSocket socket;
    InetAddress location;
    int port;
    //server side implementation set the port to open on
    udpSocket(String serverPort) throws Exception
    {
        socket = new DatagramSocket(Integer.parseInt(serverPort));
    }
    //client side implementation set the location and port to send to
    udpSocket(String hostName, String port) throws Exception
    {
        socket = new DatagramSocket();
        this.location = InetAddress.getByName(hostName);
        this.port = Integer.parseInt(port);
    }
    //server uses this to set the location that they will send the calculation back to
    public void setSendLocation(InetAddress ip, int port) throws UnknownHostException
    {
        this.location = ip;
        this.port = port;
    }
    //sends the message
    public void SendEquation(String input) throws IOException
    {
        byte buff[] = input.getBytes();
        DatagramPacket packet = new DatagramPacket(buff, buff.length, location, port);
        socket.send(packet);
    }
    //receives the message
    public DatagramPacket receiveAnswer() throws SocketException, IOException
    {
        byte buff[] = new byte[socket.getReceiveBufferSize()];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        
        socket.receive(packet);
        return packet;
    }
}
