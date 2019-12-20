package joinmethod;
class NewThread implements Runnable
{
    Thread t;
    String name;
    NewThread(String threadname)
    {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        
    }
    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }
}
