//
// Created by bestc on 26. 11. 5..
//

// while문으로 변경

#include <stdio.h>

int main(void) {
    printf("2026-11-05, 24117000, 차민규\n");
    int i = 2;
    int sum = 0;

    while (i <= 10) {
        sum += i;
        i += 2;
    }

    printf("%d\n", sum);
    return 0;
}
