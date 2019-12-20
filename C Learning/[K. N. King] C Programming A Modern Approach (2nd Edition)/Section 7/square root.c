// Find the square root of a positive number
#include <stdio.h>
#include <math.h>
int main(void)
{
    double x, y = 1, z = 1;
    printf("Enter a positive number: ");
    scanf("%lf", &x);
    while (fabs(z) >= .00001)
    {
        z = y - (x/y+y)/2;
        y = (x/y+y)/2;
    }
    printf("Square root: %f", y);
    return 0;
}
