//Simplified version of Beaufort scale
#include <stdio.h>
int main(void)
{
    int windspeed;
    printf("Enter wind speed (in knots): ");
    scanf("%d",&windspeed);
    printf("Description: ");
    if (windspeed>63)
        printf("Hurricane");
    else if (windspeed>47)
        printf("Storm");
    else if (windspeed>27)
        printf("Gale");
    else if (windspeed>3)
        printf("Breeze");
    else if (windspeed>1)
        printf("Light air");
    else printf("Calm");
    return 0;
}
