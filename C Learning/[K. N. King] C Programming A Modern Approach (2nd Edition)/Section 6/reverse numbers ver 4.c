//reverse numbers ver 4
#include <stdio.h>
int main(void)
{
    int x,j,i;
    printf("Enter a number: ");
    scanf("%d",&x);
    printf("The reversal is: ");
    for (i=0; x != 0; i++)
    {
        j = x%10;
        x /= 10;
        printf("%d",j);
    }
    return 0;
}
