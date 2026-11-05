# if문 (2) - Python
print("2026-11-05, 24117000, 차민규")

score = int(input("점수를 입력하세요: "))

if score >= 90:
    grade = 'A'
elif score >= 80:
    grade = 'B'
elif score >= 70:
    grade = 'C'
elif score >= 60:
    grade = 'D'
else:
    grade = 'F'

print(f"프로그래밍언어구조론 점수 : {score}, 학점 : {grade}")
