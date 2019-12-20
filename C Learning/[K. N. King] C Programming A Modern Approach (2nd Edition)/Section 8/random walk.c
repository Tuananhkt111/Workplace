//random walk (need to clear)
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
int main (void)
{
    int i, j, k, count = 0, direction;
    char position[10][10];
    srand((unsigned) time(NULL));
    for (i = 0; i < 10; i++)
        for (j = 0; j < 10; j++)
        position[i][j] = '.';
    i = j = 0;
    position[i][j] = 'A';
    for (k = 0; k < 25 && count < 4;)
        {
                    direction = rand() % 4;
                    if ((position[i][j + 1] != '.' || j == 9 )&& (position[i + 1][j] != '.' || i == 9) && (position[i - 1][j] != '.' || i == 0)
                         && (position[i][j - 1] != '.' || j == 0))
                    break;
                    switch (direction)
        {
            case 0: if (i > 0 && position[i-1][j] == '.')
                           {
                               position[i-1][j] = 'A'+ k + 1;
                               i--;
                               k++;
                           }
                    break;
            case 1: if (i < 9 && position[i+1][j] == '.')
                           {
                               position[i+1][j] = 'A'+ k + 1;
                               i++;
                               k++;
                           }
                    break;
            case 2: if (j > 0 && position[i][j-1] == '.')
                           {
                               position[i][j-1] = 'A'+ k + 1;
                               j--; k++;
                           }
                    break;
            case 3: if (j < 9 && position[i][j+1] == '.')
                           {
                               position[i][j+1] = 'A'+ k + 1;
                               j++; k++;
                           }
                    break;
        }
        }

    for (i = 0; i < 10; i++)
        {
            for (j = 0; j < 10; j++)
            {
                printf("%c ", position[i][j]);
            }
            printf("\n");
        }

    return 0;
}
