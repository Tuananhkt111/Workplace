#include <stdio.h>
int main()
{printf("In ra n phan tu trong Fibonaci\n");
 int a = 1,b = 2,c = 0,n;
 for(n=0;n<100;n++)
 {c=a+b;
  a=b;
  b=c;
  printf("%d\n",c);}
  return 0;

}
