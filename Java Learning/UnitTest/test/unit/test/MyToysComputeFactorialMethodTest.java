/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.test;

import anhht.util.MyToys;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuana
 */
public class MyToysComputeFactorialMethodTest {

    //Ta van~ xai MyToys nhung test ham computeFactorial
    //2 tinh huong:
    //dua vao so am: bi chui
    @Test
    public void testNormalCase() {
        assertEquals(5, MyToys.computeFactorial(3));
        assertEquals(120, MyToys.computeFactorial(5));
        assertEquals(720, MyToys.computeFactorial(6));
        assertEquals(1, MyToys.computeFactorial(1));
        assertEquals(1, MyToys.computeFactorial(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptCase() {
        MyToys.computeFactorial(-2);
        MyToys.computeFactorial(-223);
        MyToys.computeFactorial(-230);
        MyToys.computeFactorial(-1000);
    }
}
