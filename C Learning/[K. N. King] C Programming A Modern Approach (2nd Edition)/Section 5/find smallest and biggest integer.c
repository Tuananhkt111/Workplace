//Find smallest and biggest integer
#include <stdio.h>
int main(void)
{
    int x[4], min, max, i;
    printf("Enter four integers: ");
    scanf("%d %d %d %d", &x[0], &x[1], &x[2], &x[3]);
    min = max = x[0];
    for(i=1;i<4;++i)
        if (x[i] <= min )
        min = x[i];
    for(i=1;i<4;++i)
        if (x[i]>=max)
        max = x[i];
    printf("Largest: %d\n", max);
    printf("Smallest: %d", min);
    return 0;
}

