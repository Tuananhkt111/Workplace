package customexception;
class ExceptionDemo
{
    static void compute(int a) throws MyException
    {
        System.out.println("Called compute (" + a + ")");
        if (a > 10)
            throw new MyException(a);
        System.out.println("Normal exit");
    }
}
