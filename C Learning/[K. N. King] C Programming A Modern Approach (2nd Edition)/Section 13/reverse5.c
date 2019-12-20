//Reverse a series of characters (pointer version ver 2)
#include <stdio.h>
#define N 100
void reverse(char *message);
int main (void)
{
    char a[N], *p;
    printf("Enter sentence: ");
    for (p = a; p < a + N && (*p = getchar()) != '\n'; p++);
    *p = '\n';
    printf("In reverse order:");
    reverse(a);
    printf("%s\n", a);
    return 0;
}
void reverse(char *message)
{
    char temp;
    char *ptr_start = message, *ptr_end;
    while(*message != '\n')
        message++;
    ptr_end = --message;
    for (;ptr_start < ptr_end; ptr_start++, ptr_end--)
        {
            temp = *ptr_start;
            *ptr_start = *ptr_end;
            *ptr_end = temp;
        }
}
