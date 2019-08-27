import java.io.*;
import java.net.*;

/* the link: https://medium.com/@ssaurel/create-a-simple-http-web-server-in-java-3fc12b29d5fd was used as
   a guide to make this server
*/

public class simplehttp implements Runnable{

    private static final String userID = "sdd1n17";

    private Socket socket;
    private static final Integer port = 8080;

    public simplehttp(Socket socket){
        this.socket = socket;
    }

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Listening for connections on port: " + port);

            while (true){
                simplehttp server = new simplehttp(serverSocket.accept());

                Thread thread = new Thread(server);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server Connection error: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedOutputStream dataOut = null;

        try {
            out = new PrintWriter(socket.getOutputStream());
            dataOut = new BufferedOutputStream(socket.getOutputStream());
            String contentMimeType = "text/plain";

            byte[] data = userID.getBytes();

            out.println("HTTP/1.1 200 OK");
            out.println("Server: Simple HTTP Server");
            out.println("Content-type: " + contentMimeType);
            out.println("Content-length: " + data.length);
            out.println();
            out.flush();

            dataOut.write(data,0,data.length);
            dataOut.flush();

        } catch (IOException e) {
            System.err.println("Server error: " + e);
        } finally {
            try {
                out.close();
                dataOut.close();
                socket.close();
            } catch (Exception e) {
                System.err.println("Error closing stream: " + e.getMessage());
            }
        }
    }
}
