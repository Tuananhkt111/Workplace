package suspendingresuming;

class NewThread implements Runnable
{
    String name; //name of thread
    Thread t;
    boolean suspendFlag;
    NewThread(String name)
    {
        this.name = name;
        t = new Thread(this, this.name);
        System.out.println("Thread: " + t);
        suspendFlag = false;
        t.start(); //start the thread
    }
    //This is the entry point for thread
    public void run()
    {
        try
        {
            for(int i = 15; i > 0; i--)
            {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized(this)
                {
                    while(suspendFlag)
                        wait();
                }
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }
    synchronized void mysuspend()
    {
        suspendFlag = true;
    }
    synchronized void myresume()
    {
        suspendFlag = false;
        notify();
    }
}
