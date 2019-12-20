/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;

/**
 *
 * @author Nguyen Quang Huy
 */
public class MyStack {

    LinkedList<Integer> h;

    public MyStack() {
        h = new LinkedList<>();
    }

    public boolean isEmpty() {
        return h.isEmpty();
    }

    public void push(int x) {
        h.add(x);
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        return h.removeLast();
    }

    Integer top() {
        if (isEmpty()) {
            return null;
        }
        return h.getLast();
    }

    public MyStack transfer() {
        MyStack tmp = new MyStack();
        while (!this.isEmpty()) {
            int temp = this.pop();
            tmp.push(temp);
        }
        MyStack tmp1 = new MyStack();
        while (!tmp.isEmpty()) {
            int temp = tmp.pop();
            tmp1.push(temp);
        }
        return tmp1;
    }

    public MyStack transfer1() {
        MyStack tmpStack = new MyStack();
        int count = 0;
        int temp;
        while (!this.isEmpty()) {
            tmpStack.push(this.pop());
            count++;
        }
        while (!tmpStack.isEmpty()) {
            this.push(tmpStack.pop());
        }
        for (int i = count; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (!this.isEmpty()) {
                    tmpStack.push(this.pop());
                }
            }
            temp = tmpStack.pop();
            for (int j = 0; j < i - 1; j++) {
                this.push(tmpStack.pop());
            }
            tmpStack.push(temp);
        }
        return tmpStack;
    }
}
