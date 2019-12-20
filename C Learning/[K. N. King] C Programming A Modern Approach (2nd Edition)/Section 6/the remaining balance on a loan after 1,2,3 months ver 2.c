// the remaining balance on a loan after 1,2,3 months ver 2
#include <stdio.h>
int main(void)
{
    float rate, loan, monthly_payment,remain;
    int i;
    printf("Enter amount of loan: ");
    scanf("%f",&loan);
    printf("Enter interest rate: ");
    scanf("%f",&rate);
    printf("Enter monthly payment: ");
    scanf("%f",&monthly_payment);
    remain = loan;
    for(i=1;remain >= 0.0f;++i)
    {
        remain = loan*(100.0f + (rate/12))/100.0 - monthly_payment;
        printf("Balance remaining after %d-month payment: %.2f\n",i,remain);
        loan = remain;
    }
    return 0;
}

