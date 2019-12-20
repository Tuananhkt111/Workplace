//reverses a sentence ver 2
#include <stdio.h>
int main (void)
{
    char ch[1000], c, terminate_char;
    int i, temp1, temp2, j;
    printf("Enter message: ");
    for (i = 0; i < 1000 && (c = getchar()) != '\n'; i++)
    {
        if (c != '.' && c != '!' && c != '?')
        ch[i] = c;
        else
        {
            break;
        }
    }
    temp1 = temp2 = --i;
    printf("Reversal sentence:\n");
    for (; i >= 0; i--)
    {
        if (ch[i] != ' ' && i != 0)
            temp1--;
        else if (ch[i] == ' ')
            {
            for (j = temp1+1; j <= temp2; j++)
                putchar(ch[j]);
            temp2 = --temp1;
            putchar(' ');
            }
        else {
            for (j = temp1; j <= temp2; j++)
                putchar(ch[j]);
            putchar(c);
            }
    }
    return 0;
}
