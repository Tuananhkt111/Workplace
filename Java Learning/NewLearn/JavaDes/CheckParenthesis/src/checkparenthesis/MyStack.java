/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkparenthesis;

import java.util.LinkedList;

/**
 *
 * @author tuana
 */
public class MyStack {
    LinkedList<Character> h;

    public MyStack() {
        h = new LinkedList();
    }
    boolean isEmpty() {
        return h.isEmpty();
    }
    void push(char x) {
        h.add(x);
    }
    Character pop() {
        if(isEmpty()) return null;
        return h.removeLast();
    }
    
    Character top() {
        if(isEmpty()) return null;
        return h.getLast();
    }
    void clear() {
        h.clear();
    }
}
