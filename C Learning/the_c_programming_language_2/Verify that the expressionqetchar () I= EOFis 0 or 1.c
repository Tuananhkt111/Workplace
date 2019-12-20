#include <stdio.h>
/*  Verify that the expressionqetchar () I= EOFis 0 or 1 */
main()
{
 int a;
 printf("Nhap gia tri cua a:");
 a = (getchar()!= EOF);
 printf("%d\n",a);
 }
