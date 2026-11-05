//
// Created by bestc on 26. 11. 5..
//

// switch-case문 (1) - C 언어

#include <stdio.h>

int main() {
    int score = 0;
    char grade;

    printf("2026-11-05, 24117000, 차민규\n");
    printf("점수를 입력하세요: ");
    scanf("%d", &score);

    switch (score >= 90 ? 9 : score / 10) {
        case 9:
            grade = 'A';
            break;
        case 8:
            grade = 'B';
            break;
        case 7:
            grade = 'C';
            break;
        case 6:
            grade = 'D';
            break;
        default:
            grade = 'F';
            break;
    }

    printf("프로그래밍언어구조론 점수 : %d, 학점 : %c\n", score, grade);
    return 0;
}
