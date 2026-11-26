COUNT = 5
scores = []  # 정수를 저장할 빈 리스트 생성
sum = 0  # 합계를 초기화

print(COUNT, "개의 정수를 입력하세요 : ")

for i in range(COUNT):
    value = int(input())
    scores.append(value)
    sum += value

avg = sum / len(scores)

print(scores)
print("sum = ", sum, ", avg = ", avg)