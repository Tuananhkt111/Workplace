//one-month calendar
#include <stdio.h>
int main(void)
{
    int n, m, i, j;
    printf("Enter number of days in month: ");
    scanf("%d", &n);
    printf("Enter starting day of the week (1=Sun, 7=Sat): ");
    scanf("%d", &m);
    for(j = 1; j < (m<2?8:m);j++)
        printf("\t");
    for (i=1;i <= n; i++)
    {
        if (j<7)
        {
            printf("%d\t",i);
            ++j;
        }
        else
        {
            printf("%d\n",i);
            j = 1;
        }
    }
    return 0;
}
