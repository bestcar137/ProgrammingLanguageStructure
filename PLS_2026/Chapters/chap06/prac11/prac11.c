//
// Created by MinGyu on 26. 11. 26..
//

/// 11. 구조체 선언 및 필드 접근

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define _CRT_SECURE_NO_WARNINGS

int main() {
    typedef struct {
        int num;
        char name[10];
        double grade;
    } student;

    student s1 = {1, "홍길동", 3.0};
    student s2;
    s2.num = 2;
    strcpy(s2.name, "김영웅");
    s2.grade = 3.5;

    student *s3;
    s3 = (student *) malloc(sizeof(student));

    s3->num = 3;
    strcpy(s3->name, "김철수");
    s3->grade = 4.5;

    printf("번호\t 이름\t 학점\n");
    printf("%3d\t %s\t %3.2f\n", s1.num, s1.name, s1.grade);
    printf("%3d\t %s\t %3.2f\n", s2.num, s2.name, s2.grade);
    printf("%3d\t %s\t %3.2f\n", s3->num, s3->name, s3->grade);

    free(s3);
}
