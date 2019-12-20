//find GCD
#include <stdio.h>
int main(void)
{
    int m, n;
    printf("Enter two numbers: ");
    scanf("%d %d", &m, &n);
    while (m != 0 && n != 0 )
    {
        if (m>n)
        m %= n;
        else if (m<n)
            n %= m;
        else break;
    }
    if (m == 0)
        printf("%d is GCD.",n);
    if (n == 0)
        printf("%d is GCD.",m);
    if (m == n)
        printf("%d is GCD",m);
        return 0;
}
