package clientbac2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;

public class Bac2Client {
    public static void main(String[] args) throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            Registry reg = LocateRegistry.getRegistry("localhost",9999);
            System.out.println("Client dang tim kiem doi tuong Remote tren Server!");
            Bac2_class m = (Bac2_class)reg.lookup("Server");
            
            System.out.println("1. a b c ngau nhien \n2. Nhap a,b,c tu ban phim!");
            
            System.out.println("Hay nhap lua chon: ");
            int n = sc.nextInt();
            int a = 0, b = 0, c = 0;
            String result;
            
            if (n == 1){
                Random random = new Random(); 
                a = random.nextInt(81) + 20; // Random value between 20 and 100 
                b = random.nextInt(81) + 20; 
                c = random.nextInt(81) + 20; 
                System.out.println("Gia tri ngau nhien: a=" + a + ", b=" + b + ", c=" + c);
                result = m.Bac2(a, b, c);
                System.out.println("Ket qua: \n" + result);
            }else if (n == 2){
                System.out.println("Nhap gia tri a;b;c tu ban phim (vi du: 1;2;3): ");
                String input = sc.next(); 
                String[] parts = input.split(";"); 
                a = Integer.parseInt(parts[0]); 
                b = Integer.parseInt(parts[1]); 
                c = Integer.parseInt(parts[2]);
                
                result = m.Bac2(a, b, c);
                System.out.println("Ket qua: \n " + result);
            }
        } catch (NumberFormatException | NotBoundException | RemoteException e) {
            System.out.println(" Không tìm thấy đối tượng Remote trên Server");
        }
    }
}
