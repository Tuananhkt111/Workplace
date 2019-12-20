
package multilvhierarchyver2;
public class Box
{
    private double width, height, depth;
    //construct clone of an object
    Box(Box ob)
    {
        //pass object to constructor
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }
    //constructor used when all dimensions specified
    Box(double w, double h, double d)
    {
        width = w;
        height = h;
        depth = d;
    }
    //constructor used when cube is created
    Box(double len)
    {
        width = height = depth = len;
    }
    //constructor used when no dimensions specified
    Box()
    {
        width = height = depth = -1;
    }
    //compute and return volume
    double volume()
    {
        return width*height*depth;
    }
}
