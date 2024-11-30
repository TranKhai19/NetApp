//datagram -> định dạng gói tin -> đóng gói thành các frame -> gửi đi
//stream -> định dạng gói tin -> gửi chuỗi liên tục -> không có frame, đưa về ASCII
// row socket -> 1 socket cha có nhiều socket con
// Socket -> cho server -> dùng TCP
// DatagramSocket -> cho client và server -> dùng UDP
//ServerSocket -> cho server đến client -> dùng TCP
//


import java.io.*;
import java.net.*;

public class B2_1_Ketnoi {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.dtu.edu.vn", 80);
            System.out.println("Đã kết nối thành công tới www.dtu.edu.vn");
        } catch (UnknownHostException e) {
            System.err.println("Không tìm thấy host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
