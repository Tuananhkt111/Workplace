// Displays full name ver 2
#include <stdio.h>
#define MAXNAME 1000
int main (void)
{
    char s[MAXNAME];
    printf("Enter a first and last name: ");
    gets(s);
    reverse_name();
    return 0;
}
void reverse_name(char *name)
{
     char *p = name, initial;

    while (*p && *p == ' ')
        p++;
    initial = *p++;

    while (*p && *p++ != ' ');

    while (*p && *p != '\n')
        putchar(*p++);
    printf(", %c.", initial);
}
