//
// Created by bestc on 26. 11. 5..
//

/*
 * 반복문 연습 (for문과 while문)
 * 1부터 n까지의 합이 100을 초과할 때 합과 n의 값
 */

// C, Java, Python 의 for 문, while 문으로 수정하기

#include <iostream>
using namespace std;

int main() {
    cout << "2026-11-05, 24117000, 차민규" << endl;

    int sum = 0, n = 1;

    while (sum <= 100) {
        sum += n;
        n++;
    }
    cout << "sum = " << sum << endl;
    cout << "n = " << n << endl;
}
