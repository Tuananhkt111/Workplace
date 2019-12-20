/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortascstack;

import java.util.LinkedList;

/**
 *
 * @author tuana
 */
public class MyStack {
    LinkedList<Integer> h;

    public MyStack() {
        h = new LinkedList();
    }
    boolean isEmpty() {
        return h.isEmpty();
    }
    void push(int x) {
        h.add(x);
    }
    Integer pop() {
        if(isEmpty()) return null;
        return h.removeLast();
    }
    
    Integer top() {
        if(isEmpty()) return null;
        return h.getLast();
    }
    
    void clear() {
        h.clear();
    }
    
    void sort() {
        MyStack tmpStack = new MyStack();
        while(!this.isEmpty()) {
            int temp = pop();
            while(!tmpStack.isEmpty() && tmpStack.top() < temp) {
                this.push(tmpStack.pop());
            }
            tmpStack.push(temp);
        }
        while(!tmpStack.isEmpty()) {
            this.push(tmpStack.pop());
        }
    }
}
