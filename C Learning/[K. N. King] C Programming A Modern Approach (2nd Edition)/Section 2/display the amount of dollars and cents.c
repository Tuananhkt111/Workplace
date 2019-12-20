// Display the amount of dollars and cents
#include <stdio.h>
int main(void)
{
    float dollar;
    printf("Enter a dollar-and-cent: ");
    scanf("%f",&dollar);
    printf("The amount with tax: $%.2f",(1.05f*dollar));
    return 0;
}
