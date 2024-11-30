import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerPTB2 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8888)) {
            System.out.println("Server da khoi dong");

            while (true) {
                try (Socket client = server.accept();
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("Ket noi tu " + client.getInetAddress());
                    out.println("Chon 1 trong cac truong hop sau");
                    out.println("1. Nhap a,b,c");
                    out.println("2. Doc tu file");
                    out.println("3. Quit");

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.equalsIgnoreCase("3")) {
                            out.println("Da thoat.");
                            break;
                        } else if (inputLine.equalsIgnoreCase("1")) {
                            out.println("Nhap a b c (cach nhau bang 1 khoang trang):");
                            String coefficients = in.readLine();
                            String[] parts = coefficients.split(" ");
                            if (parts.length == 3) {
                                try {
                                    double a = Double.parseDouble(parts[0]);
                                    double b = Double.parseDouble(parts[1]);
                                    double c = Double.parseDouble(parts[2]);
                                    String result = calculateQuadratic(a, b, c);
                                    out.println(result);
                                } catch (NumberFormatException e) {
                                    out.println("Vui long nhap a b c la 1 so nguyen hop le!");
                                }
                            } else {
                                out.println("Vui long nhap dung dinh dang a b c");
                            }
                        } else if (inputLine.equalsIgnoreCase("2")) {
                            out.println("Nhap mot ten file (vi du: numbers.txt):");
                            String fileName = in.readLine();
                            readFromFile(fileName, out);
                        } else {
                            out.println("Lua chon khong hop le. Vui long chon lai!");
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Loi ket noi: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Loi khoi dong server: " + e.getMessage());
        }
    }

    private static String calculateQuadratic(double a, double b, double c) {
        if (a == 0) {
            return "Khong phai phuong trinh bac 2";
        }
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Co 2 nghiem x1= " + root1 + ", x2 = " + root2;
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return "Co 1 nghiem: x = " + root;
        } else {
            return "Khong co nghim thuc";
        }
    }

    private static void readFromFile(String fileName, PrintWriter out) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    try {
                        double a = Double.parseDouble(parts[0]);
                        double b = Double.parseDouble(parts[1]);
                        double c = Double.parseDouble(parts[2]);
                        String result = calculateQuadratic(a, b, c);
                        out.println(result);
                    } catch (NumberFormatException e) {
                        out.println("Du lieu trong file khong hop le");
                    }
                } else {
                    out.println("Dữ lDu lieu trong file khong dung dinh dang");
                }
            }
        } catch (IOException e) {
            out.println("Loi doc file " + e.getMessage());
        }
    }
}