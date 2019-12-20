#include <stdio.h>
/* print Celsius-Fahrenheit table for celsius = 0,10,...,150; floating version*/
main()
{
 printf("Celsius-Fahrenheit table for celsius = 0,10,...,150; floating version\n");
 float fahr, celsius;
 int lower, step, upper;
 lower = 0;   /*lower limit of temperature table*/
 upper = 150; /*upper limit*/
 step = 10;   /*step size*/

 celsius = lower;
 while (celsius <= upper)
   {
    fahr = (9.0/5.0)*celsius-32.0;
    printf("%3.0f\t%6.1f\n", celsius, fahr);
    celsius = celsius+step;
   };
}
