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
int evaluate_RPN_expression(const char *expression)
 {
            int temp1, temp2;
            for(;*expression != '='; expression++)
            {
                if (*expression >= '0' && *expression <= '9')
                push(*expression-'0');
            else if (*expression == '+')
                 push(pop() + pop());
            else if (*expression == '-')
                {
                    temp1 = pop();
                    temp2 = pop();
                    push(temp2 - temp1);
                }
            else if (*expression == '/')
                {
                    temp1 = pop();
                    temp2 = pop();
                    push(temp2/temp1);
                }
            else if (*expression == '*')
                push(pop() * pop());
            else exit(EXIT_FAILURE);
            }
    return pop();
}
int main (void)
{
    char ch[STACK_SIZES];
    int i;

    for(;;)
    {
        printf("Enter an RPN expression:");
        for (i = 0; i < STACK_SIZES && (ch[i] = getchar()) != '\n'; i++);
    printf("Value of expression: %d\n", evaluate_RPN_expression(ch));
    getchar();
    top = 0;
    }
    return 0;
}
