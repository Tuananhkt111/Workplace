#include <stdio.h>
int main()
{
 float a;
 while((a=getchar()) != EOF)
 {if ( a =='\t')
    {printf("\\");
     printf("t");}
   else { if ( a =='\b')
    {printf("\\");
     printf("b");}
     else { if ( a =='\\')
    {printf("\\");
     printf("\\");}
     else putchar(a);}
   }}

   return 0;
 }
