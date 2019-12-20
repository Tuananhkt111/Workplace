//Check digit EAN
#include <stdio.h>
int main(void)
{
    int d[12],first_sum,second_sum,check_digit;
    printf("Enter the first 12 digits of a EAN: ");
    scanf("%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d",
         &d[0],&d[1],&d[2],&d[3],&d[4],&d[5],
         &d[6],&d[7],&d[8],&d[9],&d[10],&d[11]);
    first_sum = d[1] + d[3] + d[5] + d[7] + d[9] + d[11];
    second_sum = d[0] + d[2] + d[4] + d[6] + d[8] + d[10];
    check_digit = 9 - ((first_sum*3 + second_sum) - 1)%10;
    printf("Check digit: %d",check_digit);
    return 0;
}
