//
// Created by MinGyu on 26. 11. 26..
//

/// 2차원 배열 연속된 기억장소 저장.
#include<stdio.h>

int main() {
    int i, j, k = 1;
    short A[4][5];

    printf("&A[0][0] = %u\n", &A[0][0]);
    printf("&A[3][2] = %u\n", &A[3][2]);

    for (i = 0; i < 4; i++) {
        for (j = 0; j < 5; j++) {
            A[i][j] = k++;
        }
    }

    for (i = 0; i < 4; i++) {
        for (j = 0; j < 5; j++) {
            printf("&A[%d][%d] = %d\t", i, j, A[i][j]);
            printf("&A[%d][%d] = %u\n", i, j, &A[i][j]);
        }
    }
}
