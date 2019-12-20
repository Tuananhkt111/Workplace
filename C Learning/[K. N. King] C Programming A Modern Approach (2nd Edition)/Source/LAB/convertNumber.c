#include <stdio.h>
#include <string.h>
int getUserChoice();
void binaryToDec();
int main()
{
    int userChoice;
    do
    {
        userChoice = getUserChoice();
        switch(userChoice)
        {
            case 1: binaryToDec(); break;
            case 2:; break;
            case 3:; break;
            case 4: return 0;
        }
    } while(userChoice > 0 && userChoice < 5);
    getchar();
    return 0;
}
int getUserChoice()
{
    int choice;
    printf("\n");
    printf("1.  Convert binary number to decimal number\n");
    printf("2.  Convert octal number to decimal number\n");
    printf("3.  Convert hexadecimal number to decimal number\n");
    printf("4.  Exit\n");
    printf("Please choose number(1 - 4):");
    scanf("%d", &choice);
    return choice;
}
void binaryToDec()
{
    char c;
    do
    {
        int dec = 0, base = 1;
        long bin;
        printf("Enter binary number:");
        scanf("%d", &bin);
        while(bin > 0)
        {
            int rem = bin % 10;
            dec += rem * base;
            bin /= 10;
            base *= 2;
        }
        printf("Decimal number is:%d\n", dec);
        printf("Please ENTER to continue, press Esc to return main menu.");
        getchar();
        if((c = getche()) == 27)
            return;
    } while(c == '\n');
}

