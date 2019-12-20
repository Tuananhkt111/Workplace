/*
  Ho ten: Hoang Tuan Anh
  MSSV: SE130553
  Program 1
*/
#include<stdio.h>
#include<stdbool.h>
#include<ctype.h>
bool exist (char* filename);
bool writeFile(char *filename);
int main(int argc, char* args[])
{
    if(argc != 2) printf("Syntax: copy_con filename\n");
    else if(writeFile(args[1]) == true)
        printf("Writing the file %s: done\n", args[1]);
    else printf("Can not write the file %s\n", args[1]);
}
//Check whether the file existed or not
bool exist (char* filename)
{
    int existed = false;
    //Try opening it for reading
    FILE* f = fopen(filename, "r");
    if(f != NULL)
    {
        existed = true;
        fclose(f);
    }
    return existed;
}
//Write a file from character inputted until Ctrl+Z is pressed
bool writeFile(char *filename)
{
    char c;//inputted character
    if(exist(filename) == true)
    {
        printf("The file %s existed, Override it? (Y/N):", filename);
        if(toupper(getchar()) == 'N') return false;
    }
    //open the file for writing
    FILE* f = fopen(filename, "w");
    fflush(stdin); //clear input buffer
    do
    {
        c = getchar();
        if(c != EOF) fputc(c,f); //write it to file
    } while(c != EOF);
    fclose(f);
    return true;
}
