
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class TongN_Client {
    public static void main(String[] args) throws IOException{
        try (Socket Client = new Socket("127.0.0.1", 9999)){
            System.out.println("Client da ket noi thanh cong!");
            Scanner br;
            PrintWriter pw;
            
            try (Scanner in = new Scanner(System.in)){
                br = new Scanner (Client.getInputStream());
                pw = new PrintWriter (Client.getOutputStream());
                
                System.out.println("Nhap 1 so nguyen bat ki tu ban phim");
                
                String st = in.nextLine();
                pw.write(st);
                pw.write('\n');
                pw.flush();
                
                String kq = br.nextLine();
                System.out.println("Ket qua la: " +Integer.valueOf(kq));
                
                in.close();
                pw.close();
                Client.close();
            }catch(IOException ex2){
                System.out.println("");
            }
        }catch(IOException ex1){
            System.out.println("Client chua ket noi Server!");
        }
    }
}
