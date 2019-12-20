//Displays a date
#include <stdio.h>
int main (void)
{
    char *month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int day, mth, yr;
    printf("Enter a date (mm/dd/yyyy): ");
    scanf("%2d/%2d/%4d", &mth, &day, &yr);
    printf("You entered the date %s %d %d", month[mth - 1], day, yr);
    return 0;
}
