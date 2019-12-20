//Display the time in 24-hour form
#include <stdio.h>
#include <ctype.h>
int main(void)
{
    int hour, minute, hour2;
    char suffix;
    printf("Enter a 12-hour time (hh:mm am/pm): ");
    scanf("%d:%d %c",&hour, &minute, &suffix);
    if (toupper(suffix) == 'P')
        hour2 = hour + 12;
    else hour2 = hour;
    printf("Equivalent 24-hour time: %d:%.2d ",hour2,minute);
    return 0;
}
