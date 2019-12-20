//Check numbers for repeated digits ver 4
#include <stdio.h>
#include <stdbool.h>
bool check_number (long n);
int main (void)
{
    bool digit_seen[10] = {false};
    int digit, i = -1, j;
    long n[1000] = {1};
    do
    {
        i++;
        printf("\nEnter a number: ");
        scanf("%ld", &n[i]);
    }
    while (n[i] > 0);
    if (n[i] <= 0)
        i--;
    for (j = 0; j <= i; j++)
    {
        if (check_number(n[j]))
        printf("\n%ld has repeated numbers.", n[j]);
        else printf("%\nld has NO repeated numbers.", n[j]);
    }
    return 0;
}
bool check_number(long n)
{

    bool digit_seen[10] = {false};
    int digit;
    while (n >= 0)
    {
        digit = n % 10;
        if (digit_seen[digit])
            break;
        digit_seen[digit] = true;
        n /= 10;
    }
    if (n > 0)
        return true;
    else
        return false;


}
