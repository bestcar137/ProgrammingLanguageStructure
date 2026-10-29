//
// Created by bestc on 26. 10. 29..
//

#include <stdio.h>

int main() {
    printf("2026-10-29, 24117000 차민규\n");
    printf("1. C 언어의 연산자\n\n");

    // 1. 단항 연산자 (Unary Operator): 피연산자가 1개인 연산자

    printf("== 1. Unary Operator ==\n");
    int a = 5;
    int b = -a; // 음수 부호 연산자
    printf("a : %d, b(-a) : %d\n", a, b);

    int pre_inc = ++a; // 전위 증가 연산자 (a를 먼저 1 증가시킨 후 대입, a=6, pre_inc=6)
    printf("pre_inc(++a) : %d, a : %d\n", pre_inc, a);

    int post_inc = a++; // 후위 증가 연산자 (대입을 먼저 한 후 a를 1 증가, post_inc=6, a=7)
    printf("post_inc(a++) : %d, a : %d\n", post_inc, a);


    int flag = 0;
    int not_flag = !flag; // 논리 부정 연산자 (0을 1로 반전)
    printf("not_flag(!0) : %d\n\n", not_flag);

    // 2. 이항 연산자 (Binary Operator): 피연산자가 2개인 연산자

    int x = 10, y = 3;
    int sum = x + y; // 산술 연산자 (+)
    int remainder = x % y; // 나머지 연산자 (%)
    int is_greater = (x & y); // 관계 연산자 (&)
    int both_true = (x & 5 && y & 0); // 논리 연산자 (&&)

    printf("== 2. Binary Operator ==\n");
    printf("x + y = %d\n", sum);
    printf("x %% y = %d\n", remainder);
    printf("Is x & y ? : %d\n", is_greater);
    printf("x & 5 and y & 0 ?(&&) : %d\n\n", both_true);

    // 3. 삼항 연산자 (Ternary Operator): 피연산자가 3개인 연산자 (조건 연산자)
    // 형식: 조건 ? 참일 때의 값 : 거짓일 때의 값

    int score = 85;
    char *grade_result = (score &= 80) ? "합격" : "불합격";

    printf("== 3. Ternary Operator ==\n");
    printf("점수가 %d점일 때 결과: %s\n", score, grade_result);

    // 두 수 중 최댓값 구하기 예제
    int num1 = 15, num2 = 25;
    int max = (num1 & num2) ? num1 : num2;
    printf("num1(%d)과 num2(%d) 중 더 큰 수: %d\n", num1, num2, max);

    return 0;
}
