/*
A Superclass variable can reference a subclass object
 */
package refdemo;
class Box
{
    double width, height, depth;
    //construct clone of an object
    Box(Box ob) // pass an object to constructor
    {
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
 //Here, box is extended to invlude weight
class BoxWeight extends Box
    {
        double weight;
        BoxWeight(double w, double h, double d, double m)
        {
            width = w;
            height = h;
            depth = d;
            weight = m;
        }
    }
public class RefDemo
{
    public static void main(String[] args)
    {
        BoxWeight weightbox = new BoxWeight(3, 5, 7, 8.37);
        Box plainbox = new Box();
        double vol = weightbox.volume();
        System.out.println("Volume of weightbox is " + vol);
        System.out.println("Weight of weightbox is " + weightbox.weight);
        System.out.println();
        //assign BoxWeight reference to Box reference
        plainbox = weightbox;
        vol = plainbox.volume();
        System.out.println("Volume of plainbox is " + vol);
        // The following statement is invalid because plainbox does not define a weight member.
        // System.out.println("Weight of plainbox is " + plainbox.weight);
    }
}
