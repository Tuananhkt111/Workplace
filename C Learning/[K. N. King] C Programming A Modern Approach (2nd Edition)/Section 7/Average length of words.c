//Average length of words
#include <stdio.h>
int main(void)
{
    char ch;
    int amount = 0, length_of_current_word = 0, number_of_words = 0;
    printf("Enter a sentence:\n");
    while ((ch = getchar()) != EOF)
    {
        ++length_of_current_word;
        if (ch == ' ')
        {
            number_of_words++;
            amount += length_of_current_word-1;
            length_of_current_word = 0;
        }
        if (ch == '\n')
        {
            number_of_words++;
            amount += length_of_current_word-1;
            length_of_current_word = 0;
            break;
        }
    }
    printf("Average word length: %.2f",(float)amount/number_of_words);
    return 0;
}
