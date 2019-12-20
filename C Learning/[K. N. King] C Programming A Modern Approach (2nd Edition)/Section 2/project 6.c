// Value of the polynomial ver 2
#include <stdio.h>
int main(void)
{
    int x,f;
    printf("Enter the value of x: ");
    scanf("%d",&x);
    f=((((3*x+2)*x-5)*x-1)*x+7)*x-6;
    printf("Value of the polynomial: %d\n",f);
    return 0;
}
