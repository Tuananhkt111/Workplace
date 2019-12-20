/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author tuana
 */
public class Node {

    int info;
    Node next;

    public Node() {
    }

    public Node(int x, Node p) {
        info = x;
        next = p;
    }
}
