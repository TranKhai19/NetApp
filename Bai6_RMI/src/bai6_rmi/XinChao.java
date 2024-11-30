/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bai6_rmi;

/**
 *
 * @author ADMIN
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface XinChao extends Remote{
    public String hello(String loichao) throws RemoteException;
}
