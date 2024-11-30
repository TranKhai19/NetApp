package bai_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bai5_ {
    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        String fileName = "Bai_1\\src\\bai_1\\test.txt";
        readFile(fileName);
    }
}
