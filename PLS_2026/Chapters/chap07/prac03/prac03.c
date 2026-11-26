//
// Created by MinGyu on 26. 11. 26..
//

#include <stdio.h>

int main(void) {
    // [1] 포인터 강제 형변환 (Type Punning)

    float f = 0.1f;
    unsigned int *raw_bits = (unsigned int *) &f;
    // &f로 변수 f의 주소만 가져와서 (unsigned int *) 형태로 형변환하여 해석
    // 메모리의 0과 1은 건드리지 않고, 읽어오는 '해석 방식(타입)'만 바꿈

    printf("1. 포인터 형변환 (비트 그대로 읽기): 0x%08X\n", *raw_bits);
    // 출력 결과?

    // [2] 일반 값 형변환 (Value Casting)
    float x = 0.1f;
    unsigned int x_bits = (unsigned int) x;
    // 실수 0.1을 unsigned int로 변환하기 위해 소수점 이하를 버리고 정수 0을 x_bits에 저장

    printf("2. 일반 값 형변환 (값 자체를 변환): 0x%08X\n", x_bits);
    // 출력 결과?
    // Python, Java 등 강한 타입 언어에도 허용되는 일반적인 타입 변환

    return 0;
}
