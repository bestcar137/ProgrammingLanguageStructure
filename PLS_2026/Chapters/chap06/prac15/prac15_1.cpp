//
// Created by MinGyu on 26. 11. 26..
//

/// 15. 구조체와 공용체(공용체)

#include<iostream>
using namespace std;

int main() {
    typedef union {
        int num;
        char name[10];
        double grade;
    } stu;

    cout << "공용체 stu 크기: " << sizeof(stu) << endl;
}
