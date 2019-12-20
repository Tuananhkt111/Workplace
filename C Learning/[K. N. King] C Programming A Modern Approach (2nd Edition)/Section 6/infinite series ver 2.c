//infinite series of e ver 2
#include <stdio.h>
int factorial (int n);
int main (void)
{
    int n, i;
    float e = 1.00f, epx;
    printf("Enter epxilon: ");
    scanf("%f", &epx);
    for (i = 1; factorial(i-1)>= epx; i++)
        e += 1/(float)factorial(i);
    printf("Approximates e: %.12f", e);
    return 0;
}
int factorial(int n)
{
    int factor = 1;
    int j;
    for (j = 1; j <= n; j++)
        factor *= j;
    return factor;
}
