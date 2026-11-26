//
// Created by MinGyu on 26. 11. 26..
//
#include <iostream>
#define COUNT 5
using namespace std;

int main() {
    int score[COUNT], sum = 0;
    cout << COUNT << " 개의 정수 입력 >> ";

    for (int i = 0; i < COUNT; i++) {
        cin >> score[i];
        sum += score[i];
    }

    float avg = sum / COUNT;

    cout << "score : ";
    for (int i = 0; i < COUNT; i++)
        cout << score[i] << " ";

    cout << "\nsum = " << sum << ", avg = " << avg << endl;
}
