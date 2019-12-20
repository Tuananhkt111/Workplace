//Average length of words ver 2
#include <stdio.h>
#include <string.h>
double compute_average_word_length(const char *sentence);
int main(void)
{
    char ch[1000];
    printf("Enter a sentence:\n");
    gets(ch);
    printf("Average word length: %f", compute_average_word_length(ch));
    return 0;
}
double compute_average_word_length(const char *sentence)
{
    double avg;
    int length_of_word = 0, number_of_words = 0;
    for(;*sentence; sentence++)
        {
        if (*sentence != ' ' && *sentence != '\n')
            ++length_of_word;
        else if (*sentence == ' ')
            if (*(sentence - 1) != ' ')
            number_of_words++;
        else if (*sentence == '\n')
        {
            number_of_words++;
            break;
        }
        }
    avg = (double) length_of_word / number_of_words;
    return avg;
}
