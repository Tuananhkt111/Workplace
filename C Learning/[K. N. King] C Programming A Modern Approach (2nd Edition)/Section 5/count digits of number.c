//count digits of number
#include <stdio.h>
#define MAX 9999
int main(void)
{
    int x;
    printf("Enter a number: ");
    scanf("%d",&x);
    if (x>9999)
        printf("%d is too big for this program",x);
    else if (x>999)
        printf("The number %d has 4 digits",x);
    else if (x>99)
        printf("The number %d has 3 digits",x);
    else if (x>9)
        printf("The number %d has 2 digits",x);
    else printf("The number %d has 1 digit",x);
    return 0;
}
