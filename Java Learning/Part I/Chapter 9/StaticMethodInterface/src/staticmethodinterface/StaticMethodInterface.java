/*
 static methods in interface
 */
package staticmethodinterface;
interface MyIF
{
    //this is a "normal" interface method declaration.
    //It does NOT implement define a default implementation.
    int getNumber();
    //This a default method. Notice that it provides a default implementation.
    default String getString()
    {
        return "Default String";
    }
    //This is a static interface method
    static int getDefaultNumber()
    {
        return 0;
    }
}
public class StaticMethodInterface
{
    public static void main(String[] args)
    {
        System.out.println(MyIF.getDefaultNumber());
    }
    
}
