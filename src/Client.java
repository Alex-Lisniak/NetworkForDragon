import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException{

        Socket clientSocket = new Socket("127.0.0.1",8000);

        InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bReader = new BufferedReader(reader);
        String s = bReader.readLine();
        System.out.println(s);

        clientSocket.close();
    }
}
