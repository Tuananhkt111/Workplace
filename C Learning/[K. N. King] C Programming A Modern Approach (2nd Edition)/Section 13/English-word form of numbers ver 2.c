//English-word for number ver 2
#include <stdio.h>
int main(void)
{
    char *a[10] = {"ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
         *b[10] = {[2] = "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"},
         *c[10] = {"", "-one", "-two", "-three", "-four", "-five", "-six", "-seven", "-eight", "-nine"};

    int x, y;
    printf("Enter a two-digit number: ");
    scanf("%1d%1d", &x, &y);
    printf("You entered the number ");
    if (x == 1)
        printf("%s", a[y]);
    if (x>1)
    {
        printf("%s%s", b[x], c[y]);
    }
    return 0;
}
