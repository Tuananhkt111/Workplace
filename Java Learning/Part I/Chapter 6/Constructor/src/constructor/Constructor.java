/*
] Here, Box uses a constructor to initialize dimensions of the box.
 */
package constructor;
class Box
{
    double width, height, depth;
    //This is the constructor of the box
    Box()
    {
        System.out.println("Constructing Box");
        depth = width = height =10;
    }
    // compute and return volume
    double volume()
    {
        return depth*width*height;
    }
}
public class Constructor
{
    public static void main(String[] args)
    {
        //declare, allocate, and intialize Box objects
        Box mybox1 = new Box();
        Box mybox2 = new Box();
        double vol;
        //get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume is " + vol);
        //get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
    }   
}
