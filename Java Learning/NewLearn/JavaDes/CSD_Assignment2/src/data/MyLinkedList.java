/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author tuana
 */
public class MyLinkedList extends LinkedList<String> {
    public String traverse() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            if(i != size() - 1) {
                result += (get(i) + ", ");
            } else {
                result += get(i);
            }            
        }
        return result;
    }

    public void removeDuplicates() {
        Collections.sort(this);
        if (!isEmpty()) {
            int i = 0;
            while (i + 1 < size()) {
                if(get(i).equalsIgnoreCase(get(i + 1))) {
                        remove(i + 1);
                }
                i++;
            }
        }
    }
}
