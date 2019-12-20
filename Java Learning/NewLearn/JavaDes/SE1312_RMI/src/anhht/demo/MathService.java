/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.demo;

import java.rmi.Remote;

/**
 *
 * @author tuana
 */
public interface MathService extends Remote {
    int add(int x, int y) throws Exception;
    int sub(int x, int y) throws Exception;
}
