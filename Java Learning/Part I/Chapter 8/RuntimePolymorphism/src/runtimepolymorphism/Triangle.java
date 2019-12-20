package runtimepolymorphism;
public class Triangle extends Figure
{
    Triangle(double a, double b)
    {
        super(a, b);
    }
    //Override are for triangle
    double area()
    {
        System.out.println("Inside Area For Triangle.");
        return (dim1*dim2)/2;
    }
}
