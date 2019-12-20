/*
Annotation2
 */
package annotation2;
import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Myanno
{
    String str();
    int val();
}
@Retention(RetentionPolicy.RUNTIME)
@interface What
{
    String description();
}
@What(description = "An annotation test class")
@Myanno(str = "Meta2", val = 99)
public class Annotation2
{
    @What(description = "An annotation test method")
    @Myanno(str = "Testing", val = 100)
    public static void myMeth()
    {
        Annotation2 ob = new Annotation2();
        try
        {
            Annotation annos[] = ob.getClass().getAnnotations();
            //Display all annotations for Meta2
            System.out.println("All annotations for Meta2:");
            for(Annotation a: annos)
                System.out.println(a);
            System.out.println();
            //Display all annotations for myMeth.
            Method m1 = ob.getClass().getMethod("myMeth");
            annos = m1.getAnnotations();
            System.out.println("All annotations for Mymeth:");
            for(Annotation a: annos)
                System.out.println(a);
        }
        catch(NoSuchMethodException exc)
        {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String[] args)
    {
        myMeth();
    }
    
}
