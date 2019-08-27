import java.io.*;
import java.net.*;

public class TCPReceiver{
    public static void main(String [] args){
        try{
            ServerSocket ss = new ServerSocket(5002);
            for(;;){
                try{Socket client = ss.accept();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
                    String line;
                    while((line = in.readLine()) != null)
                        System.out.println(line+" received");
                    client.close();
                }catch(Exception e){System.out.println("error "+e);}
            }
        }catch(Exception e){System.out.println("error "+e);}
    }
}