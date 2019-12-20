#include <stdio.h>
#include <stdlib.h>
int cc(int n, int k);
int main()
{
    int n, k, i;
    printf("Enter number of rebel(s):");
    scanf("%d", &n);
    int a[n];
    printf("Enter count number:");
    scanf("%d", &k);
    printf("Position of survivor:%d\n", survivor(n, k));
}
int survivor(int n,int k)
{
	if(n==1) return 1;
	return ((survivor(n-1,k)+k - 1)%n + 1);
}
