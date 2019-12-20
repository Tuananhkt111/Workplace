/*
Create a second thread by extending Thread
 */
package pkg2ndthreadver2;
public class Main
{

    public static void main(String[] args)
    {
        new NewThread(); //create new thread
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
    
}
