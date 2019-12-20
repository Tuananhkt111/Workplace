#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
//Support functions
bool isValidInput(char date[]);
bool isLeapYear(int year);
int dayOfYear();
void dayOfWeek();
int weekOfYear();
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
    bool isValidDate;
    //check validation of input (reentering is required if not valid)
    do
    {
        isValidDate = true;
        printf("Please enter a date (dd/mm/yyyy):");
        scanf("%[^\n]", dateFormat);
        dateFormat[strlen(dateFormat)] = '\0';
        fflush(stdin);
        if(!isValidInput(dateFormat)) isValidDate = false;
        //Get day
        day = (dateFormat[0] - '0')*10 + (dateFormat[1] - '0');
        //get month
        month = (dateFormat[3] - '0')*10 + (dateFormat[4] - '0');
        //get year
        year = (dateFormat[6] - '0')*1000 + (dateFormat[7] - '0')*100 + (dateFormat[8] - '0')*10 + (dateFormat[9] - '0');
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
    switch((day + 2*month + (3*(month+1))/ 5 + year + (year / 4)) % 7)
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
    return (dayOfYear() % 7 == 0) ? dayOfYear()/7 : dayOfYear()/7 + 1;
}
//display to screen the result
void output()
{
    printf("Day of year: %d\n", dayOfYear());
    printf("Week of year: %d\n", weekOfYear());
    printf("Day of week: ");
    dayOfWeek();
    printf("\n");
}
