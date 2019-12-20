#include <stdio.h>
float celsius(float n);
/* print Fahrenheit-Celsius table for fahr = 0,20,...,300; floating version use function*/
main()
{
 printf("Fahrenheit-Celsius table for fahr = 0,20,...,300; floating version use function\n");
 float fahr;
 int lower, step, upper;
 lower = 0;   /*lower limit of temperature table*/
 upper = 300; /*upper limit*/
 step = 20;   /*step size*/

 fahr = lower;
 while (fahr <= upper)
   {
    printf("%3.0f\t%6.1f\n", fahr, celsius(fahr));
    fahr = fahr+step;
   };
   return 0;
}
float celsius(float n)
{
  float c;
  c= (5.0/9.0)*(n-32.0);
 return c;
 }
