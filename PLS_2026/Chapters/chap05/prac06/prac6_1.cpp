//
// Created by bestc on 26. 11. 5..
//

#include <iostream>
using namespace std;

int main() {
    cout << "2026-11-05, 24117000, 차민규" << endl;

    int n, sum = 0;

    for (n = 1; sum <= 100; n++) {
        sum += n;
    }
    cout << "sum = " << sum << endl;
    cout << "n = " << n << endl;
}
