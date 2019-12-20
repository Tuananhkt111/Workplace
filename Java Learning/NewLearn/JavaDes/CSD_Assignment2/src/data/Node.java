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
    String word;
    MyLinkedList meaningList = new MyLinkedList();
    Node left, right;

    public Node(String word, MyLinkedList meaningList) {
        this.word = word;
        this.meaningList.addAll(meaningList);
        left = right = null;
    }

    public String getWord() {
        return word;
    }

    public MyLinkedList getMeaningList() {
        return meaningList;
    }
       
}
