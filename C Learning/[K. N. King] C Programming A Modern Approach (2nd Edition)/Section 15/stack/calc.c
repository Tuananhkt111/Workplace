//Reverse Polish Notation (RPN)
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "stack.h"
int main (void)
{
    char ch;
    int i, temp1, temp2;
    extern int top;
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
