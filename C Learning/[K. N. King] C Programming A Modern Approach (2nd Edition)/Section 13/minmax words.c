//find the smallest and largest in a series of words
#include <stdio.h>
#include <string.h>
#define MAX_LETTERS 20
void get_word();
char smallest_word[MAX_LETTERS + 1];
char largest_word[MAX_LETTERS + 1];
char word[MAX_LETTERS + 1];
int main (void)
{
    get_word();
    strcpy(smallest_word, word);
    strcpy(largest_word, word);
    for(;strlen(word) != 4;)
    {
        get_word();
        if(strcmp(word, smallest_word) < 0)
            strcpy(smallest_word, word);
        if(strcmp(largest_word, word) < 0)
            strcpy(largest_word, word);

    }
    printf("Smallest word: %s\n", smallest_word);
    printf("Largest word: %s", largest_word);
    return 0;
}
void get_word()
{
    printf("Enter word: ");
        scanf("%20s", word);
}
