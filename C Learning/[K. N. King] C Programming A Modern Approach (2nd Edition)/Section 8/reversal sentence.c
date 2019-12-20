//reverses sentence
#include <stdio.h>
int main (void)
{
    char s[1000][1000] = {0}, terminate_char, c;
    int i=0,length=-1;
    for(i=0;;i++)
    {
       scanf("%s",s[i]);
       length++;
       if(getchar()=='\n')
         break;
    }
    for(i=length;i>=0;i--)
        printf("%s ",s[i]);
    return 0;
}
