import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import Commons.Common;

public class tcpClientHelper {
    final tcpSocket socket;
    final InetAddress serverHost;
    final int serverPort;

    tcpClientHelper(String hostname, String portNum) throws SocketException, IOException
    {
        this.serverHost = InetAddress.getByName(hostname);
        this.serverPort = Integer.parseInt(portNum);
        this.socket = new tcpSocket(this.serverHost, this.serverPort);
    }

    public void SendEquation(String input) throws IOException
    {
        socket.sendOperations(input);
    }

    public String getAnswer() throws IOException
    {
        return Common.formatString(socket.receiveMessage());
    }

    public void close() throws IOException
    {
        socket.close();
    }
}
