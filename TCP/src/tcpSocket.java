import java.io.*;
import java.net.*;

public class tcpSocket extends Socket{
    Socket socket;
    BufferedReader input;
    PrintWriter output;

    tcpSocket(InetAddress host, int port) throws SocketException, IOException
    {
        socket = new Socket(host, port);
        setStreams();
    } 
    tcpSocket(Socket socket) throws IOException
    {
        this.socket = socket;
        setStreams();
    }

    void setStreams() throws IOException
    {
        InputStream inStream = socket.getInputStream();
        input = new BufferedReader(new InputStreamReader(inStream));
        OutputStream outStream = socket.getOutputStream();
        output = new PrintWriter(new OutputStreamWriter(outStream));        
    }

    public void sendOperations(String operation) throws IOException
    {
        output.println(operation);
        output.flush();
    }
    public String receiveMessage() throws IOException
    {
        String message = input.readLine();
        return message;
    }
}
