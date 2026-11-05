//
// Created by bestc on 26. 11. 5..
//

#include <iostream>
using namespace std;

void main() {
    cout << "2026-11-05, 24117000, 차민규" << endl;

    int x;
    for (x = 1; x < 11; x++) {
        if ((x % 5 == 0) == 0)
            continue;
        cout << x << " ";
    }
}
