package interthreadcommunication;
class Q
{
    int n;
    boolean valueSet = false;
    synchronized int get()
    {
        while(!valueSet)
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException Caught.");
            }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }
    synchronized void put(int n)
    {
        while(valueSet)
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("InterruptedException Caught.");
            }
        this.n = n;
        System.out.println("Put: " + n);
        valueSet = true;
        notify();
    }
}
