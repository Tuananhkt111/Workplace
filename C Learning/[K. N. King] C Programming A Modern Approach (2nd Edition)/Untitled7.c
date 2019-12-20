/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 1
*/
#include<stdio.h>
#include<ctype.h>
#include<stdbool.h>
bool isISBN(int a[]);
int main()
{
    int a[10];
    //Enter value of ISBN
    do
    {
        int count = -1;
        bool wrongType = false, rangeNotEqual = false;
        char c;
        //Accept input
        do
        {
            //Reset default
            for(int i = 0; i < 10; i++) a[i] = -1;
            count = -1;
            wrongType = rangeNotEqual = false;
            //Enter the ISBN value
            printf("ISBN Validator==============ISBN(0 to quit):");
            while((c=getchar()) != '\n')
            {
                //Check error when input contains other types
                if(isdigit(c)) a[++count] = c - 48;
                else
                {
                    printf("Just digits are accepted!\n");
                    wrongType = true;
                    break;
                }
                if(count == 9) break;
            }
            //Check range of ISBN
            if(count < 9 && !wrongType)
            {
                //Check the QUIT selection
                if(count == 0 && a[0] == 0)
                {
                    printf("Have a nice day!\n");
                    return 0;
                }
                //**********************************
                printf("***Not enough digits!***\n");
                rangeNotEqual = true;
                break;
            }
            //Check out-of-range
            if((c=getchar()) != '\n' && count == 9)
            {
                printf("***Out of range!***\n");
                rangeNotEqual = true;
            }
            //clear the buffer
            fflush(stdin);
        } while(count < 9);
        //Check the validation of ISBN
        if(!rangeNotEqual)
        {
            if(isISBN(a)) printf("This is a valid ISBN.\n");
            else printf("This is not a valid ISBN.\n");
        }
    }while(a[0] != 0 || a[9] >= 0);
}
//ISBN Checking function
bool isISBN(int a[])
{
    int T = 0;
    for(int i = 0; i < 10; i++)
        T += a[i] *(10 - i);
    if(T%11 == 0) return true;
    return false;
}

