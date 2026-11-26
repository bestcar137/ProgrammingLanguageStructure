//
// Created by MinGyu on 26. 11. 26..
//

/// 13. 별칭(포인터 변수)

#include<stdio.h>

void main() {
    int i = 3, *p;
    p = &i;
    printf("i = %d,\t &i = %u\n", i, &i);
    printf("*p = %d,\t p = %u\n", *p, p);

    *p = 10;

    printf("i = %d,\t *p = %d\n", i, *p);
}
