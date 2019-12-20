#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "stack.h"
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
