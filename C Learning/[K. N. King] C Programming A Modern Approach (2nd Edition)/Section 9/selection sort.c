//Sorts an array using Selection sort
#include <stdio.h>
int largest (int n, int a[*]);
void selection_sort(int n, int a[*]);
int main (void)
{
    int i, n;
    printf("Enter numbers of integers: ");
    scanf("%d", &n);
    int a[n];
    printf("Enter integers: ");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);
    selection_sort(n, a);
    printf("In sorted order: ");
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);
    return 0;
}
int largest (int n, int a[])
{
    int i, max = 0, position;
    for (i = 0; i < n; i++)
        if (a[i] >= max)
        {
            max = a[i];
            position = i;
        }
    return position;
}
void selection_sort(int n, int a[])
{
    if (n == 0) return;
    int max = a[largest(n, a)];
    a[largest(n, a)] = a[n - 1];
    a[n - 1] = max;
    selection_sort(n - 1, a);
}
