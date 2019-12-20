/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 1
*/
#include<stdio.h>
#include<stdbool.h>
bool isISBN(char a[]);
int main()
{
    char a[10];
    bool keeptrying = true;
    int c;
    int rc;
    char after;
    //Enter value of ISBN
    do
    {
        printf("ISBN Validator==============ISBN(0 to quit):");
        for(int i = 0; i < 10; i++)
        {
            a[i] = getchar();
            if(!isdigit(a[i])) printf("aaa");
        }
    }while((a[0] - 48) != 0);
    if(isISBN(a))
        printf("This is a valid ISBN.\n");
    else printf("This is not a valid ISBN.\n");
    } while(keeptrying);
}
bool isISBN(int a[])
{
    int T = 0;
    for(int i = 1; i < 11; i++)
        T += (a[i] - 48) *(11 - i);
    if(T%11 == 0) return true;
    return false;
}
