// prints table of even square
#include <stdio.h>
int main (void)
{
    int i,n;
    printf("Enter number n: ");
    scanf("%d", &n);
    for (i = 2; i*i <= n; i++)
        printf("%d\n", i*i);
    return 0;
}
