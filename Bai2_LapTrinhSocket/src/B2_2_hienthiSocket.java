import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class B2_2_hienthiSocket {
    public static void main(String[] args) {
        try{
            try{
                InetAddress address = InetAddress.getByName("www.facebook.com");
                System.out.println(address);
    
                int port = 80;
                Socket socket = new Socket(address, port);//Tạo socket của client trả về server
                System.out.println("Đã kết nối thành công tới www.facebook.com");
                System.out.println("Địa chỉ IP: " + address.getHostAddress());
                System.out.println("Port: " + socket.getPort());
                System.out.println("Dia chi web: " + address.getHostName());
            } catch (UnknownHostException e) {
                System.err.println("Không tìm thấy host: " + e.getMessage());
            }
        }catch(IOException e){
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }    
}
