//Prints a table of squares using a for statement ver 4
#include <stdio.h>
int main(void)
{
    int i = 1, n;
    printf("This program prints a table of squares.\n");
    printf("Enter number of entries in table:\n");
    scanf("%d", &n);
    getchar();
    for (i = 1; i <= n; i++)
    {
        printf("%10d%10d\n", i, i*i);
        if ( i % 24 == 0)
        {
            printf("Press ENTER to continue...\n");
            getchar();
        }
    }
    return 0;
}
