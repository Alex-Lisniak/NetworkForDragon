import java.net.*;
import java.io.*;
import java.util.StringJoiner;

public class Server {
    public static void main(String[] args) throws IOException{



        ServerSocket serverSocket = new ServerSocket(8000);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + clientSocket.getInetAddress());

            InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader bReader = new BufferedReader(reader);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            String request = bReader.readLine();
            String response = "length is " + request.length() + "\n";

//            writer.write("HTTP/1.0 200 OK\n" +
//                    "Content-type: text/html\n" +
//                    "\n" +
//                    "<h1>helloman</h1>\n");
            writer.write(response);
            writer.flush();


            bReader.close();
            reader.close();
            writer.close();
            clientSocket.close();
        }
        //serverSocket.close();

    }
}
