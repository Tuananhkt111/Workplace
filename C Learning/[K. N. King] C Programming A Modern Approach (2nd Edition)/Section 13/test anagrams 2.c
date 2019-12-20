//tests anagrams ver 2
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
bool are_anagrams(const char *word1, const char *word2);
int main (void)
{
    char word1[101], word2[101];
    printf("Enter first word: ");
    scanf("%100s", word1);
    printf("Enter second word: ");
    scanf("%100s", word2);
    if(!are_anagrams(word1, word2))
        printf("The words are not anagrams.");
    else printf("The words are anagrams.");
    return 0;
}
bool are_anagrams(const char *word1, const char *word2)
{
    char nchar[26] = {0};
    int i;
    for(; *word1; word1++)
        if (isalpha(*word1))
           ++nchar[tolower(*word1)-'a'];
    for(; *word2; word2++)
        if (isalpha(*word2))
           --nchar[tolower(*word2)-'a'];
    for (i = 0; i < 26 && nchar[i] == 0; i++);
    if (i < 26)
        return false;
    else return true;
}
