package bai_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Bai8_ {
    public static void main(String[] args) {
        String sourceFile = "Bai_1\\src\\bai_1\\y2meta.com-Greetings in ASL _ ASL - American Sign Language.mp4";
        String destFile = "Bai_1\\src\\bai_1\\des-126.mp4";
        
        try {
            // Tạo luồng đọc và ghi
            FileInputStream fr = new FileInputStream(sourceFile);
            FileOutputStream fw = new FileOutputStream(destFile);

            
            byte[] buffer = new byte[10000];
            // Đọc từng dòng và ghi vào file đích
            int bytesRead;
            while ((bytesRead = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, bytesRead);
            }
            
            // Đóng các luồng
            fr.close();
            fw.close();
            System.out.println("Sao chép file thành công!");
            
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}
