import java.io.*;
import java.net.*;

public class tcpSocket extends Socket{
    Socket socket;
    BufferedReader input;
    PrintWriter output;
    /**
     * constructor for the client side to locate the server
     * @param host host ip
     * @param port port number
     * @throws SocketException
     * @throws IOException
     */
    tcpSocket(InetAddress host, int port) throws SocketException, IOException
    {
        socket = new Socket(host, port);
        setStreams();
    } 
    /**
     * server socket
     * @param socket a socket for the server
     * @throws IOException
     */
    tcpSocket(Socket socket) throws IOException
    {
        this.socket = socket;
        setStreams();
    }
    /**
     * sets input and output to the socket
     * @throws IOException
     */
    void setStreams() throws IOException
    {
        InputStream inStream = socket.getInputStream();
        input = new BufferedReader(new InputStreamReader(inStream));
        OutputStream outStream = socket.getOutputStream();
        output = new PrintWriter(new OutputStreamWriter(outStream));        
    }
    /**
     * 
     * @param operation input that will be send
     * @throws IOException
     */
    public void sendOperations(String operation) throws IOException
    {
        output.println(operation);
        output.flush();
    }
    /**
     * 
     * @return output from the socket
     * @throws IOException
     */
    public String receiveMessage() throws IOException
    {
        String message = input.readLine();
        return message;
    }
}
