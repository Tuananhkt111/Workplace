//Reverse a series of characters (pointer version ver 2)
#include <stdio.h>
#define N 100
int main (void)
{
    char a[N], *p;
    printf("Enter sentence: ");
    for (p = a; p < a + N && (*p = getchar()) != '\n'; p++);
    printf("In reverse order:");
    for (; p >= a; p--)
        printf("%c", *p);
    printf("\n");
    return 0;
}
