package bai6_rmi;

import bai6_rmi.XinChao;
import bai6_rmi.XinChaoImp;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main (String[] args) throws MalformedURLException{
        try
        { 
            System.out.println("*------------------------*");
            System.out.println("*CHUONG TRINH TREN SERVER*");
            System.out.println("*------------------------*");

            // Tao doi tuong Registry voi port =9999
            Registry reg = LocateRegistry.createRegistry(9999);
            // Tao doi tuong Remote 
            XinChao h = (XinChao)new XinChaoImp(); // Kieu la Interface
            //Dang ky doi tuong RMI va Rang buoc vao Server CS420SA 
            reg.rebind("rmi://localhost/NetApp",h); // CS420SA: Ten hoac duong dan den may Server
            System.out.println(" Đối tượng từ xa đã được đăng ký. ");
            System.out.println(" Server đang đợi yêu cầu từ Client! ");
        }
        catch(RemoteException e)
        {
            System.out.println("Không thể tạo đượcc đối tượng Remote!");
        }
    } 
}
