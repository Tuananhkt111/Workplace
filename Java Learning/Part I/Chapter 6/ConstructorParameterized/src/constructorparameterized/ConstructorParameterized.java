/*
] Here, Box uses a constructor to initialize dimensions of the box.
 */
package constructorparameterized;
class Box
{
    double width, height, depth;
    //This is the constructor of the box
    Box(double w, double h, double d)
    {
        System.out.println("Constructing Box");
        depth = d;
        width = w;
        height = h;
    }
    // compute and return volume
    double volume()
    {
        return depth*width*height;
    }
}
public class ConstructorParameterized
{
    public static void main(String[] args)
    {
        //declare, allocate, and intialize Box objects
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box(3, 6, 9);
        double vol;
        //get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume is " + vol);
        //get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
    }   
}
