/*
A simple interface.
 */
package simpleinterface;
interface Concu
{
    void Printconcu();
    int i = 1;
}
class Aanas implements Concu
{
    @Override
    public void Printconcu()
    {
        System.out.println("Concu");
    }
    void printi()
    {
        System.out.println("i is " + i);
    }
}
public class SimpleInterface
{
    public static void main(String[] args)
    {
        Aanas ap = new Aanas();
        ap.Printconcu();
        ap.printi();
    }
}
