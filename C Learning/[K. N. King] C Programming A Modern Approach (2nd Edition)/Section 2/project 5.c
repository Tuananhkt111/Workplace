// Value of the polynomial
#include <stdio.h>
int power (int m, int n);
int main(void)
{
    int x,f;
    printf("Enter the value of x: ");
    scanf("%d",&x);
    f=3*power(x,5) + 2*power(x,4) - 5*power(x,3) - power(x,2) + 7*x -6;
    printf("Value of the polynomial: %d\n",f);
    return 0;
}
int power (int m, int n)
{
    int i,p=1;
    for(i=1;i<=n;++i)
        p=p*m;
    return p;
}
