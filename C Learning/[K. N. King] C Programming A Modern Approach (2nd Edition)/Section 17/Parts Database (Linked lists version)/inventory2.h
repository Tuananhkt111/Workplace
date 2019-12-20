#ifndef INVENTORY_H
#define INVENTORY_H
#define NAME_LEN 25
struct part
{
    int number;
    char name[NAME_LEN+1];
    int on_hand;
    float price;
    struct part *next;
} *inventory;
#endif // INVENTORY_H
