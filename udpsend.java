import java.net.*;

// the Sockets in Java worksheet was used as a guide to make this udp sender

public class udpsend{

    public static void main(String [] args){

        try{
            InetAddress address = InetAddress.getByName("svm-km2-nets.ecs.soton.ac.uk");
            DatagramSocket socket = new DatagramSocket();

            String userID = "sdd1n17";
            byte[] buf = userID.getBytes();

            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5005);
            socket.send(packet);
            System.out.println("UDP message: "
                    + new String(packet.getData()) + " sent to "
                    + packet.getAddress() + ":"
                    + packet.getPort());

            socket.close();
        }catch(Exception e){System.err.println("error"+e);}
    }
}