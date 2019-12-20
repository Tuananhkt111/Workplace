/*
  Using break as a civilized form of goto.
 */
package breaklabel;
public class BreakLabel
{
    public static void main(String[] args)
    {
        boolean t = true;
        first: 
        {
            second:
            {
                third:
                {
                    System.out.println("Before the break");
                    if(t) break second; //breakout of second block
                    System.out.println("This won't execute");
                }
                System.out.println("This won't execute");
            }
            System.out.println("This is after second block.");
        }
    }
    
}
