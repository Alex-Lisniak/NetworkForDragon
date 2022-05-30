import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException{

        Socket clientSocket = new Socket("127.0.0.1",8000);
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());


        InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bReader = new BufferedReader(reader);

        writer.write("give me information \n");
        writer.flush();


        String s = bReader.readLine();
        System.out.println("was written " + s);


        bReader.close();
        reader.close();
        writer.close();
        clientSocket.close();
    }
}
