// Demonstrate a simple lambda expression. 
package simplelambdaexpression;
public class SimpleLambdaExpression
{
    public static void main(String[] args)
    {
        MyNumber mynum;
        mynum = () -> 123.45;
        System.out.println("A fixed value: " + mynum.getValue());
        mynum = () -> Math.random()*100;
        System.out.println("A random value: " + mynum.getValue());
        System.out.println("Another radon value: " + mynum.getValue());
        
        NumericTest isEven = (n) -> (n%2) == 0;
        if(!isEven.test(9)) System.out.println("9 is not even.");
        if(isEven.test(10)) System.out.println("10 is even.");
        NumericTest isNonNeg = (n) -> n >= 0;
        if(!isNonNeg.test(-1)) System.out.println("-1 is negative");
        if(isNonNeg.test(1)) System.out.println("1 is non-negative");
        
        // This lambda expression determines if one number is 
        // a factor of another.
        NumericTest2 isFactor = (n, d) -> (n%d) == 0;
        if(isFactor.test(10, 2)) System.out.println("2 is a factor of 10.");
        if(!isFactor.test(10, 3)) System.out.println("3 is not a factor of 10.");
        NumericFunc<Integer> factorial = (i) ->
        {
            int result = 1;
            for(int n = 1; n <= i; n++)
                result *= n;
            return result;
        };
        System.out.println("The factorial of 3 is " + factorial.func(3));
        System.out.println("The factorial of 5 is " + factorial.func(5));
        
        NumericFunc<String> reverse = (str) ->
        {
            String result = "";
            int i;
            for(i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("The reverse of 'con cu' is " + reverse.func("con cu"));
    }
    
}
