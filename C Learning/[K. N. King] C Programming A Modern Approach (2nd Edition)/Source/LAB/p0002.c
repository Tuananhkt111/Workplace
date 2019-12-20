#include <stdio.h>
#include <string.h>
char num[10];
char temp[10];
void unit(char a);
void dozen(int a);
void specialDozen(int a);
void input();
void output();
int main()
{
    do
    {
        input();
        output();
        printf("\nPlease enter to continue, press Esc to exit.\n");
        if(getchar() == 27)
            return 0;
    } while(getchar() == '\n');
    return 0;
}
void input()
{
    printf("Please enter string in numeric format: ");
    scanf("%[^\n]",num);
    int i = 0;
    for(; i < strlen(num); i++)
        temp[i] = num[strlen(num) - 1 - i];
    temp[i] = '\0';
}
void output()
{
    for(int i = strlen(temp) - 1; i >= 0; i--)
    {
        if(i == 9)
            if(temp[i] != '0')
            {
                unit(temp[i]);
                if(temp[i] - '1' > 0)
                    printf("Billions ");
                else printf("Billion ");
            }
        if(i == 8 || i == 5 || i == 2)
        {
            if(temp[i] != '0')
            {
                unit(temp[i]);
                if(temp[i] - '1' > 0)
                    printf("Hundreds ");
                else printf("Hundred ");
            }
        }
        if(i == 7 || i == 4 || i == 1)
        {
            if(temp[i] != '0')
            {
                if(temp[i] - '1' > 0)
                {
                    dozen((temp[i] - 48)*10);
                    if(temp[i - 1] != '0')
                        unit(temp[i - 1]);
                }
                else specialDozen((temp[i] - 48)*10 + temp[i - 1] - 48);
            }
            else if(temp[i - 1] != '0')
                unit(temp[i - 1]);
            if(temp[i] != '\0' || temp[i - 1] != '\0' || temp[i - 2] != '\0')
            {
                if(i == 7)
                {
                    if(temp[i] - '1' > 0)
                        printf("Millions ");
                    else printf("Million ");
                }
                if(i == 4)
                {
                    if(temp[i] - '1' > 0)
                        printf("Thousands ");
                    else printf("Thousand ");
                }
            }
        }
    }
}
void unit(char a)
{
    switch(a)
    {
        case '1': printf("One "); break;
        case '2': printf("Two "); break;
        case '3': printf("Three "); break;
        case '4': printf("Four "); break;
        case '5': printf("Five "); break;
        case '6': printf("Six "); break;
        case '7': printf("Seven "); break;
        case '8': printf("Eight "); break;
        case '9': printf("Nine "); break;
    }
}
void specialDozen(int a)
{
    switch(a)
    {
        case 10: printf("Ten "); break;
        case 11: printf("Eleven "); break;
        case 12: printf("Twelve "); break;
        case 13: printf("Thirteen "); break;
        case 14: printf("Fourteen "); break;
        case 15: printf("Fifteen "); break;
        case 16: printf("Sixteen "); break;
        case 17: printf("Seventeen "); break;
        case 18: printf("Eighteen "); break;
        case 19: printf("Nineteen "); break;
    }
}
void dozen(int a)
{
    switch(a)
    {
        case 20: printf("Twenty "); break;
        case 30: printf("Thirty "); break;
        case 40: printf("Forty "); break;
        case 50: printf("Fifty "); break;
        case 60: printf("Sixty "); break;
        case 70: printf("Seventy "); break;
        case 80: printf("Eighty "); break;
        case 90: printf("Ninety "); break;
    }
}
