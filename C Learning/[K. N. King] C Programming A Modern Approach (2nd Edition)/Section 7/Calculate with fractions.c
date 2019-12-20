//Calculate with fractions
#include <stdio.h>
int GCD(int m, int n);
int main(void)
{
    int num1, denom1, num2, denom2, num_result, denom_result, c;
    char puntunction;
    printf("Enter two fractions:\n");
    scanf("%d /%d %c %d /%d", &num1, &denom1, &puntunction, &num2, &denom2);
    switch (puntunction)
    {
        case '+': num_result = num1*denom2 + num2*denom1;
                  denom_result = denom1*denom2;
                  break;
        case '-': num_result = num1*denom2 - num2*denom1;
                  denom_result = denom1*denom2;
                  break;
        case '/': num_result = num1*denom2;
                  denom_result = num2*denom1;
                  break;
        case '*': num_result = num1*num2;
                  denom_result = denom1*denom2;
                  break;
    }
    c = GCD(num_result, denom_result);
    num_result /= c;
    denom_result /= c;
    printf("The result is %d/%d\n", num_result, denom_result);
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
