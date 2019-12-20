//Count vowels ver 2
#include <stdio.h>
#include <ctype.h>
int compute_vowel_count(const char *sentence);
int main(void)
{
    char ch[100];
    int amount;
    printf("Enter your sentence:\n");
    gets(ch);
    printf("Your sentence contains %d vowel(s).",compute_vowel_count(ch));
    return 0;
}
int compute_vowel_count(const char *sentence)
{
    int count = 0;
    for(; *sentence; sentence++)
        switch (toupper(*sentence))
        {
            case 'A': case 'E': case 'I': case 'O': case 'U':
            count++; break;
        }
    return count;
}
