//closest departure and arrival times ver 2
#include <stdio.h>
int closest(int x, int y, int z);
int main(void)
{
    int x, y, z=0, c[8] = {480, 583, 679, 767, 840, 945, 1140, 1305}, i, j;
    printf("Enter a 24-hour time: ");
    scanf("%d:%d", &x, &y);
    z = closest(x, y, c[0]);
    for (i=0;i<8;++i)
        if (z >= closest(x, y, c[i]))
        {
            z = closest(x, y, c[i]);
            j = i;
        }
    printf("Closest departure time is ");
    switch (j)
    {
        case 0: printf("8:00 a.m., arriving at 10:16 a.m."); break;
        case 1: printf("9:43 a.m., arriving at 11:52 a.m."); break;
        case 2: printf("11:19 a.m., arriving at 1:31 p.m."); break;
        case 3: printf("12:47 p.m., arriving at 3:00 p.m."); break;
        case 4: printf("2:00 p.m., arriving at 4:08 p.m."); break;
        case 5: printf("3:45 p.m., arriving at 5:55 p.m."); break;
        case 6: printf("7:00 p.m., arriving at 9:20 p.m."); break;
        case 7: printf("9:45 p.m., arriving at 11:58 p.m."); break;
    }
}
int closest(int x, int y, int z)
{

    int k;
    k=x*60+y-z;
    if (k<0)
        k=-k;
    return k;
}
