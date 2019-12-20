/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

/**
 *
 * @author tuana
 */
public class MyUtil {
    public static int countPrice(int estPrice, int estDurantion, int duration, int surchargeHr, float discount) {
        int result = estPrice;
        result += (duration - estDurantion)*surchargeHr;
        return (int) (result*(1 - discount));
    }
}
