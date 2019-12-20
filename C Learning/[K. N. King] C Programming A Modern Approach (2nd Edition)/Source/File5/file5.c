/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 5
*/
#include<stdio.h>
void processFile(char *fname, int *pCount, double *pSum);
int main()
{
    char infName[] = "array3.txt";
    int count = 0;
    double sum = 0;
    processFile(infName, &count, &sum);
    printf("Number of values in the file: %d\n", count);
    printf("Average of values in the file: %lf\n", sum/count);
    getchar();
    return 0;
}
void processFile(char *fname, int *pCount, double *pSum)
{
    FILE* f = fopen(fname, "r");
    *pCount = 0;
    *pSum = 0;
    double x;
    while(fscanf(f, "%lf", &x) == 1)
    {
        (*pSum) += x;
        (*pCount)++;
    }
    fclose(f);
}
