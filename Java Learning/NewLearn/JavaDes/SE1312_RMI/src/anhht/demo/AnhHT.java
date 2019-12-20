/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.demo;

import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tuana
 */
public class AnhHT extends UnicastRemoteObject implements MathService{

    public AnhHT() throws Exception {
    }
    
    @Override
    public int add(int x, int y) throws Exception {
        return x + y;
    }

    @Override
    public int sub(int x, int y) throws Exception {
        return x - y;
    }
    
}
