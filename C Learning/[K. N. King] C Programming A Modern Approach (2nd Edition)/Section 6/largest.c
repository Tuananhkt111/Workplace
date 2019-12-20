//find the largest number in a series
#include <stdio.h>
int main(void)
{
    int i;
    float n, max = 0;
    for (i = 1; ; i++)
    {
        printf("Enter a number: ");
        scanf("%f", &n);
        if (n>=max)
            max = n;
        if (n<=0)
            break;
    }
    if (i>1)
    printf("The largest number entered was %f",max);
    else printf("Error number");
    return 0;
}
