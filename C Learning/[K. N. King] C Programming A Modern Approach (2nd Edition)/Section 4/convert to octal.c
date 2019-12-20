//convert to octal
#include <stdio.h>
int main(void)
{
    int x;
    printf("Enter a number between 0 and 32767: ");
    scanf("%d",&x);
    printf("In octal, your number is: %d%d%d%d%d",x/8/8/8/8%8,x/8/8/8%8,x/8/8%8,x/8%8,x%8);
    return 0;
}
