//Checks whether the message is a palindrome ver 2
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#define N 100
int count = 0;
bool is_palindrome(const char *message);
int main (void)
{
    char a[N], ch;
    printf("Enter sentence: ");
    for (;(ch = getchar()) != '\n';)
    if(toupper(ch) >= 'A' && toupper(ch) <= 'Z')
    {
        a[count] = toupper(ch);
        count++;
    }
    if(is_palindrome)
        printf("Palindrome");
    else printf("Not palindrome");
    return 0;
}
bool is_palindrome(const char *message)
{
    const char *ptr_start = message, *ptr_end;
    ptr_end = message + count - 1;
    while(ptr_start < ptr_end)
        if(*ptr_start++ != *ptr_end--)
            return false;
        else
            return true;
}
