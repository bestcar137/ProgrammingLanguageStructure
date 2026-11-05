//
// Created by bestc on 26. 11. 5..
//

// C 언어의 for 문

#include <stdio.h>

int main() {
    printf("2026-11-05, 24117000, 차민규\n");

    int n, sum = 0;

    for (n = 1; sum <= 100; n++) {
        sum += n;
    }
    printf("sum = %d\n", sum);
    printf("n = %d\n", n);
}