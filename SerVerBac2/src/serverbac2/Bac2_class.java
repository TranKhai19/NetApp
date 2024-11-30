/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package serverbac2;

/**
 *
 * @author ADMIN
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bac2_class extends Remote{
    public String Bac2(int a, int b, int c) throws RemoteException;
}
