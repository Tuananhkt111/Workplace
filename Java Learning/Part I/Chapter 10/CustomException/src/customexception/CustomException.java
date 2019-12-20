/*
This program creataes a custom exception types.
 */
package customexception;
class MyException extends Exception
{
    private int detail;
    public MyException(int detail)
    {
        this.detail = detail;
    }    
    @Override
    public String toString()
    {
        return "MyException{" + detail + "}";
    }
}
public class CustomException
{
    public static void main(String[] args)
    {
        try
        {
            ExceptionDemo.compute(10);
            ExceptionDemo.compute(20); 
        } 
        catch (MyException e)
        {
            System.out.println("Caught " + e);
        }
    }    
}
