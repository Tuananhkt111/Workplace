//B1FF filter
#include <stdio.h>
#include <ctype.h>
#define MAXLINE 1000
int main (void)
{
    char c, ch[MAXLINE];
    int i, j;
    printf("Enter message: ");
    for (i = 0; i < MAXLINE && (c = getchar()) != '\n'; i++)
    {
        ch[i] = toupper(c);
        switch (ch[i])
        {
            case 'A': ch[i] = '4'; break;
            case 'B': ch[i] = '8'; break;
            case 'E': ch[i] = '3'; break;
            case 'I': ch[i] = '1'; break;
            case 'O': ch[i] = '0'; break;
            case 'S': ch[i] = '5'; break;
            default: break;
        }
    }
    printf("In B1FF-speak: ");
    for(j = 0; j<=i; j++)
    {
        if (i == j)
        printf("!!!!!!!!!!");
        else putchar(ch[j]);
    }
    return 0;
}
