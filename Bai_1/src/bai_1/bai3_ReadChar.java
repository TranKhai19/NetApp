package bai_1;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class bai3_ReadChar {
    public static void main(String[] args) throws IOException {
        System.out.println("Nhap chuoi bat ky tu ban phim: ");

        // BufferedReader là lớp trừu tượng nên phải dùng lớp con của nó
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println("Chuoi vua nhap: ");
        int i = 0;
        char c;
        do{
            c = str.charAt(i);
            System.out.print(c);
            i++;
        }while(c != '.');

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi bat ky tu ban phim: ");
        
        do{
            c = (char)sc.nextInt();
            System.out.print(c);
        }while(c != '.');
    }    
}
