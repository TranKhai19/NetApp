/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6_rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CalServer {
    public static void main(String[] args) {
        try {
            System.out.println("*------------------------*");
            System.out.println("*CHUONG TRINH TREN SERVER*");
            System.out.println("*------------------------*");
            
            Registry reg = LocateRegistry.createRegistry(9999);
            
            Cal c = (Cal) new CalImp();
            
            reg.rebind("rmi://localhost/NetApp", c);
            
            System.out.println("Doi tuong tu xa da duoc dang ky!");
            System.out.println("Server dang doi yeu cau tu Client!");
        } catch (RemoteException ex) {
            System.out.println("Không thể tạo đượcc đối tượng Remote!");
        }
    }
}
