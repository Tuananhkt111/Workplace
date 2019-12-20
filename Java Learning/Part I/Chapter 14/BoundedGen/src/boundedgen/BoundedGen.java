// Demonstrate Stats.
package boundedgen;
public class BoundedGen
{
    public static void main(String[] args)
    {
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(inums);
        double v = iob.average();
        System.out.println("iob average is " + v);
        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<>(dnums);
        v = dob.average();
        System.out.println("iob average is " + v);      
    }
    
}
