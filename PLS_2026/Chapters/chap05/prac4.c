//
// Created by bestc on 26. 10. 29..
//

#include <stdio.h>
int x = 10;

int func(void) {
    x = 20;
    return 30;
}

int main() {
    printf("x + func() = %d\n", x + func());
    printf("func() + x = %d\n", func() + x);
    return 0;
}
