import java.net.*;

public class UDPReceiver{
    public static void main(String [] args){
        try{
            DatagramSocket socket = new DatagramSocket(5005);
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println("receive DatagramPacket "
                    + (new String(packet.getData())).trim() + " "
                    + packet.getAddress() + ":"
                    + packet.getPort());
        } catch(Exception e){System.out.println("error "+e);}
    }
}