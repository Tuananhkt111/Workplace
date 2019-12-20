#include<stdio.h>
#define TABINC 8
int main()
{
    int pos,c,n=0,temp,i=0;
    char s[97];
    for(pos=1;(c=getchar())!=EOF;++pos)
    {   ++n;
        s[n]=c;

        if(c == '\n')
        {putchar('\n');
            n = pos = 0;}
        else {s[n]=c;
                  if ( s[n] == '\t')
                    if (n<88)
                  {pos =pos + ( TABINC - (pos -1) % TABINC) - 1;
                   putchar(s[n]);
                   n = n +( TABINC - (n -1) % TABINC) - 1;}
                   else {n=0;
                        putchar('\n');}
                 else if (s[n] == ' ')
                        if (n<96)
                            temp=n;
                            ++i;
                        else {putchar('\n');
                        n=pos=0;}
                else for(;i>0 && n<=temp;--i)
                putchar(' ');
                     putchar(s)




                     ++i;}
    }

return 0;
}
