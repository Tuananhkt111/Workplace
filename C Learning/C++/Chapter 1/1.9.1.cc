#include<iostream>
int main() {
    int sum, val = 50;
    while(val <= 100) {
        sum += val;
        val++;
    }
    std::cout << "Sum from 50 to 100: " << sum;
    return 0;
}
