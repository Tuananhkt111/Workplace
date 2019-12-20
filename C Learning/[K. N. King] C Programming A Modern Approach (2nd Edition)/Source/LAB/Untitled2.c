#include "stdio.h"
#include "conio.h"

struct Date
{
 int d;
 int m;
 int y;
} ;

struct Date m_date[2] = {{16, 9, 1989}, {12, 23, 1999}};

void main()
{
    FILE *fp = NULL;
    int n_byte;
    struct Date date[2];
    //openning file to writting
    fp = fopen("D:\\data.dat","w");
    if(fp == NULL)
        printf("\nError in openning file");
    else
    {
        //ghi struct date xuong file data.dat
        for(int i= 0; i < 2; i++)
        {
            if(fwrite(&m_date[i], sizeof(struct Date), 1, fp) != 1)
        printf("Error in writting");
        }
        fclose(fp);
    }

    //openning file to read
    fp = fopen("D:\\data.dat","r");

    if(fp == NULL)
        printf("\nError in openning file");
    else
    {
        for(int i = 0; i < 2; i++)
        {
            if(fread(&date[i], sizeof(struct Date), 1, fp) != 1)
        printf("\nError in reading ");
        else printf("\ndd/mm/yyyy = %.2d/%.2d/%.4d\n", date[i].d, date[i].m, date[i].y);
        }
        fclose(fp);
    }
    getch();
}
