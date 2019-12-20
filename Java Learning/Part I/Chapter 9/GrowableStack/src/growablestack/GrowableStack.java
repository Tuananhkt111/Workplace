/*
Implement a "growable" stack.
 */
package growablestack;
interface IntStack
{
    void push(int item); //store an item
    int pop(); //retrieve an item
}
class Dynstack implements IntStack
{
    private int tos, stck[];
    Dynstack(int size)
    {
        tos = -1;
        stck = new int[size];
    }
    //push an item onto the stack
    @Override
    public void push(int item)
    {
        //if stack is full, allocate a larger stack
        if(tos == stck.length - 1)
        {
            int temp[] = new int[stck.length*2]; //double size
        for(int i = 0; i < stck.length; i++)
            temp[i] = stck[i];
        stck = temp;
        stck[++tos] = item;
        }
        else stck[++tos] = item;
    }
    //pop an item from the stack
    @Override
    public int pop()
    {
        if(tos < 0)
        {
            System.out.println("Stack underflow");
            return 0;
        }
        else return stck[tos--];
    }
}
public class GrowableStack
{
    public static void main(String[] args)
    {
        Dynstack mystack1 = new Dynstack(5);
        Dynstack mystack2 = new Dynstack(8);
        //these loop cause each stack to grow
        for(int i = 0; i < 12; i++) mystack1.push(i);
        for(int i = 0; i < 20; i++) mystack2.push(i);
        System.out.println("Stack in mystack1: ");
        for(int i = 0; i < 12; i++)
            System.out.println(mystack1.pop());
        System.out.println("Stack in mystack2: ");
        for(int i = 0; i < 20; i++)
            System.out.println(mystack2.pop());
    }
    
}
