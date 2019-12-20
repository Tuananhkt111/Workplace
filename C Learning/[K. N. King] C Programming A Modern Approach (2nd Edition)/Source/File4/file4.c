/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 4
*/
#include<stdio.h>
void fileToArray(char *fname, int *a, int *pn);
void asc_sort(int *a, int n);
void print(int *a, int n);
void printToFile(char* fname, int *a, int n);
int main()
{
    char infName[] = "Array1.txt";
    char outfName[] = "Array2.txt";
    int a[200];
    int n = 0;
    fileToArray(infName, a, &n);
    asc_sort(a, n);
    print(a, n);
    printToFile(outfName, a, n);
    getchar();
    return 0;
}
void fileToArray(char *fname, int *a, int *pn)
{
    FILE* f = fopen(fname, "r");
    fscanf(f, "%d", pn);
    for(int i = 0; i < *pn; i++) fscanf(f, "%d", &a[i]);
    fclose(f);
}
void asc_sort(int *a, int n)
{
    int temp;
    for(int i = 0; i < n - 1; i++)
        for(int j = n - 1; j > i; j--)
            if(a[j] < a[j - 1])
            {
                temp = a[j];
                a[j] = a[j -1];
                a[j - 1] = temp;
            }
}
void print(int *a, int n)
{
    for(int i = 0; i < n; i++) printf("%d ", a[i]);
}
void printToFile(char* fname, int *a, int n)
{
    FILE *f = fopen(fname, "w");
    fprintf(f, "%d ", n);
    for(int i = 0; i < n; i++)
        fprintf(f, "%d ", a[i]);
    fclose(f);
}

