//
// Created by bestc on 26. 11. 12..
//

/// 4. overflow & 형변환
#include <stdio.h>

int main() {
    int a = 32767;
    short x = 32767;

    printf("int \t a = %5d, a + 1 = %5d\n", a, a + 1); // short + int -> int 로 자동 형변환
    printf("short:\t x = %5d, x + 1 = %5d\n", x, (short) (x + 1)); // 오버플로우 발생, 강제적 형변환
}
