//
// Created by bestc on 26. 11. 5..
//

// while문으로 변경

#include <stdio.h>

int main(void) {
    printf("2026-11-05, 24117000, 차민규\n");
    int i = 2;
    int sum = 0;

LOOP:
    if (i > 10)
        goto END;
    sum += i;
    i += 2;
    goto LOOP;

END:
    printf("%d\n", sum);
    return 0;
}
