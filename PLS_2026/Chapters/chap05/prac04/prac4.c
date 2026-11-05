//
// Created by bestc on 26. 10. 29..
//

#include <stdio.h>
int x = 10; // 전역 변수

int func(void) {
    x = 20;
    return 30;
}

int main() {
    int a = x;
    int b = func();
    printf("x + func() = %d\n", a + b);
    printf("func() + x = %d\n", b + x);
    return 0;
}
