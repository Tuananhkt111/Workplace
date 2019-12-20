#include <stdio.h>
int main()
{
 int c,nchar[256],i,j;
 for(i=0;i<256;++i)
 nchar[i]=0;
 while ((c=getchar())!= EOF)
 ++nchar[c];
 for(i=0;i<256;++i)
   {putchar(i);
    for(j=0;j<nchar[i];++j)
    putchar('*');
    putchar('\n'); }
    return 0;
    }
