// Demonstrate TwoGen.
package generic2types;
public class Generic2Types
{
    public static void main(String[] args)
    {
        TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Generic Test");
        // Show the types.
        tgObj.showTypes();
        // Obtain and show values.
        int t = tgObj.getob1();
        System.out.println("value:" + t + "\n");
        String str = tgObj.getob2();
        System.out.println("value:" + str + "\n");
        
    }
    
}
