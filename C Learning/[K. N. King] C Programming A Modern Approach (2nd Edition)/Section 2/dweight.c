// Compute the dimesion of 12"x10"x8" box
#include <stdio.h>
int main(void)
{
    int height = 8, length = 12, width = 10, volume;
    volume = height*length*width;
    printf("Dimensions: %dx%dx%d\n",height,length,width);
    printf("Volume (cubic inches): %d\n",volume);
    printf("Dimension weight: %d\n",(volume +165)/166);
    return 0;
}
