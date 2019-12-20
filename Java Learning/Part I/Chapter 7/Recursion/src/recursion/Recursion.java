/*
  Another example of recursion.
 */
package recursion;
class RecTest
{
    int values[];
    RecTest(int i)
    {
        values = new int[i];
    }
    //displays array -- recursively
    void printArray(int i)
    {
        if (i == 0) return;
        else printArray(i - 1);
        System.out.println("[" + (i - 1) + "]" + values[i - 1]);
    }
}
public class Recursion
{
    public static void main(String[] args)
    {
        RecTest ob1 = new RecTest(10);
        for(int i = 0; i < 10; i++)
            ob1.values[i] = i;
        ob1.printArray(10);
    }
    
}
