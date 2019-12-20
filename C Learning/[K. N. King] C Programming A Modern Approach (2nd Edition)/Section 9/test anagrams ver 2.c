//tests anagrams ver 2
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
void read_words(int counts[26])
{
    int i;
    char c;
    for(i = 0; i < 26 && (c = getchar()) != '\n'; i++)
        if (isalpha(c))
           ++counts[tolower(c)-'a'];
}
bool equal_array(int counts1[26], int counts2[26])
{
    int i;
    for (i = 0; i < 26; i++)
        if (counts1[i] != counts2[i])
        return false;
    return true;
}
int main (void)
{
    char c;
    int nchar1[26] = {0}, nchar2[26] = {0};
    printf("Enter first word: ");
    read_words(nchar1);
    printf("Enter second word: ");
    read_words(nchar2);
    if (!equal_array(nchar1, nchar2))
        printf("The words are not anagrams.");
    else printf("The words are anagrams.");
    return 0;
}
