/*
  Demonstrate an inner class.
 */
package innerclass;
class Outer
{
    int outer_x = 10;
    void test()
    {
        Inner inner = new Inner();
        inner.display();
    }
    //this is a nested class
    class Inner
    {
        void display()
        {
            System.out.println("display: outer_x = " + outer_x);
        }
    }
}
public class InnerClass
{
    public static void main(String[] args)
    {
        Outer outer = new Outer();
        outer.test();
    }
    
}
