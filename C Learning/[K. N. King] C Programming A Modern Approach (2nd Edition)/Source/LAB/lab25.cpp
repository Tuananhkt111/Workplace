#include<stdio.h>
#include<string.h>
#include<stdbool.h>
struct ATMaccount {
    char id[15];
    char name[20];
    double balance;
    char moneyType[4];
    char filename[50];
};

void readInfo(struct ATMaccount *acc, char *filename);
void writeFile(struct ATMaccount *acc);

int getUserChoice();
void performUserChoice(int userChoice, bool *isLogIn, struct ATMaccount *acc1, struct ATMaccount *acc2);

void registerAccount();
void login(struct ATMaccount *acc, bool *isLogIn);
void transfer(struct ATMaccount *acc1, struct ATMaccount *acc2, bool *isLogIn);
void withdraw(struct ATMaccount *acc, bool *isLogIn);


int main()
{
    struct ATMaccount acc1, acc2;
    bool isLogIn = false;
    int userChoice;
    do
    {
        userChoice = getUserChoice();
        performUserChoice(userChoice, &isLogIn, &acc1, &acc2);
    } while(userChoice != 5);
    return 0;
}
int getUserChoice()
{
    int choice, isValidInput;
    do
    {
        printf("------Welcome to ATM Service------\n");
        printf("1. Log in\n");
        printf("2. Register ATM account\n");
        printf("3. Withdraw money\n");
        printf("4. Transfer money\n");
        printf("5. Exit\n");
        isValidInput = scanf("%d", &choice);
    } while (choice < 1 || choice > 5);
    return choice;
}
void performUserChoice(int userChoice, bool *isLogIn, struct ATMaccount *acc1, struct ATMaccount *acc2)
{
    switch(userChoice)
    {
        case 1: login(acc1,isLogIn); break;
        case 2: registerAccount(); break;
        case 3: withdraw(acc1, isLogIn); break;
        case 4: transfer(acc1, acc2, isLogIn); break;
        case 5: return;
    }
}
void registerAccount()
{
    FILE *fp;
    char id[15], pin[5], accountName[20], moneyType[3], filenameInfo[50], filenameAcc[50];
    double balance;
    printf("------Register------\n");
    printf("Enter your ID account(must be 14 digits only):");
    scanf("%14s", id);
    strcpy(filenameInfo, id);
    strcpy(filenameAcc, id);
    fflush(stdin);
    printf("Enter your PIN(must be 4 digits only):");
    scanf("%4s", pin);
    fflush(stdin);
    printf("Enter your account name:");
    scanf("%[^\n]", accountName);
    printf("%s\n", accountName);
    fflush(stdin);
    printf("Enter your balances:");
    scanf("%lf", &balance);
    fflush(stdin);
    printf("Enter money type of your account:");
    scanf("%3s", moneyType);
    fflush(stdin);

    strcat(filenameInfo, "ATMinfo.txt");
    fp = fopen(filenameInfo,"w");
    fputs(id, fp);
    fprintf(fp, "\n");
    fputs(pin, fp);
    fprintf(fp, "\n");
    fclose(fp);

    strcat(filenameAcc, "UserAccount.txt");
    fp = fopen(filenameAcc, "w");
    fputs(id, fp);
    fprintf(fp, "\n");
    fflush(stdin);
    fprintf(fp, "%s\n", accountName);
    fprintf(fp, "%lf\n", balance);
    fputs(moneyType, fp);
    fprintf(fp, "\n");
    fclose(fp);
}
void login(struct ATMaccount *acc, bool *isLogIn)
{
    char id[15], pin[5], str1[15], str2[5], trash[20], filenameInfo[50], filenameAcc[50];
    printf("------Log In------\n");
    printf("Enter your ID:");
    scanf("%14s", id);
    strcpy(filenameInfo, id);
    strcat(filenameInfo, "ATMinfo.txt");
    fflush(stdin);
    printf("Enter your PIN:");
    scanf("%4s", pin);
    fflush(stdin);
    FILE *fp;
    if((fp = fopen(filenameInfo, "r")) != NULL)
    {
        fscanf(fp, "%[^\n]", str1);
        fgets(trash, 255, fp);
        fscanf(fp, "%[^\n]", str2);
        fgets(trash, 255, fp);
        fclose(fp);
    }
    else
    {
        printf("Login Failed");
        return;
    }
    if(strcmp(id, str1) == 0 && strcmp(pin, str2) == 0)
    {
        printf("Log in successfully!\n");
        *isLogIn = true;
        strcpy(filenameAcc, id);
        strcat(filenameAcc, "UserAccount.txt");
        readInfo(acc, filenameAcc);
    }
    else printf("Log in failed!\n");
}
void readInfo(struct ATMaccount *acc, char *filename)
{
    FILE *fp;
    char trash[10];
    strcpy((*acc).filename, filename);
    fp = fopen(filename, "r");
    fgets((*acc).id, 255, fp);
    fgets((*acc).name, 255, fp);
    fscanf(fp, "%lf", &(*acc).balance);
    fgets(trash, 255, fp);
    fgets((*acc).moneyType, 5, fp);
    fclose(fp);
}
void writeFile(struct ATMaccount *acc)
{
    FILE *fp;
    fp = fopen((*acc).filename, "w");
    fputs((*acc).id, fp);
    fprintf(fp,"\n");
    fputs((*acc).name, fp);
    fprintf(fp,"\n");
    fprintf(fp, "%lf\n", (*acc).balance);
    fputs((*acc).moneyType, fp);
    fprintf(fp,"\n");
    fclose(fp);
}
void withdraw(struct ATMaccount *acc, bool *isLogIn)
{
    if(*isLogIn)
    {
        double money;
        printf("------Withdraw------\n");
        printf("Enter money you want to withdraw:");
        scanf("%lf", &money);
        if(((*acc).balance - money) >= 0)
        {
            (*acc).balance -= money;
            writeFile(acc);
            printf("Withdraw successfully!\n");
        }
        else printf("Amount of money is too big for your account!\n");
    }
    else printf("Please log in before making transactions\n");
}
void transfer(struct ATMaccount *acc1, struct ATMaccount *acc2, bool *isLogIn)
{
    if(*isLogIn)
    {
        char filename[50], id[15];
        FILE *fp;
        double money;
        printf("------Transfer------\n");
        printf("Enter ID of destination account:");
        scanf("%14s", id);
        strcpy(filename, id);
        strcat(filename, "UserAccount.txt");
        readInfo(acc2, filename);
        printf("%s", (*acc2).moneyType);
        if(strcmp((*acc1).moneyType, (*acc2).moneyType) == 0)
        {
            printf("Enter money you want to transfer:");
            scanf("%lf", &money);
            (*acc1).balance -= money;
            (*acc2).balance += money;
            writeFile(acc1);
            writeFile(acc2);
            printf("Transfer successfully!\n");
        }
        else
        {
            printf("System cannot transfer money if money type is different.\n");
            printf("This feature will be updated soon!");
        }
    }
    else printf("Please log in before making transactions\n");
}

