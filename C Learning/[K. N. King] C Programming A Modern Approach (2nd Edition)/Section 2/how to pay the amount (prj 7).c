// how to pay the amount
#include <stdio.h>
int main(void)
{
    int dollar,bills20,bills10, bills5, bills1;
    printf("Enter the amount of dollars: ");
    scanf("%d",&dollar);
    bills20 = dollar/20;
    dollar -= 20*bills20;
    bills10 = dollar/10;
    dollar -= 10*bills10;
    bills5 = dollar/5;
    bills1 = dollar - 5*bills5;
    printf("$20 bills: %d\n",bills20);
    printf("$10 bills: %d\n",bills10);
    printf("$5 bills: %d\n",bills5);
    printf("$1 bills: %d\n",bills1);
    return 0;
}

