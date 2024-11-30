package bai6_rmi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cal extends Remote{
    public int sum(int n)throws RemoteException;
}
