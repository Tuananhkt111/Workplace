#include <stdio.h>
#define MAXLINE 1000 /* maximum length of line */
int getline( char s[], int maxline);
void reverse( char s[]);
int main(void)
{
 char s[MAXLINE]; /* current line from input */
 int a; /* length of current line*/
 while ((a=getline(s,MAXLINE))>0)
 {reverse(s);
 printf("reversed string: %s",s);
 }
 return 0;
}
/* getline: read a line from input, show its length */
int getline(char s[], int maxline)
{
 int i,c;
 for(i=0; i<maxline-1 && (c=getchar())!=EOF && c!='\n';++i)
 s[i]=c;
 if (c=='\n')
 {s[i]=c;
  ++i;
  s[i]='\0';};
  return i;
}
/* reverse: reverses the character string in a line */
void reverse(char s[])
{
 int i,j=0;
 char k;
 for(i=0; s[i]!='\0';++i);
 --i;
 if (s[i]=='\n')
    --i;
 while (j<i)
 {k=s[i];
  s[i]=s[j];
  s[j]=k;
  --i;++j;};
}

