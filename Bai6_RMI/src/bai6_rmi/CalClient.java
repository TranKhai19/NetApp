/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6_rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CalClient {
    public static void main(String[] args) throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            Registry reg = LocateRegistry.getRegistry("localhost",9999);
            
            Cal m = (Cal)reg.lookup("rmi://localhost/NetApp");
            
            System.out.println("Hay nhap so nguyen n: ");
            int n = sc.nextInt();
            
            System.out.println("Server print: "+m.sum(n));
            
        } catch (NotBoundException | RemoteException ex) {
            System.out.println(" Không tìm thấy đối tượng Remote trên Server CS420SA");
        }
        
    }
}
