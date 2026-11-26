//
// Created by MinGyu on 26. 11. 26..
//

/// 6. 실수 표현의 한계

#include <stdio.h>

int main() {
    float sum = 0.0;
    for (int i = 0; i <= 100000; i++)
        sum += 0.1;
    printf("실수 0.1을 십만번 더한 결과: %f\n", sum);
    float x = 0.1 * 100000;
    printf("실수 0.1을 십만번 곱한 결과: %f\n", x);
}
