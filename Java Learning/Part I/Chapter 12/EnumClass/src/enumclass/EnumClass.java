/*
Use an enum constructor, instance variables and method.
 */
package enumclass;
public class EnumClass
{
    public static void main(String[] args)
    {
        //Display price of Winesap
        System.out.println("Winesap costs " + Apple.Winesap.getprice() + " cents.\n");
        //Display all apples and prices
        System.out.println("All apple prices:");
        for(Apple a: Apple.values())
            System.out.println(a + " costs " + a.getprice() + " cents.");
    }
    
}
