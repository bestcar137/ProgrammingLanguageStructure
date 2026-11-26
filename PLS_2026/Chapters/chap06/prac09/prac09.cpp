//
// Created by MinGyu on 26. 11. 26..
//

/// 9. 문자열 연산(C++)

#include<iostream>
#include<string>
using namespace std;

int main() {
    //본인 이름으로 작성하기
    string f_name = "GIL DONG";
    string l_name = "HONG ";
    string name;

    name = l_name + f_name;
    cout << name << endl;

    cout << name.length() << endl;
    name.append(" Fighting!");
    cout << name << endl;
    cout << name.at(10) << endl;
    cout << name.find("L") << endl;
    name.erase(0, 4);
    cout << name << endl;
}
