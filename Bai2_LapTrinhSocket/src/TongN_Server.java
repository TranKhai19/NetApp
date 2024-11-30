import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
public class TongN_Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9999)){
            System.out.println("Server da khoi dong, daang cho ket noi");
            
            try (Socket clietn = server.accept()){
                System.out.println("Server da ket noi!");
                PrintWriter pw;
                try(Scanner br = new Scanner(clietn.getInputStream());){
                    pw = new PrintWriter(clietn.getOutputStream());
                    String st = br.nextLine();
                    
                    int n = Integer.parseInt(st);
                    int S = tong(n);
                    
                    String s = Integer.toString(S);
                    pw.write(s);
                    pw.write('\n');
                    pw.flush();
                    pw.close();
                    clietn.close();
                } catch (IOException ex3){
                    System.out.println("Khong the doc ghi!");
                }
            }catch(IOException ex2){
                System.out.println("Khong the ket noi server");
            }
        }
        catch(IOException exception){
            System.out.println("Server khong ton tai");
        }
    }
    public static int tong(int n){
        int s = 0;
        for  (int i = 0;i<=n; i++){
            s = s + i;
        }
        
        return s;
    }
}
