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

/**
 *
 * @author ADMIN
 */
public class Sum_Server {
    public static void main(String[] args) throws IOException {
        //        Tao Socket Server, mở port 9999
        try (DatagramSocket serverSocket = new DatagramSocket(8888)){
            System.out.println("Server da ket noi!");
            
//            B2: Nhan du lieu tu Client gui sang
            // Tao 2 mang byte de chua du lieu duoc ghi nha
            byte inFromClient1[] = new byte[100];
            byte inFromClient2[] = new byte[100];
            
            //Lay kich thuoc cua cac mang
            int length1 = inFromClient1.length;
            int length2 = inFromClient1.length;
            
            //Đóng gói 
            DatagramPacket fromClient1 = new DatagramPacket(inFromClient1, length1);
            DatagramPacket fromClient2 = new DatagramPacket(inFromClient2, length2);
            
            //Nhan du lieu tu client
            try{
                serverSocket.receive(fromClient1);
                serverSocket.receive(fromClient2);
            }catch (IOException ex2){
                System.out.println("Du lieu dong goi khong thanh cong!");
            }
            
            //B3: Xu ly
            //Convert
            String data1, data2;
            data1 = (new String(fromClient1.getData(),0,length1)).trim();
            data2 = (new String(fromClient2.getData(),0,length2)).trim();
            
            int a = data1.indexOf(data1);
            int b = data2.indexOf(data2);
            int c = a+b;
            
            //B4: Gui ket qua cho client
            byte outToClient[];
            data1 = String.valueOf(c);
            outToClient = data1.getBytes();
            length1 = outToClient.length;
            //Xac định địa chỉ của Client
            InetAddress add = fromClient1.getAddress();
            // Xác định port của Client
            int port = fromClient1.getPort();
            
            DatagramPacket toClient = new DatagramPacket(outToClient, length1,add,port);
            serverSocket.send(toClient);
            
            serverSocket.close();
        } catch (SocketException ex1) {
            System.out.println("Loi: " + ex1);
        }
    }
}
