package bai_1;

import java.io.IOException;

public class bai1_ReadBytes {
    public static void main(String[] args) {
        try{
            byte[] bytes = new byte[100];
            System.out.println("Nhap mang byte: ");
            System.in.read(bytes);

            System.out.println("Mang byte vua nhap: ");
            for (int i = 0; i < bytes.length; i++){
                System.out.print(bytes[i]);
            }
        } catch (IOException e) {

            System.out.println("Loi" + e.getMessage()); 
        }
    }  
}

