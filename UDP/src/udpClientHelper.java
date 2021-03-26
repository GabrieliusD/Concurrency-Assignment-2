import java.io.*;
import java.net.*;
import java.util.regex.*;

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
        return new String(socket.receiveAnswer().getData());
    }

    public boolean validateInput(String input)
    {
        Pattern pattern = Pattern.compile("^(?:\\d+|\\d+[.]\\d+)[*+-\\/](?:\\d+|\\d+[.]\\d+)$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
        return true; 
        else return false;
    }

    public void close()
    {
        socket.close();
    }
}
