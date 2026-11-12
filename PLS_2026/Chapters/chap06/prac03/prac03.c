//
// Created by bestc on 26. 11. 12..
//

/// 5. unsigned 키워드 사용
#include <stdio.h>

int main() {
    short num = -32768;
    unsigned short un_num = num;
    printf("(short)num : %d\n", num); // -32768 ~ 32767 표현 가능
    printf("(unsigned)num: %d\n", un_num); // 0 ~ 65535 표현 가능 ( 0 과 양수만 표현 )
}
