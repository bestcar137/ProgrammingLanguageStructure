//
// Created by bestc on 26. 11. 5..
//

// C언어의 while문

#include <stdio.h>

int main() {
    printf("2026-11-05, 24117000, 차민규\n");

    int n = 0, sum = 0;

    while (sum <= 100) {
        sum += n;
        n++;
    }
    printf("sum = %d\n", sum);
    printf("n = %d\n", n);
}