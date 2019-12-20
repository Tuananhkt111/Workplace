#include <stdio.h>
int main()
{
 int a, b='-';
 while((a=getchar()) != EOF)
 { if ( a ==' ')
   { if(b!=' ') putchar(a);}
   else putchar(a);
   b=a;}
   return 0;
 }
