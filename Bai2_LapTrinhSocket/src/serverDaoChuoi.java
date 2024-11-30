
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverDaoChuoi {
    public static void main(String[] args) throws IOException {
        Scanner sc;
//      B1: Tạo socket server
        try{
            ServerSocket server = new ServerSocket(999);
            System.out.println("Server da khoi tao thanh cong!");
            
            // B2: Lắng nghe kết nối từ client
            Socket client = server.accept();
            System.out.println("Da co ket noi tu client!");
            
            // B3: Đọc dữ liệu từ client
            sc = new Scanner(client.getInputStream());
            String st = sc.nextLine();
            String  daonguoc = daoChuoi(st);
        }catch(IOException e){
            System.out.println("Loi: Port da duoc su dung");
        }
    }

    private static String daoChuoi(String st) {
        StringBuilder reversed = new StringBuilder(st);
        return reversed.reverse().toString();
    }
}
