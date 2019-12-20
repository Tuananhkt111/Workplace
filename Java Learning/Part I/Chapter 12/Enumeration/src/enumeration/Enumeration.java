/*
An enumeration of apple varieties.
 */
package enumeration;
enum Apple
{
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}
public class Enumeration
{
    public static void main(String[] args)
    {
        Apple ap;
        ap = Apple.RedDel;
        //Output an enum value.
        System.out.println("Value of ap: " + ap + "\n");
        //Compare two enum values
        ap = Apple.GoldenDel;
        if(ap == Apple.GoldenDel)
            System.out.println("ap contains GoldenDel.\n");
        //Use enum to control a switch statement
        switch(ap)
        {
            case Jonathan: System.out.println("Jonathan is red."); break;
            case GoldenDel: System.out.println("GoldenDel is yellow."); break;
            case RedDel: System.out.println("RedDel is red."); break;
            case Winesap: System.out.println("Winesap is red."); break;
            case Cortland: System.out.println("Cortland is red."); break;
        }
    }
    
}
