/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4_laptrinhsocketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ClientSum {
    public static void main(String[] args) throws IOException{
        int a,b;
        Scanner sc = new Scanner(System.in);
        
        try(DatagramSocket ClientSocket = new DatagramSocket()){
            System.out.println("Socket Client da duoc thiet lap...");
            try{
                System.out.println("Nhap so a: ");
                a = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap so b: ");
                b = Integer.parseInt(sc.nextLine());
                
                byte outToServer1[];
                byte outToServer2[];
                
                String sa = String.valueOf(a);
                String sb = String.valueOf(b);
                
                outToServer1 = sa.getBytes();
                outToServer2 = sb.getBytes();
                
                int length1 = outToServer1.length;
                int length2 = outToServer2.length;
                
                InetAddress add = InetAddress.getByName("localhost");
                int port = 8888;
                
                DatagramPacket toServer1 = new DatagramPacket(outToServer1, length1, add, port);
                DatagramPacket toServer2 = new DatagramPacket(outToServer2, length2, add, port);
                
                ClientSocket.send(toServer1);
                ClientSocket.send(toServer2);
                
                byte inFromServer[] = new byte[100];
                
                length1 = inFromServer.length;
                
                DatagramPacket fromServer = new DatagramPacket(inFromServer, length1);
                ClientSocket.receive(fromServer);
                
                String data = (new String(fromServer.getData(), 0, length1)).trim();
                
                System.out.println("Tong " + a + " + " + b + " = "+ data);
                
                ClientSocket.close();
                        
            }catch(UnknownHostException ex2){
                System.out.println("Khong tim thay server!");
            }
        }catch(IOException ex1){
            System.out.println("Khong tao duoc socket!");
        }
    }
}
