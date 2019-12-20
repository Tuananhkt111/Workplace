/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueorder1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuana
 */
public class MyQueue {

    protected MyNode head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        return head.info;
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!");
        }
        int x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return x;
    }

    void enqueue(int x) {
        if (isEmpty()) {
            head = tail = new MyNode(x);
        } else {
            tail.next = new MyNode(x);
            tail = tail.next;
        }
    }

    void sort() {
        try {
            MyQueue tmpQueue1 = new MyQueue();
            MyQueue tmpQueue2 = new MyQueue();
            while (!this.isEmpty()) {
                tmpQueue1.enqueue(this.dequeue());

                while (!tmpQueue1.isEmpty()) {
                    int temp = tmpQueue1.dequeue();
                    while (!tmpQueue2.isEmpty() && tmpQueue2.front() > temp) {
                        if (tmpQueue2.front() > temp) {
                            tmpQueue1.enqueue(tmpQueue2.dequeue());
                        }
                    }
                    tmpQueue2.enqueue(temp);
                }
            }
            while (!tmpQueue2.isEmpty()) {
                this.enqueue(tmpQueue2.dequeue());
            }
        } catch (Exception ex) {
            Logger.getLogger(MyQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
