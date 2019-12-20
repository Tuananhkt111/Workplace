/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 1
*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdbool.h>
int main()
{
    int a[10];
    bool keeptrying = true;
    int rc;
    char after;
    do
    {
        printf("ISBN Validator==============ISBN(0 to quit):");
    }
    //Enter value of ISBN
    do
    {
        printf("Total sought:");
        rc = scanf("%d%c",&total, &after);
        if(rc == 0)
        {
            printf("***No input accepted!***\n");
            fflush(stdin);
        }
        else if(after != '\n')
        {
            printf("***Trailing characters!***\n");
            fflush(stdin);
        }
        else if(total < 2 || total > 12)
        {
            printf("***Out of range!***\n");
            fflush(stdin);
        }
        else keeptrying = false;
        printf("This is a valid ISBN.\n");
    else printf("This is not a valid ISBN.\n");
    } while(keeptrying);
}
bool isISBN(int a[])
{
    int T = 0;
    for(int i = 1; i < 11; i++)
        T += a[i]*(11 - i);
    if(T%11 == 0)
}
