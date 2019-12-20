#include<iostream>
int main() {
    int n1, n2;
    std::cout << "Enter two numbers:" << std::endl;
    std::cin >> n1 >> n2;
    while(n1 <= n2) {
        std::cout << n1 << " ";
        n1++;
    }
    return 0;
}
