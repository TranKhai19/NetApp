/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4_laptrinhsocketudp;

import java.io.IOException;
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author ADMIN
 */
public class ClientChat {
    public static void main(String[] args) throws SocketException, UnknownHostException { 
        try { 
            try (DatagramSocket socket = new DatagramSocket()) {
                InetAddress serverAddress = InetAddress.getByName("localhost");
                byte[] sendData;
                byte[] receiveData = new byte[100];
                System.out.println("Client da ket noi toi Server...");
                while (true) { // Send message to server
                    System.out.print("Client: ");
                    String message = System.console().readLine();
                    sendData = message.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9999);
                    socket.send(sendPacket); // Check for quit command
                    if (message.equalsIgnoreCase("quit")) {
                        System.out.println("Doan chat ket thuc boi Client");
                        break;
                    }
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);
                    String response = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                    System.out.println("Server: " + response); // Check for quit command
                    if (response.equalsIgnoreCase("quit")) {
                        System.out.println("Doan chat ket thuc boi Server");
                        break;
                    }
                } // Receive response from server 
            } 
        } catch (IOException e) { 
            System.out.println("Loi: " + e);
        } 
    }   
}
