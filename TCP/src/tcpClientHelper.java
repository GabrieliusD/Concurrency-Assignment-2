import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return socket.receiveMessage();
    }

    public void close() throws IOException
    {
        socket.close();
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
