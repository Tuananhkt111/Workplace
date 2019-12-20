//Enter phone number
#include <stdio.h>
int main(void)
{
    int x,y,z;
    printf("Enter phonr number [(xxx) xxx-xxxx]: ");
    scanf("(%d) %d-%d", &x, &y, &z);
    printf("You enter %d.%d.%d",x,y,z);
    return 0;
}
