//tests anagrams
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
int main (void)
{
    char c, nchar[26] = {0};
    int i;
    printf("Enter first word: ");
    for(i = 0;(c = getchar()) != '\n'; i++)
        if (isalpha(c))
           ++nchar[tolower(c)-'a'];
    printf("Enter second word: ");
    for(i = 0; (c = getchar()) != '\n'; i++)
        if (isalpha(c))
           --nchar[tolower(c)-'a'];
    for (i = 0; i < 26 && nchar[i] == 0; i++);
    if (i <26)
        printf("The words are not anagrams.");
    else printf("The words are anagrams.");
    return 0;
}
