//Checks whether the message is a palindrome
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#define N 100
int main (void)
{
    char a[N], *ptr_start = a, *ptr_end, ch;
    int count = 0;
    printf("Enter sentence: ");
    for (;(ch = getchar()) != '\n';)
    if(toupper(ch) >= 'A' && toupper(ch) <= 'Z')
    {
        a[count] = toupper(ch);
        count++;
    }
    ptr_end = a + count - 1;
    while(ptr_start < ptr_end)
        if(*ptr_start++ != *ptr_end--)
        {
            printf("Not palindrome");
            return 0;
        }
        else
        {
            printf("Palindrome");
            return 0;
        }
}
