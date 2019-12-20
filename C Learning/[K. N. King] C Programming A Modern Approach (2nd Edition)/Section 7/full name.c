// Displays full name
#include <stdio.h>
#define MAXNAME 1000
void reverse_name(char *name);
int main (void)
{
    char s[MAXNAME];
    printf("Enter a first and last name: ");
    gets(s);
    reverse_name(s);
    return 0;
}
void reverse_name(char *name)
{
     char initial;

    while (*name && *name == ' ')
        name++;
    initial = *name++;

    while (*name && *name++ != ' ');

    while (*name && *name != '\n')
        putchar(*name++);
    printf(", %c.", initial);
}
