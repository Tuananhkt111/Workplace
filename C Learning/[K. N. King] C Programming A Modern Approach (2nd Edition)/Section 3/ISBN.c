//ISBN
#include <stdio.h>
int main(void)
{
    int gsi_prefit, group_identifier, publisher_code, item_number, check_digit;
    printf("Enter ISBN: ");
    scanf("%d-%d-%d-%d-%d", &gsi_prefit, &group_identifier, &publisher_code, &item_number, &check_digit);
    printf("GSI prefit: %d\n",gsi_prefit);
    printf("Group identifier: %d\n",group_identifier);
    printf("Publisher code: %d\n",publisher_code);
    printf("Item number: %d\n",item_number);
    printf("Check digit: %d\n",check_digit);
    return 0;
}
