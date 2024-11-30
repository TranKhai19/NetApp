package bai4_laptrinhsocketudp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class B1_CreateDatagramPacket {
    public static void main(String[] args) {
        try {
            // 1. Tạo DatagramSocket để lắng nghe dữ liệu trên cổng 9876
            DatagramSocket socket = new DatagramSocket(9876);

            // 2. Tạo mảng byte để chứa dữ liệu nhận được
            byte[] receiveBuffer = new byte[1024]; // Kích thước tối đa 1024 bytes

            // 3. Tạo DatagramPacket để nhận dữ liệu
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            System.out.println("Đang chờ nhận dữ liệu...");

            // 4. Nhận dữ liệu
            socket.receive(receivePacket);

            // 5. Chuyển đổi dữ liệu nhận được từ byte[] sang String
            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Dữ liệu nhận được: " + receivedData);

            // 6. Đóng socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
