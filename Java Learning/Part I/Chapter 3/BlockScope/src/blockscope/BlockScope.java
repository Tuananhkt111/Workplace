/*
  Demonstrate block scope.
 */
package blockscope;
public class BlockScope
{
    public static void main(String[] args)
    {
        int x = 10; //know to all code within main
        if(x == 10)
        {
            //start new scope
            int y = 20; // known only to this block
            //x and y both known here.
            System.out.println("x and y: " + x + " " + y);
            x = y * 2;
        }
        // y = 100; // Error! y not known here
        //x still known here
        System.out.println("x is " + x);
    }
}
