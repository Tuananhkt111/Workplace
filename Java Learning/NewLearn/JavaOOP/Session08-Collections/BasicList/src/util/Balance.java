/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.Student;
import java.util.Comparator;

/**
 *
 * @author Tuan Anh
 */
public class Balance implements Comparator<Student> {
   //Day la cai can dung de can hai obj nao do 
   //vay ta can dua vao 2 obj, tu ta luc loi ben trong obj de loi ra value
    //class nay khong can quan tam thuoc tinh rieng, nen ta cung chang can field
    //khoi can constructor, JVM tu dong tao ra 1 cst rong/default
    @Override
    public int compare(Student left, Student right) {
        return left.getId().compareToIgnoreCase(right.getId());
    }
}
