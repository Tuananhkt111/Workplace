//Converts a Fahrenheit temperature to Celsius
#include <stdio.h>
#define FREEZINF_PT 32.0f
#define SCALE_FACTOR (5.0f/9.0f)
int main (void)
{
    float fahrenheit, celsius;
    printf("Enter Fahrenheit temperature: ");
    scanf("%f", &fahrenheit);
    celsius = (fahrenheit - FREEZINF_PT)*SCALE_FACTOR;
    printf("Celsius equivalent is: %.1f\n", celsius);
    return 0;
}
