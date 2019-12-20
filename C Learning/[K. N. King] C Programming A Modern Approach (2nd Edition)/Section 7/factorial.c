// Find the factorial
#include <stdio.h>
int main (void)
{
    int n, factorial = 1, i;
    printf("Enter a positive number: ");
    scanf("%d", &n);
    for(i = 1; i<=n; i++)
        factorial *= i;
    printf("Factorial of %d: %d", n, factorial);
    return 0;
}
