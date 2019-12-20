//segment digits
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#define MAX_DIGITS 10
//external variables
const int segments[10] [7] = { {1,1,1,1,1,1,0}, {0,1,1,0,0,0,0}, {1,1,0,1,1,0,1}, {1,1,1,1,0,0,1}, {0,1,1,0,0,1,1}, {1,0,1,1,0,1,1}, {1,0,1,1,1,1,1}, {1,1,1,0,0,0,0},
{1,1,1,1,1,1,1}, {1,1,1,1,0,1,1} };
char digits[4][MAX_DIGITS*4];
int row, col, pos;
int numbers[MAX_DIGITS];
//functions declarations
void clear_digits_array (void);
void process_digit (int digit, int position);
void print_digits_array (void);
int main (void)
{
    char c;
    int i = 0;
    printf("Enter a number: ");
    for (pos = 0; (c = getchar()) != '\n' && pos < MAX_DIGITS; pos++)
    {
        if(c >= '0' && c <= '9')
        numbers[pos] = (int) c - '0';
        i++;
    }
    clear_digits_array();
    for (pos = 0; pos < i; pos++)
    {
        process_digit(numbers[pos], pos);
    }
    print_digits_array();
    return 0;
}
void clear_digits_array (void)
{
    for (row = 0; row < 4; row++)
        for (col = 0; col < 4; col++)
        digits[row][col] = ' ';
}
void process_digit (int digit, int position)
{
    for (col = 0; col < 7; col++)
        if (segments[digit][col] == 1)
        switch (col)
        {
            case 0: digits[0][1 + position*4] = '_'; break;
            case 1: digits[1][2 + position*4] = '|'; break;
            case 2: digits[2][2 + position*4] = '|'; break;
            case 3: digits[2][1 + position*4] = '_'; break;
            case 4: digits[2][0 + position*4] = '|'; break;
            case 5: digits[1][0 + position*4] = '|'; break;
            case 6: digits[1][1 + position*4] = '_'; break;
        }
}
void print_digits_array (void)
{
    for (row = 0; row < 4; row++)
    {
        for(col = 0; col < (pos - 1)*4 + 4; col++)
            printf("%c", digits[row][col]);
        printf("\n");
    }
}
