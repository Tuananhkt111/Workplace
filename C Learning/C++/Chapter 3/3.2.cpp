#include<iostream>
using std::cin;
using std::endl;
using std::cout;
using std::string;
int main() {
    string s;
    while(getline(cin, s)) {
        cout << "Enter a line:" << endl;
        cout << "Line you entered:" << endl << s << endl;
    }
}
