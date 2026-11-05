//
// Created by bestc on 26. 11. 5..
//

// if문으로 변경

#include <stdio.h>

int main(void) {
    printf("2026-11-05, 24117000, 차민규\n");

    int score = 75;

    if (score < 60)
        goto FAIL;
    printf("합격\n");
    goto END;

FAIL:
    printf("불합격\n");

END:
    return 0;
}
