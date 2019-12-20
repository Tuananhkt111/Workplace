//infinite series of e
#include <stdio.h>
int factorial (int n);
int main (void)
{
    int n, i;
    float e = 1.00f;
    printf("Enter number n: ");
    scanf("%d", &n);
    for (i = 1; i <= n; i++)
        e += 1/(float)factorial(i);
    printf("Approximates e: %f", e);
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
