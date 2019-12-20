#ifndef READLINE_H
#define READLINE_H
//readline: skips the white-space characters, then reads the remainder of the input line and stores it in str.
//Truncates the line if its length exceeds n. Returns the remainder of characters stored.
int read_line(char str[], int n);
#endif // READLINE_H
