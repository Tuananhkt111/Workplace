//Display the time in 12-hour form
#include <stdio.h>
int main(void)
{
    int hour, minute, hour2;
    printf("Enter a 24-hour time (hh:mm): ");
    scanf("%d:%d",&hour, &minute);
    if (hour>12)
        hour2 = hour - 12;
    else hour2 = hour;
    printf("Equivalent 12-hour time: %d:%.2d ",hour2,minute);
    if (hour>12)
        printf("PM");
    else printf("AM");
    return 0;
}
