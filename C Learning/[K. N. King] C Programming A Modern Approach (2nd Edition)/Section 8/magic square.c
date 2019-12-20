//magic square
#include <stdio.h>
int mode(int n, int m)
{
    if (m < 0)
    m += n;
    if (m >= n)
    m -= n;
    return m;
}
int main (void)
{

    printf("This program creates a magic square of a specified size.\n");
    printf("The size must be an odd number between 1 and 99.\n");
    printf("Enter size of magic square: ");
    int n, i, j, row = 0, column;
    scanf("%d", &n);
    int number[n][n];
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
        number[i][j] = 0;
    number[0][n/2] = 1;
    column = n/2;
    for (i = 2; i <= n*n; i++)
    {
        row--;
        column++;
        row = mode(n, row);
        column = mode(n, column);
        if (number[row][column] != 0)
        {
            row += 2;
            column--;
            row = mode(n, row);
            column = mode(n, column);

        }
        number[row][column] = i;
    }
    for (row = 0; row < n; row++)
        for (column = 0; column < n; column++)
        {
            printf("%d\t",number[row][column]);
            if (column == n - 1)
                printf("\n");
        }
    return 0;
}
