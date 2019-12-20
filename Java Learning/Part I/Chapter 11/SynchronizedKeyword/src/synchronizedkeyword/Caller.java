package synchronizedkeyword;
class Caller implements Runnable
{
    String msg;
    Callme target;
    Thread t;
    public Caller(Callme targ, String s)
    {        
        msg = s;
        target = targ;
        t = new Thread(this);
    }
    public void run()
    {
       target.call(msg);
    }
}
