import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientPTB2 {
    public static void main(String[] args) {
                try (Socket socket = new Socket("localhost", 8888);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Kết nối đến server thành công!");

            while (true) {
                System.out.println("Nhập a, b, c (cách nhau bằng khoảng trắng) hoặc 'file:<tên_file>' để đọc từ file, hoặc 'quit' để thoát:");
                String userInput = scanner.nextLine();

                // Gửi dữ liệu đến server
                out.println(userInput);

                // Kiểm tra nếu người dùng muốn thoát
                if (userInput.equalsIgnoreCase("quit")) {
                    break;
                }

                // Nhận kết quả từ server
                String response = in.readLine();
                System.out.println("Kết quả: " + response);
            }

        } catch (IOException e) {
            System.err.println("Lỗi kết nối đến server: " + e.getMessage());
        }
    }
}