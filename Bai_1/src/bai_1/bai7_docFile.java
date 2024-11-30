package bai_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class bai7_docFile {
    public static void main(String[] args) throws IOException{
        try(FileInputStream reader = new FileInputStream("Bai_1\\src\\bai_1\\ITMedia3-126.jpg")){
            int c;
            while((c = reader.read()) != -1){
                System.out.print((char)c);
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        } 
        try(FileInputStream reader = new FileInputStream("Bai_1\\src\\bai_1\\des-126.jpg")){
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
