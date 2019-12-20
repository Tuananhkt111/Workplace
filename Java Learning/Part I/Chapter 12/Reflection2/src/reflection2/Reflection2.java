/*
Reflection
 */
package reflection2;

import java.lang.annotation.*;
import java.lang.reflect.*;
//An annotation type of declaration

@Retention(RetentionPolicy.RUNTIME)
@interface Myanno
{

    String str();

    int val();
}

class Meta
{

    //Annotate a method
    @Myanno(str = "Annotation Example", val = 100)
    public static void myMeth(String str, int i)
    {
        Meta ob = new Meta();
        //Obtain the annotation for this method
        // and display the values of the members.
        try
        {
            //First, get a Class object to represent this class.
            Class<?> c = ob.getClass();
            //Now, get a Method object that represents this method.
            Method m = c.getMethod("myMeth", String.class, int.class);
            //Next, get the annotation for this class
            Myanno anno = m.getAnnotation(Myanno.class);
            //Finally, display the values.
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e)
        {
            System.out.println("Method Not Found.");
        }
    }
}

public class Reflection2
{

    public static void main(String[] args)
    {
        Meta.myMeth("test", 10);
    }
}
