//
// Created by MinGyu on 26. 11. 26..
//

/// 15. 구조체와 공용체(구조체)

#include<iostream>
using namespace std;

int main() {
    typedef struct {
        int num;
        char name[10];
        double grade;
    } stu;

    cout<<"구조체 stu 크기: " <<sizeof(stu)<<endl;
}