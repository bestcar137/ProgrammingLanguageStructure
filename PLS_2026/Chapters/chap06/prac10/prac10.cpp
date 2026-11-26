//
// Created by MinGyu on 26. 11. 26..
//

#include <iostream>
using namespace std;

int main() {
    enum DAY { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };
    int today;
    cout << "오늘은 무슨 요일입니까? \n";
    cout << "(일 0, 월 1, 화 2, 수 3, 목 4, 금 5, 토 6)\n";
    cout << "숫자를 누르세요: ";
    cin >> today;
    switch (today) {
        case SUNDAY: cout << "오늘은 일요일입니다!\n";
            break;
        case MONDAY: cout << "오늘은 월요일입니다!\n";
            break;
        case TUESDAY: cout << "오늘은 화요일입니다!\n";
            break;
        case WEDNESDAY: cout << "오늘은 수요일입니다!\n";
            break;
        case THURSDAY: cout << "오늘은 목요일입니다!\n";
            break;
        case FRIDAY: cout << "오늘은 금요일입니다!\n";
            break;
        case SATURDAY: cout << "오늘은 토요일입니다!\n";
            break;
        default: cout << "숫자 0에서 6까지를 누르시오\n";
    }
}
