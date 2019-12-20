#include <stdio.h>
int power(int x, int n)
{
    return n == 0 ? 1 : x*power(x, n-1);
}
int result(int x)
{
    return 3*power(x,5) + 2*power(x, 4) - 5*power(x, 3) -power(x, 2) +7*x -6;
}
int main (void)
{
    int x;
    printf("Enter the value of x: ");
    scanf("%d", &x);
    printf("Result of polynomial: %d", result(x));
    return 0;
}
