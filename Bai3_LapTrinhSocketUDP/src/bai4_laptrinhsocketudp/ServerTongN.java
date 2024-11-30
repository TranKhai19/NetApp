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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ServerTongN {
    public static void main(String[] args) throws SocketException, IOException, IOException {
        try(DatagramSocket socket = new DatagramSocket(9999)){
            System.out.println("Server da duoc khoi tao!");
            Scanner sc = new Scanner(System.in);
            
            byte[] receiveData = new byte[100];
            byte[] sendData;
            
            while(true){
                DatagramPacket fromClient = new DatagramPacket(receiveData, receiveData.length);

                try{
                    socket.receive(fromClient);                    
                }catch (IOException ex) {
                    System.out.println("Du lieu dong goi khong thanh cong");
                }
                
                String data1;
                data1 = new String(fromClient.getData(),0, fromClient.getLength());
                
                int n = Integer.parseInt(data1); 
                int sum = 0; 
                
                for (int i = 1; i <= n; i++) { 
                    sum += i; 
                }
                
                InetAddress Client =  fromClient.getAddress();
                int port = fromClient.getPort();
                
                InetAddress clientAddress = fromClient.getAddress(); 
                int clientPort = fromClient.getPort(); 
                
                sendData = Integer.toString(sum).getBytes(); 
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort); 
                socket.send(sendPacket);     
                
                String q = sc.nextLine();
                
                if ("quit".equals(q)){
                    break;
                }
            }
        }catch (SocketException ex1){
            System.out.println("Loi: " + ex1);
        }
    }
}
