#include <stdio.h>
int main(void)
{
    int d[11],first_sum,second_sum,check_digit;
    printf("Enter the first (single) digit: ");
    scanf("%1d", &d[0]);
    printf("Enter the first group of 5 digits: ");
    scanf("%1d%1d%1d%1d%1d",&d[1],&d[2],&d[3],&d[4],&d[5]);
    printf("Enter the second group of 5 digits: ");
    scanf("%1d%1d%1d%1d%1d",&d[6],&d[7],&d[8],&d[9],&d[10]);
    first_sum = d[0] + d[2] + d[4] + d[6] + d[8] + d[10];
    second_sum = d[1] + d[3] + d[5] + d[7] + d[9];
    check_digit = 9 - ((first_sum*3 + second_sum) - 1)%10;
    printf("Check digit: %d",check_digit);
    return 0;
}
