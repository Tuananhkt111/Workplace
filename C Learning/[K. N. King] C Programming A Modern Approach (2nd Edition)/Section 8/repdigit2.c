//Check numbers for repeated digits ver 2
#include <stdio.h>
#include <stdbool.h>
int main (void)
{
    bool digit_seen[10] = {false};
    int digit, digit_repeated[10] = {0}, i;
    long n;
    printf("Enter a number: ");
    scanf("%ld", &n);
    while (n > 0)
    {
        digit = n % 10;
        if (digit_seen[digit])
        digit_repeated[digit] = 1;
        digit_seen[digit] = true;
        n /= 10;
    }
    printf("Repeated digit(s): ");
    for (i = 0; i < 10; i++)
        if (digit_repeated[i] == 1)
           printf("%d ", i);
    return 0;
}
