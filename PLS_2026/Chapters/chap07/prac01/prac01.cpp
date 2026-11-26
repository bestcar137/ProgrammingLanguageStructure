//
// Created by MinGyu on 26. 11. 26..
//

#include <iostream>
using namespace std;

int main(void) {
    char ch = 'A';
    int num = 5;

    int autoCast_int = ch + num;
    char autoCast_ch = ch + num;

    cout << "정수 결과: " << autoCast_int << endl;
    cout << "문자 결과: " << autoCast_ch << endl;

    return 0;
}
