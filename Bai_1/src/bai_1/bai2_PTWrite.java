package bai_1;

import java.io.IOException;
import java.util.Scanner;

public class bai2_PTWrite {
    public static void main(String[] args) throws IOException {
        char a = 'X';
        int b;
        b=a;

        System.out.write(b);
        System.out.flush();
        // Nhận xét: Khi dùng hàm write() để xuất ra màn hình thì phải hàm flush()
        // Hàm flush() tự động ép kiểu từ write()
    }
}
