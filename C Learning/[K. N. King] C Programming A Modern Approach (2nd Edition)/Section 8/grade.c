//grade of students
#include <stdio.h>
int main (void)
{
    int i, j, student[5][5], total_score[5] = {0}, average_score[5] = {0},
        average_score_quiz[5] = {0}, high_score_quiz[5] = {0}, low_score_quiz[5] = {0};
    for (i = 0; i < 5; i++)
    {
        printf("Enter grade of student %d: ", i + 1);
        for (j = 0; j < 5; j++)
            scanf("%d", &student[i][j]);
    }
    for (i = 0; i < 5; i++)
        {
            for (j = 0; j < 5; j++)
            total_score[i] += student[i][j];
            average_score[i] = total_score[i]/5;
        }
    for (j = 0; j < 5; j++)
        {
            for (i = 0; i < 5; i++)
            average_score_quiz[j] += student[i][j];
            average_score_quiz[j] /= 5;
        }
    for (j = 0; j < 5; j++)
        {
            low_score_quiz[j] = high_score_quiz[j] = student[0][j];
            for (i = 1; i < 5; i++)
            {
                if (student[i][j] >= high_score_quiz[j])
                    high_score_quiz[j] = student[i][j];
                if (student[i][j] <= low_score_quiz[j])
                    low_score_quiz[j] = student[i][j];
            }
        }
    printf("Total score each student: ");
    for (i = 0; i < 5; i++)
        printf("%d ", total_score[i]);
    printf("\nAverage score each student: ");
    for (i = 0; i < 5; i++)
        printf("%d ", average_score[i]);
    printf("\nAverage score each quiz: ");
    for (j = 0; j < 5; j++)
        printf("%d ", average_score_quiz[j]);

    printf("\nHighest score each quiz: ");
    for (j = 0; j < 5; j++)
        printf("%d ", high_score_quiz[j]);
    printf("\nLowest score each quiz: ");
    for (j = 0; j < 5; j++)
        printf("%d ", low_score_quiz[j]);
    return 0;
}
