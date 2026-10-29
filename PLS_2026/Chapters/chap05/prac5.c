//
// Created by bestc on 26. 10. 29..
//

#include <stdio.h>

int main() {
    printf("=== C언어 단락 회로 평가 예제 ===\n");

    // 1. 논리 AND (&&) 단락 회로
    int a = 0, b = 5; // and의 단락 회로 적용값으로 변경
    if (a > 0 && ++b > 0) {
        printf("AND 조건 T -> 양쪽 평가\n");
    } else {
        printf("AND 조건 F -> 앞 부분만 평가\n");
    }

    printf("AND 연산 후 : a = %d, b = %d\n\n", a, b);

    // 2. 논리 OR (||) 단락 회로
    int x = 0, y = 5; // or의 단락 회로 적용 값으로 변경
    if (x >= 0 || ++y > 0) {
        printf("OR 조건 T -> 앞 부분만 평가\n");
    } else {
        printf("OR 조건 F -> 양쪽 평가\n");
    }

    printf("OR 연산 후 : x = %d, y = %d\n", x, y);
    return 0;
}
