#include <stdio.h>
/* count newlines in input */
int main()
{
 int n1,c,n2,n3;
 n1 = 0; n2 = 0; n3 = 0;
 while ( (c= getchar()) != EOF)
 {if (c == '\n')
    ++n1;
  if (c == '\t')
    ++n2;
  if (c == ' ')
    ++n3; }
 printf("Numbers of newlines:%d\ntabs:%d\nblanks:%d\n",n1,n2,n3);
 return 0;
}
