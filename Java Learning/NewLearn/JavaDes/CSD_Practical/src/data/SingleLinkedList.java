/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.HashMap;

/**
 *
 * @author tuana
 */
public class SingleLinkedList {

    private Node head, tail;
    public SingleLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void add(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print("  " + p.info);
            p = p.next;
        }
        System.out.println();
    }

    public void sort() {
        boolean swapped;
        Node p1;
        Node p2 = null;
        if (head == null) {
            return;
        }
        do {
            swapped = false;
            p1 = head;

            while (p1.next != p2) {
                if (p1.info > p1.next.info) {
                    swap(p1, p1.next);
                    swapped = true;
                }
                p1 = p1.next;
            }
            p2 = p1;
        } while (swapped);
    }

    public void swap(Node p1, Node p2) {
        int temp;
        temp = p1.info;
        p1.info = p2.info;
        p2.info = temp;
    }

    public void removeDuplicates() {
        sort();
        if (!isEmpty()) {
            Node p = head;
            while (p.next != null) {
                while (p.info == p.next.info) {
                    if (p.next.next != null) {
                        p.next = p.next.next;
                    } else {
                        p.next = null;
                        return;
                    }
                }
                p = p.next;
            }
        }
    }

    public boolean isSorted() {
        if (isEmpty()) {
            return false;
        } else {
            Node p = head;
            int temp = head.info;
            p = p.next;
            while (p != null) {
                if (p.info >= temp) {
                    temp = p.info;
                } else {
                    return false;
                }
                p = p.next;
            }
        }
        return true;
    }
    
    public int findSmallest() {
        if (isEmpty()) {
            return -1;
        } else {
            int temp = 1;
            Node p;
            while (true) {
                p = head;
                while (p != null) {
                    if (temp == p.info) {
                        temp++;
                        break;
                    } else {
                        p = p.next;
                    }
                }
                if(p == null) {
                    return temp;
                }
            }
        }
    }
}
