//Ceasar cipher ver 2
#include <stdio.h>
void encrypt(char *message, int shift);
int main (void)
{
    char ch[80], c;
    int i,n;
    printf("Enter message to be encrypted: ");
    for (i = 0; i < 80 && (ch[i] = getchar()) != '\n'; i++)
        if (c == '\n')
        ch[i] = '\0';

    printf("Enter shift amount (1-25): ");
    scanf("%d", &n);
    printf("Encrypted message: ");
    encrypt(ch, n);
    return 0;
}
void encrypt(char *message, int shift)
{
    for(;*message; message++)
    if (*message >= 'A' && *message <= 'Z')
        printf("%c", ((*message - 'A') + shift) % 26 + 'A');
        else if (*message >= 'a' && *message <= 'z')
        printf("%c", ((*message - 'a') + shift) % 26 + 'a');
        else printf("%c", *message);

}
