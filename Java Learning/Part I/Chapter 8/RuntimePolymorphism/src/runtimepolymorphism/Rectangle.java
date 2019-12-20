package runtimepolymorphism;
public class Rectangle extends Figure
{
    Rectangle(double a, double b)
    {
        super(a, b);
    }
    //Override are for rectangle
    double area()
    {
        System.out.println("Inside Area For Rectangle.");
        return dim1*dim2;
    }
}
