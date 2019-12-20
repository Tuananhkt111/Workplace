//stack data structure
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#define STACK_SIZES 100
//external variables
char contents[STACK_SIZES];
char *top_ptr = contents;
void make_empty(void)
{
    top_ptr = contents;
}
bool is_empty(void)
{
    return top_ptr == contents;
}
bool is_full(void)
{
    return top_ptr == contents + STACK_SIZES;
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
    else *top_ptr++ = i;
}
char pop (void)
{
    if(is_empty())
        stack_overflow();
    else
        return *--top_ptr;
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
