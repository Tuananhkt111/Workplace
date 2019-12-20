/*
  This class defines an integer stack that can holds 10 values
 */
package stack;
class StackType
{
    int stck[] = new int[10];
    int tos;
    //initializes top-of-stack
    StackType()
    {
        tos = -1;
    }
    //Push an item onto the stack
    void push(int item)
    {
        if(tos == 9)
            System.out.println("Stack overflow.");
        else stck[++tos] = item;
    }
    //pop anitem from stack
    int pop()
    {
        if(tos < 0)
        {
            System.out.println("Stack underflow.");
            return 0;
        }
        else return stck[tos--];
    }
}
public class Stack
{
    public static void main(String[] args)
    {
        StackType mystack1 = new StackType();
        StackType mystack2 = new StackType();
        //push some numbers onto the stack
        for(int i = 0; i < 10; i++) mystack1.push(i);
        for(int i = 10; i < 20; i++) mystack2.push(i);
        //pop those numbers off those stacks
        System.out.println("Stack in mystack1: ");
        for(int i = 0; i < 10; i++)
            System.out.println(mystack1.pop());
        System.out.println("Stack in mystack2: ");
        for(int i = 0; i < 10; i++)
            System.out.println(mystack2.pop());
        
    }
    
}
