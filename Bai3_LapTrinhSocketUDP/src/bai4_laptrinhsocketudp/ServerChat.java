import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerChat {
    public static void main(String[] args) {
        try {
            try (DatagramSocket socket = new DatagramSocket(9999)) {
                byte[] receiveData = new byte[100];
                byte[] sendData;
                System.out.println("Server da duoc khoi tao");
                
                while (true) {
                    // Receive message from client
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();
                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                    
                    System.out.println("Client: " + message);
                    
                    // Check for quit command
                    if (message.equalsIgnoreCase("quit")) {
                        System.out.println("Doan chat ket thuc boi Client");
                        break;
                    }
                    
                    // Send response to client
                    System.out.print("Server: ");
                    String response = System.console().readLine();
                    sendData = response.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    socket.send(sendPacket);
                    
                    // Check for quit command
                    if (response.equalsIgnoreCase("quit")) {
                        System.out.println("Doan chat ket thuc boi Server.");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Loi: " + e);
        }
    }
}
