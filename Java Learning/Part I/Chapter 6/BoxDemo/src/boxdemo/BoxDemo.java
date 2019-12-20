/*
  Aprogram that uses the Box class. 
  Call this file BoxDemo.java
 */
package boxdemo;
class Box
{
    double height;
    double width;
    double depth;
}
//This class declares an object of type Box
public class BoxDemo
{
    public static void main(String[] args)
    {
        Box mybox = new Box();
        double vol;
        //assigns values to mybox's instance variables
        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15;
        // compute volume of box
        vol = mybox.width * mybox.height * mybox.depth;
        System.out.println("Volume is " + vol);
    }
    
}
