
/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 2
*/

#include<stdio.h>
#include<ctype.h>
#include<stdbool.h>
#include<string.h>
#define MAXN 50
//Data
struct data
{
    char code[9];
    char name[21];
    float wage_coefficient;
    float salary;
};
//Mini Functions
int getUserChoice();
bool isFull(int *pn);
bool isEmpty(int *pn);
float getValue();
int search(char value[], struct data e[], int *pn);
void inputCode(char code[]);
char* lTrim (char s[]);
char* rTrim (char s[]);
char* trim (char s[]);
char* nameStr(char s[]);
void inputName(char name[]);
//Menu functions
void addNewEmployees(struct data e[], int *pn);
void removeOne(struct data e[], int *pn);
void printTotal(struct data e[], int *pn);
void printAsc(struct data e[], int *pn);
//Main function
int main()
{
    struct data employee[MAXN]; //data of employees
    int n = 0; //current number of employees
    int userChoice; //user choice
    do
    {
        userChoice = getUserChoice();
        switch(userChoice)
        {
            case 1: addNewEmployees(employee, &n); break;
            case 2: printTotal(employee, &n); break;
            case 3: removeOne(employee, &n); break;
            case 4: printAsc(employee, &n); break;
            default: printf("Goodbye!\n");
        }
    } while(userChoice >= 1 && userChoice <= 5);
    fflush(stdin);
    getchar();
    return 0;
}
//Menu function
int getUserChoice()
{
    bool keeptrying = true;
    int rc;
    char after;
    int choice;
    printf("\n1-Adding five new employees.");
    printf("\n2-Print out a list of total salary for each employee.");
    printf("\n3-Remove an employee based on a code inputted.");
    printf("\n4-Print the list in ascending order based on Salary.");
    printf("\nOthers-Quit.");
    printf("\nChoose an operation:");
    do
    {
        rc = scanf("%d%c", &choice, &after);
        //Test wrong types
        if(rc != 2)
        {
            printf("***No input accepted!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        //Test for trailing characters
        else if(after != '\n')
        {
            printf("***Trailing characters!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        else keeptrying = false;
    } while(keeptrying);
    return choice;
}
//Testing whether an array is full or not
bool isFull(int *pn)
{
    return *pn == MAXN;
}
//Testing whether an array is empty or not
bool isEmpty(int *pn)
{
    return *pn == 0;
}
//Get value of float
float getValue()
{
    float val;
    bool keeptrying = true;
    int rc;
    char after;
    do
    {
        rc = scanf("%f%c", &val, &after);
        //Test wrong types
        if(rc != 2)
        {
            printf("***No input accepted!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        //Test for trailing characters
        else if(after != '\n')
        {
            printf("***Trailing characters!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        else if(val < 0)
        {
            printf("***Value is positive!***\n");
            printf("Reenter:");
            fflush(stdin);
        }
        else keeptrying = false;
    } while(keeptrying);
    return val;
}
//Find the position of employee which matches code inputted
int search(char value[], struct data e[], int *pn)
{
    for(int i = 0; i < *pn; i++) if(strcmp(value, e[i].code) == 0) return i;
    return -1;
}
// Format string for names
char* nameStr(char s[])
{
    trim(s); //trim all extra blanks
    strlwr(s); //convert it to lower case
    int L = strlen(s);
    for(int i = 0; i < L; i++)
        if(i == 0 || (i > 0 && s[i - 1] == ' ')) s[i] = toupper(s[i]);
    return s;
}
//right Trim
char* rTrim (char s[])
{
    int i = strlen(s) - 1;
    while(s[i] == ' ') i--;
    s[i+1] = '\0';
    return s;
}
//left Trim
char* lTrim (char s[])
{
    int i = 0;
    while(s[i] == ' ') i++;
    if(i > 0) strcpy(&s[0], &s[i]);
    return s;
}
//Trim both left and right
char* trim (char s[])
{
    rTrim(lTrim(s));
    char *ptr = strstr(s,"  ");
    while(ptr != NULL)
    {
        strcpy(ptr, ptr+1);
        ptr = strstr(s, "  ");
    }
    return s;
}
//Input code of employee
void inputCode(char code[])
{
    bool keeptrying = true;
    int rc;
    char after;
    printf("Code(only digits and letters are accepted):");
    do
    {
        rc = scanf("%8s%c", code, &after);
        if(after != '\n')
        {
            printf("***Maximum length of code is 8!***\n");
            printf("Code:");
            fflush(stdin);
        }
        else keeptrying = false;
    } while(keeptrying);
}
//Input name of employee
void inputName(char name[])
{
    bool keeptrying = true;
    char after;
    printf("Name:");
    do
    {
        scanf("%20[^\n]%c", name, &after);
        //Test for trailing characters
        if(after != '\n')
        {
            printf("***Maximum length of name is 20!***\n");
            printf("Name:");
            fflush(stdin);
        }
        else keeptrying = false;
    } while(keeptrying);
    nameStr(name);
}
//Add 5 new employees to database
void addNewEmployees(struct data e[], int *pn)
{
    if(isFull(pn)) printf("\nSorry! Database is full.\n");
    else
    {
        printf("Please give information about 5 new employees.\n");
        for(int i = 0; i < 5 ; (*pn)++, i++)
        {
            printf("\nEmployee %d\n", *pn + 1);
            inputCode(e[*pn].code);
            inputName(e[*pn].name);
            printf("Salary:");
            e[*pn].salary = getValue();
            printf("Wage coefficient:");
            e[*pn].wage_coefficient = getValue();
        }
        printf("Added\n");
    }
}
//Remove one employee from database
void removeOne(struct data e[], int *pn)
{
    int pos;
    char code[9];
    if(isEmpty(pn))
    {
        printf("\nSorry: Database is empty.\n");
        return;
    }
    printf("Enter code to remove the appropriate employee:\n");
    inputCode(code);
    if((pos = search(code, e, pn)) >= 0)
    {
        for(int i = pos; i < *pn-1; i++) e[i] = e[i + 1];
        (*pn)--;
        printf("Removed!\n");
    }
    else printf("Not Found!\n");
}
//Print a list of total money for each employee
void printTotal(struct data e[], int *pn)
{
    if(isEmpty(pn)) printf("\nSorry: Database is empty.\n");
    else
    {
        printf("List of total salary for each employee:\n");
        printf("Code\t\tName\t\t\tTotal Salary\n");
        for(int i= 0; i < *pn; i++)
            printf("%-8s\t%-20s\t%-f\n", e[i].code, e[i].name, e[i].salary*e[i].wage_coefficient);
    }
}
//Print the list in ascending order by Salary
void printAsc(struct data e[], int *pn)
{
    if(isEmpty(pn)) printf("\nSorry: No employees.\n");
    else
    {
        struct data p;
        for(int i = 0; i<*pn-1;i++)
            for(int j = *pn - 1; j>i; j--)
                if(e[j].salary < e[j - 1].salary)
                    {
                        p = e[j];
                        e[j] = e[j - 1];
                        e[j - 1] = p;
                    }
        printf("List of employees in ascending order by Salary:\n");
        printf("Code\t\tName\t\t\tSalary\t\t\tWage_Coefficient\n");
        for(int i= 0; i < *pn; i++)
            printf("%-8s\t%-20s\t%-f\t\t%-f\n", e[i].code, e[i].name, e[i].salary, e[i].wage_coefficient);
    }
}
