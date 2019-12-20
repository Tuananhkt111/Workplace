#include <stdio.h>
int main()
{
 float a;
 while((a=getchar()) != EOF)
 {if ( a =='\t')
    {putchar('\\');
     putchar('t');}
   else { if ( a =='\b')
    {putchar('\\');
     putchar('b');}
     else { if ( a =='\\')
    {putchar('\\');
     putchar('\\');}
     else putchar(a);}
   }}

   return 0;
 }
