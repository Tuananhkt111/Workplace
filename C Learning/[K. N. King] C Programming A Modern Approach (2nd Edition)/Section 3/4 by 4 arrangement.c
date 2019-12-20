//4 by 4 arrangement
#include <stdio.h>
int main(void)
{
    int x[16], row[4], column[4], diagonal[2];
    printf("Enter the number from 1 to 16 in any order: ");
    scanf("%d %d %d %d %d %d %d %d %d %d %d %d %d %d %d %d",
          &x[0],&x[1],&x[2],&x[3],&x[4],&x[5],&x[6],&x[7],
          &x[8],&x[9],&x[10],&x[11],&x[12],&x[13],&x[14],&x[15]);
    printf("%d\t%d\t%d\t%d\t\n%d\t%d\t%d\t%d\t\n%d\t%d\t%d\t%d\t\n%d\t%d\t%d\t%d\t\n",
          x[0],x[1],x[2],x[3],x[4],x[5],x[6],x[7],
          x[8],x[9],x[10],x[11],x[12],x[13],x[14],x[15]);
   row[0] = x[0] + x[1] + x[2] + x[3];
   row[1] = x[4] + x[5] + x[6] + x[7];
   row[2] = x[8] + x[9] + x[10] + x[11];
   row[3] = x[12] + x[13] + x[14] + x[15];
   column[0] = x[0] + x[4] + x[8] + x[12];
   column[1] = x[1] + x[5] + x[9] + x[13];
   column[2] = x[2] + x[6] + x[10] + x[14];
   column[3] = x[3] + x[7] + x[11] + x[15];
   diagonal[0] = x[0] + x[5] + x[10] + x[15];
   diagonal[1] = x[12] + x[9] + x[6] + x[3];
   printf("Row sums: %d %d %d %d\n",row[0],row[1],row[2],row[3]);
   printf("Column sums: %d %d %d %d\n",column[0],column[1],column[2],column[3]);
   printf("Diagonal sums: %d %d %d %d\n",diagonal[0],diagonal[1]);
   return 0;
}
