//Count vowels
#include <stdio.h>
#include <ctype.h>
int main(void)
{
    char ch;
    int amount;
    printf("Enter your sentence:\n");
    while ((ch = getchar()) != '\n')
    {
        toupper(ch);
        switch (ch)
        {
            case 'A': case 'E': case 'I': case 'O': case 'U':
            amount ++; break;
        }
    }
    printf("Your sentence contains %d vowel(s).",amount);
    return 0;
}
