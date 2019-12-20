//game of craps
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>
int roll_dice (void)
{
    int m, n;
    m = rand() % 6 + 1;
    n = rand() % 6 + 1;
    return m + n;
}
bool play_game(void)
{
    int i, sum, point;
    for (i = 0;;i++)
        {
            sum = roll_dice();
            printf("You rolled: %d\n", sum);
            if (i == 0)
                switch (sum)
                {
                    case 7: case 11: printf("You win!\n"); return true;
                    case 2: case 3: case 12: printf("You lose!\n"); return false;
                    default: point = sum; printf("Your point is %d\n", point); break;
                }
            if (i > 0)
                if (sum == 7)
                {
                    printf("You lose!\n"); return false;
                }
                else if (sum == point)
                    {
                        printf("You win!\n"); return true;
                    }
                else continue;
                }
}
int main(void)
{
    int num_win = 0, num_lose = 0;
    char answer;
    srand((unsigned) time(NULL));
    for (;;)
    {
        if (play_game())
            ++num_win;
        else ++num_lose;
        printf("Play again? ");
        scanf("%c", &answer);
        switch (toupper(answer))
        {
            case 'Y': getchar(); break;
            case 'N': printf("Wins: %d\tLoses: %d", num_win, num_lose); return 0;
            default: return 0;
        }
    }
}
