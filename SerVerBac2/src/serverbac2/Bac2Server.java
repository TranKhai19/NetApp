/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverbac2;

/**
 *
 * @author ADMIN
 */

import java.rmi.Remote;
import java.rmi. RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Bac2Server {
    public static void main(String[] args) throws RemoteException {
        try{
            System.out.println("*------------------------*");
            System.out.println("*CHUONG TRINH TREN SERVER*");
            System.out.println("*------------------------*");        
            
            Registry reg = LocateRegistry.createRegistry(9999);
            
            Bac2_class b2 = (Bac2_class) new Bac2Imp();
            
            reg.rebind("Server", b2);
            
            System.out.println("Doi tuong tu xa da duoc dang ky!");
            System.out.println("Server dang doi yeu cau tu client");
        }catch (RemoteException ex){
            System.out.println("Khong the tao duoc doi tuong!");
        }
    }
}
