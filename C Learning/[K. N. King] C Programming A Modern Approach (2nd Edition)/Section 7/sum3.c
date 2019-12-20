//Sums a series of numbers (using double variables)
#include <stdio.h>
int main (void)
{
    double n, sum = 0;
    printf("This programs sums a series of long floating-points.\n");
    printf("Enter double (0 to terminate): ");
    while (n != 0)
    {
        sum+=n;
        scanf("%lf ", &n);
    }
    printf("The sum is: %f", sum);
    return 0;
}
