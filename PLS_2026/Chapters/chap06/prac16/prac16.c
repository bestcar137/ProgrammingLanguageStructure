//
// Created by MinGyu on 26. 11. 26..
//

/// 실습 16. float 타입의 부동소수점 실수 -> IEEE754 표현 값 확인

#include <stdio.h>

void print_float_binary(float f) {
    // float의 실제 메모리 비트 패턴을 32비트 unsigned int로 읽어옴
    unsigned int *bits = (unsigned int *) &f;

    printf("\n입력 값(실제 저장된 값): %.9f\n", f);
    printf("16진수 표현: 0x%08X\n\n", *bits);

    printf("IEEE 754 32비트 표현:\n");
    printf("[부호] [  지수부  ] [         가수부         ]\n  ");

    // 최상위 비트(31번째)부터 0번째 비트까지 1비트씩 확인 및 출력
    for (int i = 31; i >= 0; i--) {
        int bit = (*bits >> i) & 1;
        printf("%d", bit);

        // 가독성을 위해 부호 비트(31), 지수부(30~23) 뒤에 공백 출력
        if (i == 31 || i == 23) {
            printf("   ");
        }
    }
    printf("\n------------------------------------------------\n");
}

int main(void) {
    float num;

    while (1) {
        printf("실수를 입력하세요(종료하려면 문자를 입력): ");
        fflush(stdout);

        // float 형식(%f)으로 입력을 받음
        if (scanf("%f", &num) != 1) {
            printf("프로그램을 종료합니다.\n");
            break;
        }

        print_float_binary(num);
    }

    return 0;
}
