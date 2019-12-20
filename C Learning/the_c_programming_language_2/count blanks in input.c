#include <stdio.h>
/* count blanks in input */
int main()
{
 int n1,c;
 n1 = 0;
 while ( (c= getchar()) != EOF)
 if (c == ' ')
 ++n1;
 printf("%d\n",n1);
 return 0;
}
