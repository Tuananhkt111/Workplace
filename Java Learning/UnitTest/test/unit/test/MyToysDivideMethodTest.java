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
public class MyToysDivideMethodTest {
    @Test
    public void testNormalCase() {
        assertEquals(3, MyToys.divide(10, 3));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptCase() {
        MyToys.divide(10, 0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
