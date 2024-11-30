
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class searchPortlocal {
    //args[]: args[0], args[1], args[2],...
    // args[0]: address Server
    // args[1]: port Server
    // args[2]: chứa dữ liệu của máy kết nối với máy người dùng (data)
    // Lưu ý: Nếu dùng Socket chuẩn deFacto thì chỉ có args[0] và args[1]

    public static void main(String[] args) {
        Socket client;
        String host = "localhost";

        if (args.length > 0){
            host = args[0];
        }
        
        for (int port = 0; port <= 1024; port++){
            try{
                try{
                    System.out.println("Port: " + port);
                    client = new Socket(host, port);
                    System.out.println("Dang do Server tai " + host + " va port " + port);
                }catch(UnknownHostException e){
                    System.out.println("Host khong ton tai");
                }
            }catch(IOException e){
                System.out.println("Port " + port + " khong hoat dong");
            }
        }
    }
}
