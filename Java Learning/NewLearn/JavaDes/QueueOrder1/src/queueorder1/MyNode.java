/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueorder1;

/**
 *
 * @author tuana
 */
public class MyNode {
    public int info;
    public MyNode next;

    public MyNode(int info, MyNode next) {
        this.info = info;
        this.next = next;
    }

    public MyNode(int info) {
        this(info, null);
    } 
}
