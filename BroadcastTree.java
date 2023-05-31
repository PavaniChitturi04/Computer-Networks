import java.net.InetAddress;
import java.net.UnknownHostException;

public class BroadcastTree {
    public static void main(String[] args) {
        try {
            // Specify the network address and subnet mask
            String networkAddress = "192.168.1.0";
            String subnetMask = "255.255.255.0";
            
            // Calculate the broadcast address
            InetAddress network = InetAddress.getByName(networkAddress);
            InetAddress subnet = InetAddress.getByName(subnetMask);
            byte[] networkBytes = network.getAddress();
            byte[] subnetBytes = subnet.getAddress();
            
            // Perform bitwise AND operation on network and subnet addresses
            byte[] broadcastBytes = new byte[networkBytes.length];
            for (int i = 0; i < networkBytes.length; i++) {
                broadcastBytes[i] = (byte) (networkBytes[i] | ~subnetBytes[i]);
            }
            
            // Create the broadcast address
            InetAddress broadcast = InetAddress.getByAddress(broadcastBytes);
            
            // Print the broadcast address
            System.out.println("Broadcast Address: " + broadcast.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
}
}
}