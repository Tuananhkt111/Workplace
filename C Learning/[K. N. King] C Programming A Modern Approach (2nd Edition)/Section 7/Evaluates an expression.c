#include <stdio.h>
int main(void)
{
    float current_value, next_number;
    char ch;
    printf("Enter an expression: ");
    scanf(" %f", &current_value);

    while ((ch = getchar()) != '\n')
    {
        switch(ch)
        {
            case '+':
                scanf(" %f", &next_number);
                current_value += next_number;
                break;
            case '-':
                scanf(" %f", &next_number);
                current_value -= next_number;
                break;
            case '*':
                scanf(" %f", &next_number);
                current_value *= next_number;
                break;
            case '/':
                scanf(" %f", &next_number);
                if (next_number == 0)
                {
                    printf("Cannot divide with 0");
                    return 1;
                }
                else
                {
                    current_value /= next_number;
                    break;
                }
        }
    }
    printf("Value of expression: %.2f", current_value);
    return 0;
}
