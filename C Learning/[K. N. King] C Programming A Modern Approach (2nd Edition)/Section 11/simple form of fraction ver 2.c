//simple form of fraction ver 2
#include <stdio.h>
int GCD (int m, int n);
void reduce(int numerator, int denominator, int *reduced_numerator, int *reduced_denominator);
int main(void)
{
    int m,n,c;
    printf("Enter fraction: ");
    scanf("%d/%d", &m, &n);
    reduce(m, n, &m, &n);
    printf("In lowest term: %d/%d",m,n);
    return 0;
}
int GCD (int m, int n)
{
    int gcd;
    while (m != 0 && n != 0 )
    {
        if (m>n)
        m %= n;
        else if (m<n)
            n %= m;
        else break;
    }
    if (m == 0)
        gcd = n;
    if (n == 0)
        gcd = m;
    if (m == n)
        gcd = m;
        return gcd;
}
void reduce(int numerator, int denominator, int *reduced_numerator, int *reduced_denominator)
{
    int c = GCD(numerator,denominator);
    *reduced_numerator/= c;
    *reduced_denominator/= c;
}
