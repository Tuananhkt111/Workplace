package pkg2ndthreadver2;
class NewThread extends Thread
{
    NewThread()
    {
        //Ctreate a new, second thread
        super("NewThread");
        System.out.println("Child thread: " + this);
        start(); //Start the thread
    }
    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}
