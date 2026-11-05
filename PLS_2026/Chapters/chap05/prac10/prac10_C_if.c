//
// Created by bestc on 26. 11. 5..
//

// if문 (1) - C 언어

#include <stdio.h>

int main() {
    int score = 0;
    char grade;

    printf("2026-11-05, 24117000, 차민규\n");
    printf("점수를 입력하세요: ");
    scanf("%d", &score);

    if (score >= 90) {
        grade = 'A';
    } else if (score >= 80) {
        grade = 'B';
    } else if (score >= 70) {
        grade = 'C';
    } else if (score >= 60) {
        grade = 'D';
    } else {
        grade = 'F';
    }

    printf("프로그래밍언어구조론 점수 : %d, 학점 : %c\n", score, grade);
    return 0;
}
