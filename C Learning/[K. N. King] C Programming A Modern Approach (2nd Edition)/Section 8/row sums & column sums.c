//row sums & column sums
#include <stdio.h>
int main (void)
{
    int i, j, n[5][5], row_totals[5] = {0}, column_totals[5] = {0};
    for (i = 0; i < 5; i++)
    {
        printf("Enter row %d: ", i + 1);
        for (j = 0; j < 5; j++)
            scanf("%d", &n[i][j]);
    }
    for (i = 0; i < 5; i++)
        for (j = 0; j < 5; j++)
        row_totals[i] += n[i][j];
    for (j = 0; j < 5; j++)
        for (i = 0; i < 5; i++)
        column_totals[j] += n[i][j];
    printf("Row totals: ");
    for (i = 0; i < 5; i++)
        printf("%d ", row_totals[i]);
    printf("\nColumn totals: ");
    for (j = 0; j < 5; j++)
        printf("%d ", column_totals[j]);
    return 0;
}
