//reverse numbers ver 3
#include <stdio.h>
int main(void)
{
    int x;
    printf("Enter a three-digit number: ");
    scanf("%d",&x);
    printf("The reversal is: %d%d%d",x%10,(x-x%10)/10%10,x/100);
    return 0;
}
