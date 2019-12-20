/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1312_rmi;

import anhht.demo.AnhHT;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author tuana
 */
public class SE1312_RMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String serviceName = "rmi://localhost:1098/Math1";
        AnhHT server;
        try {
            server = new AnhHT();
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service is running......");
        } catch (Exception e) {
        }
    }
    
}
