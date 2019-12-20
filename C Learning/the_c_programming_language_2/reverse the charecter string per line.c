
#include <stdio.h>
#define MAXLINE 1000 /* maximum length of line */
char r[MAXLINE];
int getline( char s[], int maxline);
char reverse( char s[]);
int main()
{
 char s[MAXLINE]; /* current line from input */
 int a; /* length of current line*/
 while ((a=getline(s,MAXLINE))>0)
 printf("reversed string: %s",reverse(s));
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
char reverse(char s[])
{
 extern char r[MAXLINE];
 int i,j=0;
 for(i=0; s[i]!='\n';++i);
 --i; /* raw line without '\n' */
 while (i>=0)
 {r[j]=s[i];
  ++j;
  --i;};
  r[j]='\n';
  ++j;
  r[j]='0';
  return r;
}
/* sai roi dcm */
