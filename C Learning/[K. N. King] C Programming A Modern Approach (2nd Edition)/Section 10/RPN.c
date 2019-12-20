//Reverse Polish Notation (RPN)
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define STACK_SIZES 100
int contents[STACK_SIZES];
int top = 0;
bool is_empty(void)
{
    return top == 0;
}
bool is_full(void)
{
    return top == STACK_SIZES;
}
void stack_overflow(void)
{
    printf("Expression is too complex.\n");
    exit(EXIT_SUCCESS);
}
void stack_underflow(void)
{
    printf("Not enough operands in expression.\n");
    exit(EXIT_SUCCESS);
}
void push(char i)
{
    if(is_full())
        stack_overflow();
    else contents[top++] = i;
}
char pop (void)
{
    if(is_empty())
        stack_overflow();
    else
        return contents[--top];
}
int main (void)
{
    char ch;
    int i, temp1, temp2;

    for(;;)
    {
        printf("Enter an RPN expression:");
        for (i = 0; i < STACK_SIZES && (ch = getchar()) != '='; i++)
        {
            if (ch >= '0' && ch <= '9')
                push(ch-'0');
            else if (ch == '+')
                 push(pop() + pop());
            else if (ch == '-')
                {
                    temp1 = pop();
                    temp2 = pop();
                    push(temp2 - temp1);
                }
            else if (ch == '/')
                {
                    temp1 = pop();
                    temp2 = pop();
                    push(temp2/temp1);
                }
            else if (ch == '*')
                push(pop() * pop());
            else exit(EXIT_SUCCESS);
        }
    if (ch == '=')
        if (top == 1) printf("Value of expression: %d\n", pop());
        else  stack_underflow();
    getchar();
    top = 0;
    }
    return 0;
}
