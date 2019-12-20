//convert to letter grade
#include <stdio.h>
int main(void)
{
    int x;
    printf("Enter numerical grade: ");
    scanf("%d", &x);
    if (x>=0 && x<=99)
    {
    printf("Letter grade: ");
    switch (x/10)
    {
        case 0: case 1: case 2: case 3: case 4: case 5:
            printf("F"); break;
        case 6: printf("D"); break;
        case 7: printf("C"); break;
        case 8: printf("B"); break;
        case 9: printf("A"); break;
    }}
    else printf("Error grade");
}
