/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6_rmi;

/**
 *
 * @author ADMIN
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args)throws Exception
    {
        try  
        {
            // Tạo bo dang ky de ket noi den Server voi dia chi la "localhost" va port 9999
            Registry reg = LocateRegistry.getRegistry("localhost",9999);
            //Thuchien remote doi tuong tren Server CS420SA 
            XinChao m = (XinChao)reg.lookup("rmi://localhost/NetApp");
            System.out.println(" Client print: Hello! What are your name?");
            System.out.println(" Server print:"+m.hello("Lan"));
        }
        catch (NotBoundException | RemoteException e)
        {
            System.out.println(" Không tìm thấy đối tượng Remote trên Server CS420SA");
        }
    }

}
