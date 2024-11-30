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

public class XinChaoImp extends UnicastRemoteObject implements XinChao{
    public XinChaoImp() throws RemoteException{
    }
    
    @Override
    public String hello(String loichao){
        return "Hello, Toi ten la "+loichao;
    }
}
