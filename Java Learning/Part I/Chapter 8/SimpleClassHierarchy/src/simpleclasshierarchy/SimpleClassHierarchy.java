/*
Using super to overcome name hiding.
 */
package simpleclasshierarchy;
class A
{
    int i;
}
//Create a subclass by extending class A.
class B extends A
{
    int i; //this i hides the i in A
    B(int a, int b)
    {
        super.i = a; //i in A
        i = b; //i in B
    }
    void show()
    {
        System.out.println("in in superclass: " + super.i);
        System.out.println("i in subclass: " + i);
    }
}
public class SimpleClassHierarchy
{
    public static void main(String[] args)
    {
        B subOb = new B(1, 2);
        subOb.show();
    }
    
}
