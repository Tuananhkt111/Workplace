//magic square ver 2
#include <stdio.h>
int mode(int n, int m)
{
    if (m < 0)
    m += n;
    if (m >= n)
    m -= n;
    return m;
}
void create_magic_square(int n, int magic_square[n][n])
{
    int i, j, row = 0, column;
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
        magic_square[i][j] = 0;
    magic_square[0][n/2] = 1;
    column = n/2;
    for (i = 2; i <= n*n; i++)
    {
        row--;
        column++;
        row = mode(n, row);
        column = mode(n, column);
        if (magic_square[row][column] != 0)
        {
            row += 2;
            column--;
            row = mode(n, row);
            column = mode(n, column);

        }
        magic_square[row][column] = i;
    }
}
void print_square(int n, int magic_square[n][n])
{
    int i, j, row, column;
    for (row = 0; row < n; row++)
        for (column = 0; column < n; column++)
        {
            printf("%d\t",magic_square[row][column]);
            if (column == n - 1)
                printf("\n");
        }
}
int main (void)
{

    printf("This program creates a magic square of a specified size.\n");
    printf("The size must be an odd number between 1 and 99.\n");
    printf("Enter size of magic square: ");
    int n, i, j, row = 0, column;
    scanf("%d", &n);
    int magic_square[n][n];
    create_magic_square(n, magic_square);
    print_square(n, magic_square);
    return 0;
}
