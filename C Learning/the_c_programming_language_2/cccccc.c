#include <stdio.h>
int Fi(int n)
{
if(n<=1)   return 1;
    else return Fi(n-1) + Fi(n-2);
return 0;
}
int main()
{
int n;
printf(" In ra n phan tu trong Fibonacci\n");
for(n=0;n<100;n++)
{
printf("%d\n",Fi(n));
}
getch();
}
