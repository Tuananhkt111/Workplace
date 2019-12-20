package abstract2;
public abstract class Figure
{
    double dim1, dim2;
    Figure(double a, double b)
    {
        dim1 = a;
        dim2 = b;
    }
    //area is now an abstract method
    abstract double area();
}
