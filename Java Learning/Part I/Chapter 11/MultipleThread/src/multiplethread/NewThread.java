package multiplethread;
class NewThread implements Runnable
{
    Thread t;
    String name; // name of thread
    NewThread(String name)
    {
        this.name = name;
        t = new Thread(this, this.name);
        System.out.println("New thread: " + t);
        t.start(); //Start the thread
    }
    //This is the entry point for thread
    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println(name + ":" + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting.");
    }
}
