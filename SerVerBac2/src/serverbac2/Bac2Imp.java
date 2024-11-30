/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverbac2;

/**
 *
 * @author ADMIN
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Bac2Imp extends UnicastRemoteObject implements Bac2_class{
    public Bac2Imp() throws RemoteException{}
 
    @Override
    public String Bac2(int a, int b, int c) throws RemoteException {
        if (a==0){
            if (b==0){
                return "Phuong trinh vo nghiem!";
            }else{
                return "Phuong trinh co nghiem x = " + (-c/b);
            }
        }
        
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        
        if (delta > 0){
            
            x1 = (float) ((-b + Math.sqrt(delta))/(2*a));
            x2 = (float) (-b - Math.sqrt(delta))/(2*a);
            
            return "Phuong trinh co 2 nghiem \n x1 = " + x1 + "\n x2 = " + x2;
        }else if (delta == 0){
            x1 = (-b/2*a);
            return "Phuong trinh co nghiem kep x1 = x2 = " + x1;
        }
        return "Pnuong trinh vo nghiem!";
    }   
}
