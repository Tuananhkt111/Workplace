package tools;

import tunkunn.util.MyToys;

public class Tools {
    public static void main(String[] args) {
        int n = MyToys.getAnInteger("Input an integer: "); // quen: Math.sqrt(), System.in, .out
        System.out.println("n: " + n);
        int yob = MyToys.getAnInteger("Input yob: ");
        System.out.println("yob: " + yob);
    }
    
}
