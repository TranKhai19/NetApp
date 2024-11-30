/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6_rmi;
/**
 *
 * @author ADMIN
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalImp extends UnicastRemoteObject implements Cal{
    public CalImp() throws RemoteException{
    }

    @Override
    public int sum(int n) throws RemoteException {
        return n*(n+1)/2;
    }
}
