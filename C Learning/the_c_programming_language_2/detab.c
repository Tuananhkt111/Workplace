#include <stdio.h>
#define TABSPC 8 // Numbers of blanks each tab
int main()
{
    int c,n,a,l=0;
    a=n=0;
    while ( (c=getchar()) != EOF )
    if ( l<=80)
    {
        if ( c == '\n' ) // Reset counting for new line
        {
            putchar(c);
            n=a=l=0;
        }
        else if ( c == '\t' ) // Put words into column
        {
            for (n=0;n<TABSPC-a;++n)
                {putchar('*');
                 ++l;
                }
            a=0;
        }

        else // tabs
         {
            if ( a == TABSPC )
            a=0;
            putchar(c);
            ++a;++l;
        }
    }
    else
    {
        n=a=l=0;
        putchar('\n');
    };
    return 0;
}

