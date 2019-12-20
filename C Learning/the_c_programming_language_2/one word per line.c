#include <stdio.h>
#define IN 1 /*inside a word*/
#define OUT 0 /*outside a word*/
/* count lines, words, and characters in input */
int main()
{
 int c,nw,state;
 state=OUT;
 nw=0;
 while ((c=getchar())!= EOF)

  { if (c==' '||c=='\t'||c=='\n')
   putchar('\n');
 else putchar(c);}
;
return 0; }
