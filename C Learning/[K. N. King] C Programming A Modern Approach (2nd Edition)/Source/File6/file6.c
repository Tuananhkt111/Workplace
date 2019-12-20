/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 6
*/
#include<stdio.h>
#include<string.h>
#define MAXN 50
struct students
{
    char names[21];
    char adds[41];
    int marks;
};
void readFile(char *fname, struct students s[], int *pn);
void sort(struct students s[], int n);
void print(struct students s[], int n);
void writeFile(char *fname, struct students s[], int n);
int main()
{
    char infName[] = "students.txt";
    char outfName[] = "students2.txt";
    int n = 0;
    struct students s[MAXN];
    readFile(infName, s, &n);
    sort(s, n);
    printf("Sorted list:\n");
    print(s, n);
    writeFile(outfName, s, n);
    printf("\nResult file: %s\n", outfName);
    getchar();
    return 0;
}
//read data in a file to struct
void readFile(char *fname, struct students s[], int *pn)
{
    FILE* f = fopen(fname, "r");
    if(f != NULL)
    {
        while(fscanf(f, "%20[^;]; %40[^;]; %d%*c", &s[*pn].names, &s[*pn].adds, &s[*pn].marks) == 3)
            (*pn)++;
        fclose(f);
    }
    else printf("Read File Error!\n");
}
//Sort the list based on marks descendingly
void sort(struct students s[], int n)
{
    for(int i = 0; i < n - 1; i++)
        for(int j = n - 1; j > i; j--)
            if(s[j].marks > s[j - 1].marks)
            {
                struct students temp;
                temp = s[j];
                s[j] = s[j - 1];
                s[j - 1] = temp;
            }
}
//Print out the list to the file
void print(struct students s[], int n)
{
    for(int i = 0; i < n; i++)
        printf("%-20s%-40s%4d\n", s[i].names, s[i].adds, s[i].marks);
}
//write to file
void writeFile(char *fname, struct students s[], int n)
{
    FILE* f = fopen(fname, "w");
    for(int i = 0; i < n; i++)
        fprintf(f, "%s; %s; %d\n", s[i].names, s[i].adds, s[i].marks);
    fclose(f);
}
