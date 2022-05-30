import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws IOException{



        ServerSocket serverSocket = new ServerSocket(8000);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + clientSocket.getInetAddress());

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("HTTP/1.0 200 OK\n" +
                    "Content-type: text/html\n" +
                    "\n" +
                    "<h1>helloman</h1>\n");
            writer.flush();

            writer.close();
            clientSocket.close();
        }
        //serverSocket.close();

    }
}
