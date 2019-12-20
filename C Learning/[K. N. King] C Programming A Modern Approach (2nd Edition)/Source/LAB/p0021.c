#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
//Support functions
int stringToNumber(char str[]);
bool isValidInput(char date[]);
bool isLeapYear(int year);
int dayOfYear();
int dayOfWeek();
//Main functions
void inputDate();
void output();
//Global functions
char dateFormat[11];
int day, month, year;

int main()
{
    inputDate();
    output();
}
//check input is valid or not
bool isValidInput(char date[])
{
    int n = strlen(date);
    if(n != 10)
        return false;
    for(int i = 0; i < strlen(date); i++)
    {
        switch(i)
        {
            case 0: case 1: case 3: case 4: case 6: case 7: case 8: case 9:
                if(!isdigit(date[i])) return false; break;
            case 2: case 5:
                if(date[i] != '/') return false; break;
        }
    }
    return true;
}
//input date in string format to get day, month and year
void inputDate()
{
    //Local variables
    char dayStr[3], monthStr[3], yearStr[5];
    int i;
    bool isValidDate;
    //check validation of input (reentering is required if not valid)
    do
    {
        isValidDate = true;
        i = 0;
        printf("Please enter a date (dd/mm/yyyy):");
        scanf("%[^\n]", dateFormat);
        dateFormat[strlen(dateFormat)] = '\0';
        fflush(stdin);
        if(!isValidInput(dateFormat)) isValidDate = false;
        //Get day
        for(int j = 0; j < 2; i++, j++)
            dayStr[j] = dateFormat[i];
        dayStr[2] = '\0';
        day = stringToNumber(dayStr);
        i++;
        //get month
        for(int j = 0; j < 2; i++, j++)
            monthStr[j] = dateFormat[i];
        monthStr[2] = '\0';
        month = stringToNumber(monthStr);
        i++;
        //get year
        for(int j = 0; j < 4; i++, j++)
            yearStr[j] = dateFormat[i];
        yearStr[4] = '\0';
        year = stringToNumber(yearStr);
        //check valid number
        switch(month)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(day > 31) isValidDate = false; break;
            case 4: case 6: case 9: case 11:
                if(day > 30) isValidDate = false; break;
            case 2: if(isLeapYear(year) && day > 29) isValidDate = false;
                    if(!isLeapYear(year) && day > 28) isValidDate = false; break;
            default: isValidDate = false;
        }
        if(!isValidDate) printf("Invalid Input!\n");
    } while(!isValidDate);
}
bool isLeapYear(int year)
{
    if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
        return true;
    return false;
}
//convert string to number
int stringToNumber(char str[])
{
    //Local variables
    int n = strlen(str) - 1, base = 1, num = 0;
    //convert string to number
    for(int i = 0; i <= n; i++)
    {
        num += (str[n - i] - '0')*base;
        base *= 10;
    }
    return num;
}
//find days of year
int dayOfYear()
{
    int dOY = 0, a[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if(isLeapYear(year)) a[1]++;
    for(int i = 0; i < (month - 1); i++)
    {
        dOY += a[i];
    }
    dOY += day;
    return dOY;
}
//find the day in week
void dayOfWeek()
{
    switch(((year) + (year-1)/4 - (year-1)/100 + (year-1)/400 + dayOfYear()) % 7)
    {
        case 0: printf("Sunday"); break;
        case 1: printf("Monday"); break;
        case 2: printf("Tuesday"); break;
        case 3: printf("Wednesday"); break;
        case 4: printf("Thursday"); break;
        case 5: printf("Friday"); break;
        case 6: printf("Saturday"); break;
    }
}
//find weeks of year
int weekOfYear()
{

}
//display to screen the result
void output()
{
    printf("Day of year: %d\n", dayOfYear());
    printf("Day of week: ");
    dayOfWeek();
    printf("\n");
}
