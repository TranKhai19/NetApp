// 1.4. Hãy đọc các chuỗi từ console sử dụng BufferedReader, nhưng đến chữ “stop” thì ngừng lại. Có nhận xét gì khi sử dụng đối tượng đọc là Scanner?

package bai_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bai4_Stopword {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try{
            do{
                str = reader.readLine();
            }while(!str.equals("stop"));
        }catch(IOException e){
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi bat ky tu ban phim: ");
        String str2;
        do{
            str2 = sc.nextLine();
            System.out.println(str2);
        }while(!str2.equalsIgnoreCase("stop"));
    }
}
