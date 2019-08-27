import java.io.*;
import java.net.*;

// the Sockets in Java worksheet was used as a guide to make this tcp sender

public class tcpsend {

    public static void main(String [] args){

        try{
            Socket socket = new Socket("DellXPS15",5002);
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String userID = "sdd1n17";

            out.println(userID);
            out.flush();
            System.out.println("TCP message: " + userID + " sent");

            socket.close();

        }catch(Exception e){System.err.println("error"+e);}
    }
}
