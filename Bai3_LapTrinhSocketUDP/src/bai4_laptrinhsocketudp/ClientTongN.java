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
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ClientTongN {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        int n;
        Scanner sc = new Scanner(System.in);
        InetAddress add = InetAddress.getByName("localhost");
        int port = 9999;
        
        try(DatagramSocket ClientSocket = new DatagramSocket()){
            System.out.println("Da ket noi toi server...");
            System.out.println("Nhap lua chon cua ban 1 hoac 2: ");
            int choose = Integer.parseInt(sc.nextLine());
            
            if (choose == 1){
                try{
                System.out.println("Nhap so n: ");
                n = Integer.parseInt(sc.nextLine());
                
                byte outToServer[];
                
                String num = String.valueOf(n);
                
                outToServer = num.getBytes();
                
                int length1 = outToServer.length;
                
                DatagramPacket toServer = new DatagramPacket(outToServer, length1, add,port);
                
                ClientSocket.send(toServer);
                
                byte inFromServer[] = new byte[100];
                
                length1 = inFromServer.length;
                
                DatagramPacket fromServer = new DatagramPacket(inFromServer, length1);
                ClientSocket.receive(fromServer);
                
                String data = new String(fromServer.getData(), 0, length1).trim();
                
                System.out.println("Tong " + n + ": " + data);
                
                ClientSocket.close();
            }catch(UnknownHostException ex2){
                System.out.println("Khong tim thay server!");
            }
            }else if (choose == 2){
                Random rand = new Random();
                n = rand.nextInt(1000); 
                System.out.print("So bat ki la: " + n); 
                
                byte[] sendData = Integer.toString(n).getBytes(); 
                byte[] receiveData = new byte[1024]; 
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, add, port); 
                ClientSocket.send(sendPacket); 
                
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
                ClientSocket.receive(receivePacket); 
                
                String result = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
                System.out.println("Tong " + n + ": " + result);
            }
            
        }catch(SocketException ex1){
            System.out.println("Loi: " + ex1);
        }
    }
}
