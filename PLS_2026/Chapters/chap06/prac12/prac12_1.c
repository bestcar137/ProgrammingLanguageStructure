//
// Created by MinGyu on 26. 11. 26..
//

/**
 * @brief 2차원 배열의 원소에 대한 메모리 주소 출력
 *
 * @warning %u는 unsigned int형 데이터를 출력하기 위한 서식 지정자이므로
 *          포인터를 직접 전달하면 정의되지 않은 동작(Undefined Behavior)이 발생한다.
 *
 * @note 포인터의 주소를 출력할 때는 %p 서식 지정자를 사용하고,
 *       전달할 포인터를 void * 자료형으로 명시적으로 형 변환하는 것이 올바르다.
 *
 * @code
 * 정석적인 코드 형식
 * int main() {
 *     short A[4][5];
 *
 *     printf("&A[0][0] = %p\n", (void *) &A[0][0]);
 *     printf("&A[3][2] = %p\n", (void *) &A[3][2]);
 *
 *     return 0;
 * }
 * @endcode
 */

#include <stdio.h>

int main() {
    short A[4][5];

    printf("&A[0][0] = %u\n", &A[0][0]);

    printf("&A[3][2] = %u\n", &A[3][2]);
}
