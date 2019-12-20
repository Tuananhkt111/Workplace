/*
  Ho ten: Tran Hoang Dung
  MSSV: SE130551
  Program 1
*/
#include<stdio.h>
#include<ctype.h>
int isISBN(int *a);
int main()
{
    int a[10];
    do
    {
        int count = -1, i;
        int wrongType = 0, isEnoughDigits = 0;
        char c;
        do
        {
            for(i = 0; i < 10; i++) a[i] = -1;
            count = -1;
            wrongType = isEnoughDigits = 0;
            printf("ISBN Validator==============ISBN(0 to quit):");
            while((c=getchar()) != '\n')
            {
                if(isdigit(c)) a[++count] = c - 48;
                else
                {
                    printf("Just digits are accepted!\n");
                    wrongType = 1;
                    break;
                }
                if(count == 9) break;
            }
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
                isEnoughDigits = 1;
                break;
            }
            //Check out-of-range
            if((c=getchar()) != '\n' && count == 9)
            {
                printf("***Out of range!***\n");
                isEnoughDigits = 1;
            }
            //clear the buffer
            fflush(stdin);
        } while(count < 9);
        //Check the validation of ISBN
        if(!isEnoughDigits)
        {
            if(isISBN(a)) printf("This is a valid ISBN.\n");
            else printf("This is not a valid ISBN.\n");
        }
    }while(a[0] != 0 || a[9] >= 0);
}
//ISBN Checking function
int isISBN(int *a)
{
    int T = 0;
    for(int i = 0; i < 10; i++)
        T = T + (a[i] *(10 - i));
    if(T%11 == 0) return 1;
    return 0;
}
