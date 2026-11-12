//
// Created by bestc on 26. 11. 12..
//

/// 3. 수치 자료의 내부 표현
#include <stdio.h>
#define BIT 16

int main() {
    int n;
    printf("임의의 수를 입력하세요: ");
    fflush(stdout);
    scanf("%d", &n); // VS -> scanf_s(%d, &n);
    printf("정수 %2d의 %d 비트 표현: \n", n, BIT);

    for (int i = BIT - 1; i >= 0; i--)
        printf("%2d", n >> i & 1); // >> : shift 연산, & : BIT AND 연산
    printf("\n");
}
