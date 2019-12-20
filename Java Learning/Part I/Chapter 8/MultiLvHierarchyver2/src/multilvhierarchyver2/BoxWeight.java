/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilvhierarchyver2;

/**
 *
 * @author Tuan Anh
 */
public class BoxWeight extends Box
{
    double weight;
    //construct clone of an object
    BoxWeight(BoxWeight ob)
    {
        //pass object to constructor
        super(ob);
        weight = ob.weight;
    }
    //constructor used when all dimensions specified
    BoxWeight(double w, double h, double d, double m)
    {
        super(w, h, d);
        weight = m;
    }
    //default constructor
    BoxWeight()
    {
        super();
        weight = -1;
    }
    //constructor used when cube is created
    BoxWeight(double len, double m)
    {
        super(len);
        weight = m;
    }
}
