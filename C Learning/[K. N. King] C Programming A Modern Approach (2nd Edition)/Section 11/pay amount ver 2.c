// how to pay the amount ver 2
#include <stdio.h>
void pay_amount(int dollars, int *twenties, int *tens, int *fives, int *ones);
int main(void)
{
    int dollars,bills20,bills10, bills5, bills1;
    printf("Enter the amount of dollars: ");
    scanf("%d",&dollars);
    pay_amount(dollars, &bills20, &bills10, &bills5, &bills1);
    printf("$20 bills: %d\n",bills20);
    printf("$10 bills: %d\n",bills10);
    printf("$5 bills: %d\n",bills5);
    printf("$1 bills: %d\n",bills1);
    return 0;
}
void pay_amount(int dollars, int *twenties, int *tens, int *fives, int *ones)
{
    int temp = dollars;
    *twenties = temp/20;
    temp -= *twenties*20;
    *tens = temp/10;
    temp -= *tens*20;
    *fives = temp/5;
    *ones = temp - *fives*5;
}
