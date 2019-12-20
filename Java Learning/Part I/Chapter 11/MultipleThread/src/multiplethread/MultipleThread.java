/*
  Create multiple threads.
 */
package multiplethread;
public class MultipleThread
{
    public static void main(String[] args)
    {
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");//Starts the thread
        try
        {
            //wait for other threads to end
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting.");
    }
    
}
