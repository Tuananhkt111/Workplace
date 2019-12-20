// Compute the volume of the sphere with 10-meter radius
#include <stdio.h>
int main(void)
{
    int r = 10;
    float v;
    v=(4.0f/3.0f)*3.14*(r*r*r);
    printf("Volume of the sphere: %.2f",v);
    return 0;
}
