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
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    public void insert(String word, MyLinkedList meaningList) {
        if (root == null) {
            root = new Node(word, meaningList);
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            f = p;
            int temp = word.compareToIgnoreCase(p.word);
            if (temp < 0) {
                p = p.left;
            } else if (temp == 0) {
                p.meaningList.addAll(meaningList);
                p.meaningList.removeDuplicates();
                return;
            } else {
                p = p.right;
            }
        }
        if (f != null) {
            int temp = word.compareToIgnoreCase(f.word);
            if (temp < 0) {
                f.left = new Node(word, meaningList);
            } else if (temp > 0) {
                f.right = new Node(word, meaningList);
            }
        }
    }

    public Node search(Node p, String x) {
        if (p != null) {
            int temp = x.compareTo(p.word);
            if (temp < 0) {
                return search(p.left, x);                
            } else if (temp == 0) {
                return p;
            } else {
                return search(p.right, x);
            }
        }
        return null;
    }

    public String visit(Node p) {
        return p.word + " : " + p.meaningList.traverse() + "\n";
    }

    public String inOrder(Node p) {
        String result = "";
        if (p == null) {
            return result;
        }
        result += inOrder(p.left);
        result += visit(p);
        result += inOrder(p.right);
        return result;
    }

    public Node getRoot() {
        return root;
    }
    
}
