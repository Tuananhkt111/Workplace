#include <stdio.h>
int power(int x, int n)
{
    if (n == 0)
        return 1;
    if (n > 0 && n % 2 == 0)
        return power(x, n/2)*power(x, n/2);
    if (n > 0 && n % 2 != 0)
        return x*power(x, n-1);
}
int main (void)
{
    int x, n, k;
    printf("Enter values of x and n: ");
    scanf("%d %d", &x, &n);
    k = power(x, n);
    printf("Power(x, n): %d",k);
    return 0;
}
