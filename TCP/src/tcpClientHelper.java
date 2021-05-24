import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import Commons.Common;
/**
 * helper to the client to communicate with the tcp server
 */
public class tcpClientHelper {
    final tcpSocket socket;
    final InetAddress serverHost;
    final int serverPort;
    /**
     * connect to the server
     * @param hostname ip
     * @param portNum  port
     * @throws SocketException
     * @throws IOException
     */
    tcpClientHelper(String hostname, String portNum) throws SocketException, IOException
    {
        this.serverHost = InetAddress.getByName(hostname);
        this.serverPort = Integer.parseInt(portNum);
        this.socket = new tcpSocket(this.serverHost, this.serverPort);
    }
    /**
     * send
     * @param input send to server
     * @throws IOException
     */
    public void SendEquation(String input) throws IOException
    {
        socket.sendOperations(input);
    }
    /**
     * get output from the server
     * @return socket output
     * @throws IOException
     */
    public String getAnswer() throws IOException
    {
        return Common.formatString(socket.receiveMessage());
    }
    /**
     * close
     * @throws IOException
     */
    public void close() throws IOException
    {
        socket.close();
    }
}
