//which date comes earlier
#include <stdio.h>
int main(void)
{
    int day, month, year, day_earlier, month_earlier, year_earlier, temp;
    for (;month != 0 && day != 0 && year != 0;)
    {
        printf("Enter a date (mm/dd/yy): ");
        scanf("%d/%d/%d", &month, &day, &year);
        if (year>year_earlier && year != 0)
        temp = 0;
    else if (year<year_earlier && year != 0)
        temp = 1;
    else
    {
        if (month>month_earlier && month != 0)
            temp = 0;
        else if (month<month_earlier && month != 0)
            temp = 1;
        else
        {
            if (day>day_earlier && day != 0)
                temp = 0;
            else if (day<day_earlier && day != 0)
                temp = 1;
            else temp = 2;
        }
    }
        if (temp == 1)
        {
            day_earlier = day;
            month_earlier = month;
            year_earlier = year;
        }
    }
    printf("%.2d/%.2d/%.2d is the earliest date", month_earlier, day_earlier, year_earlier);
    return 0;
}
