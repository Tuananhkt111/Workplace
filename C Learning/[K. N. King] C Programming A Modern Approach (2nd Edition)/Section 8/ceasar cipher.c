//Ceasar cipher
#include <stdio.h>
int main (void)
{
    char ch[80], c;
    int i,n;
    printf("Enter message to be encrypted: ");
    for (i = 0; i < 80 && (c = getchar()) != '\n'; i++)
        if (c >= 'A' && c <= 'Z')
        ch[i] = ((c - 'A') + n) % 26 + 'A';
        else if (c >= 'a' && c <= 'z')
        ch[i] = ((c - 'a') + n) % 26 + 'a';
        else ch[i] = c;
    if (c == '\n')
        ch[i] = '\0';
    printf("Enter shift amount (1-25): ");
    scanf("%d", &n);
    printf("Encrypted message: ");
    printf("%s", ch);
    return 0;
}
