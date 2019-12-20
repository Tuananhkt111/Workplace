//Check numbers for repeated digits ver 3
#include <stdio.h>
#include <stdbool.h>
int main (void)
{
    int digit, digit_repeated[10] = {0}, i;
    unsigned long n;
    printf("Enter a number: ");
    scanf("%lu", &n);
    while (n > 0)
    {
        digit = n % 10;
        digit_repeated[digit]++;
        n /= 10;
    }
    printf("Digit: ");
    for (i = 0; i <10; i++)
    printf("%d\t", i);
    printf("\nOccurrences: ");
    for (i = 0; i < 10; i++)
           printf("%d\t", digit_repeated[i]);
    return 0;
}
