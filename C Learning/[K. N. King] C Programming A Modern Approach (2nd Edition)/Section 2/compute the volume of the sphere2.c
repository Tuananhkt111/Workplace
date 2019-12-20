// Compute the volume of the sphere with the radius comes from input
#include <stdio.h>
int main(void)
{
    int r;
    float v;
    printf("Enter radius (meter): ");
    scanf("%d",&r);
    v=(4.0f/3.0f)*3,14*(r*r*r);
    printf("Volume of the sphere: %.2f",v);
    return 0;
}
