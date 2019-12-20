//stack data structure
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#define STACK_SIZES 100
//external variables
char contents[STACK_SIZES];
int top = 0;
void make_empty(void)
{
    top = 0;
}
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
    printf("Stack overflow");
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
   char i;
   printf("Enter parentheses and/or braces: ");
   for(;i != '\n';)
   {
       i = getchar();
       if (i == '{' || i == '(')
            push(i);
       else if (i == ')')
       {
            if (pop() == '(')
                    continue;
            else
            {
                printf("Parentheses/braces are not nested properly.");
                return 0;
            }
       }
       else if (i == '}')
       {
            if (pop() == '{')
                    continue;
            else
            {
                printf("Parentheses/braces are not nested properly.");
                return 0;
            }
       }
   }
   if (is_empty()) printf("Parentheses/braces are nested properly.");
   else printf("Parentheses/braces are not nested properly.");
   return 0;
}
