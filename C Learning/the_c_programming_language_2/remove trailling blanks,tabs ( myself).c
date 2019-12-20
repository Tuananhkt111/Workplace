#include <stdio.h>
#define MAXLINE 1000 /* maximum characters in a line */
int getline( char line[], int maxline);
int removetrail(char rline[]);
int main()
{
 int a;              /* current length in line */
 char line[MAXLINE]; /* current line from input */
 while ((a=getline(line,MAXLINE))>0)
  if (removetrail(line)>0)
  printf("%s\n",line);
 return 0;
}
/* getline: read a line from input, show its length */
int getline( char line[], int maxline)
{
 int i,c;
 for(i=0; i<maxline-1 && ((c=getchar())!=EOF) && (c!='\n');++i)
  line[i]=c;
  if (c=='\n')

   {line[i]=c;
    ++i;
    line[i]='\0';}
    return i;
}
/* removetrail: remove trailing blanks and tabs, eliminate empty lines */
int removetrail(char line[])
{
 int i;
 for (i=0; line[i]!='\n';++i);
 --i;                                            /* let it become raw line without '\n' */
 for (i>0; line[i]==' '||line[i]=='\t';--i);    /* remove trailing blanks and tabs */
 if (i>0) /* non empty line */
 {++i;
  line[i]='\n';
  ++i;
  line[i]='\0';
  }
 return i;
}

