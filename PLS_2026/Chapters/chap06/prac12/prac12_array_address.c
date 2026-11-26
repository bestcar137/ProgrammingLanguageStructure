//
// Created by MinGyu on 26. 11. 26..
//

/// 13주 실습 2페이지 최종 코드. (2차원 배열의 주소 계산과 연속 저장)
#include <stdio.h>

int main(void) {
    enum { ROWS = 4, COLS = 5 };
    short A[ROWS][COLS];
    short value = 1;

    // C의 2차원 배열은 행 우선으로 저장된다. 한 행의 원소 5개 다음에 다음 행이 온다.
    // A[i][j] 앞에는 i개의 행과 j개의 원소가 있으므로 바이트 오프셋은
    // (i * COLS + j) * sizeof(A[0][0])이다.
    //
    // 자료의 가정처럼 시작 주소가 9840이고 short가 2바이트라면,
    // 행 우선에서 A[3][2]는 9840 + (3 * 5 + 2) * 2 = 9874번지다.
    // 열 우선으로 저장한다고 가정하면 9840 + (2 * 4 + 3) * 2 = 9862번지다.
    const size_t element_size = sizeof(A[0][0]);
    const size_t offset = (3 * COLS + 2) * element_size;
    unsigned char *base = (unsigned char *) &A; // 배열 전체의 시작 주소를 바이트 단위로 사용

    // 실제 주소는 실행 환경에 따라 달라진다. 포인터는 %p로 출력한다.
    printf("&A[0][0] = %p\n", (void *) &A[0][0]);
    printf("&A[3][2] = %p\n", (void *) &A[3][2]);
    printf("계산한 주소 = %p (시작 주소에서 %zu바이트 뒤)\n\n",
           (void *) (base + offset), offset);

    // 행을 바깥쪽, 열을 안쪽에서 순회하며 1부터 20까지 채운다.
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            A[i][j] = value++;
        }
    }

    // A[0][4]와 A[1][0] 사이도 원소 한 개 크기만큼 떨어져 있다.
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            printf("A[%d][%d] = %2hd\t&A[%d][%d] = %p\n",
                   i, j, A[i][j], i, j, (void *) &A[i][j]);
        }
    }

    return 0;
}
