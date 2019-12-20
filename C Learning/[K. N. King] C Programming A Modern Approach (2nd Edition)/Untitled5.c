/*
  Ho ten: Tran Hoang Dung
  MSSV: SE130551
  Program 2
*/
#include<stdio.h>
#include<stdlib.h>
#define MAXN 100
int menu();
int isFull(double *a, int n);
int isEmpty(double *a, int n);
double input();
void add(double value, double *a, int *pn);
int search(double x, double *a, int n);
int main()
{
    double a[MAXN];
    double value;
    int n = 0, i;
    int userChoice;
    do
    {
        userChoice = menu();
        switch(userChoice)
        {
            case 1: //Add a value
                if(isFull(a, n)) printf("\nSorry! The array is full.\n");
                else
                {
                    printf("Input an added value:");
                    value = input();
                    add(value, a, &n);
                    printf("Added\n");
                };
                break;
            case 2: //Search a value
                if(isEmpty(a, n)) printf("\nSorry: The array is empty.\n");
                else
                {
                    printf("Input the searched value:");
                    value = input();
                    int num = search(value, a, n);
                    printf("%lf appears %d time(s).\n", value, num);
                }
                break;
            case 3: //Print the array
                if(isEmpty(a, n)) printf("\nSorry: The array is empty.\n");
                else
                {
                    printf("The elements of array:\n");
                    for(int i= 0; i < n; i++) printf("%lf ", a[i]);
                }
                break;
            case 4: //Print the elements of array which is in the range
                if(isEmpty(a, n)) printf("\nSorry: The array is empty.\n");
                else
                {
                    double minVal, maxVal;
                    do
                    {
                        printf("Enter minimum:");
                        minVal = input();
                        printf("Enter maximum:");
                        maxVal = input();
                        if(minVal > maxVal) printf("Min <= Max!\n");
                    } while(minVal > maxVal);
                    printf("Values in the range:");
                    for(i = 0; i < n; i++)
                        if(a[i] >= minVal && a[i] <= maxVal)
                            printf("%lf ", a[i]);
                }
                break;
            case 5: //Print the array in ascending order, positions of elements are preserved
                 if(isEmpty(a, n)) printf("\nSorry: The array is empty.\n");
                else
                {
                    double *adds = (double *) calloc(n, sizeof(double));
                    for(i = 0; i < n; i++) adds[i] = a[i];
                    double t;
                    for(int i = 0; i < n - 1; i++)
                        for(j = n - 1; j > i; j--)
                            if(adds[j] < adds[j - 1])
                            {
                                t = adds[j];
                                adds[j] = adds[j - 1];
                                adds[j- 1] = t;
                            }
                    printf("The array in ascending order:\n");
                    for(i= 0; i < n; i++) printf("%lf ", adds[i]);
                    free(adds);
                }
                break;
            default: printf("Goodbye!\n");
        }
    } while(userChoice >0  && userChoice < 6);
    fflush(stdin);
    getchar();
    return 0;
}
int menu()
{
    int choice;
    printf("\n1-Add a value");
    printf("\n2-Search a value");
    printf("\n3-Print out the array");
    printf("\n4-Print out values in a range");
    printf("\n5-Print out the array in ascending order");
    printf("\nOthers-Quit");
    printf("\nChoose:");
    scanf("%d",&choice);
    return choice;
}
int isFull(double *a, int n)
{
    return n == MAXN;
}
int isEmpty(double *a, int n)
{
    return n == 0;
}
void add(double value, double *a, int *pn)
{
    a[*pn] = value;
    (*pn)++;
}
int search(double x, double *a, int n)
{
    int num = 0;
    int i;
    for(i = 0; i < n; i++)
        if(a[i] == x) num++;
    return num;
}
double input()
{
    double val;
    int keeptrying = 1;
    int rc;
    char after;
    do
    {
        rc = scanf("%lf%c", &val, &after);
        if(rc != 2)
        {
            printf("***No input accepted!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        else if(after != '\n')
        {
            printf("***Trailing characters!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        else keeptrying = 0;
    } while(keeptrying);
    return val;
}

