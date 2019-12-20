/*
A complete implementation of BoxWeight. 
 */
package superkeyword;
class Box
{
    private double width, height, depth;
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
//BoxWeight now fully implements all constructors.
class BoxWeight extends Box
{
    double weight; //weight of Box
    //Construct clone of an object
    BoxWeight(BoxWeight ob) 
    {
        //pass object to constructor
        super(ob);
        weight = ob.weight;
    }
    //Construct when all parameters are specified
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
public class SuperKeyword
{
    public static void main(String[] args)
    {
        BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.076);
        BoxWeight mybox3 = new BoxWeight(); //default
        BoxWeight mycube = new BoxWeight(3, 2);
        BoxWeight myclone = new BoxWeight(mybox1);
        double vol;
        
        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is " + vol);
        System.out.println("Weight of mybox1 is " + mybox1.weight);
        System.out.println();
        
        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);
        System.out.println("Weight of mybox2 is " + mybox2.weight);
        System.out.println();
        
        vol = mybox3.volume();
        System.out.println("Volume of mybox3 is " + vol);
        System.out.println("Weight of mybox3 is " + mybox3  .weight);
        System.out.println();
        
        vol = mycube.volume();
        System.out.println("Volume of mycube is " + vol);
        System.out.println("Weight of mycube is " + mycube.weight);
        System.out.println();
        
        vol = myclone.volume();
        System.out.println("Volume of myclone is " + vol);
        System.out.println("Weight of myclone is " + myclone.weight);
        System.out.println();
        
    }
    
}
