# 1. 단항 연산자 (피연산자 1개)
x = 10
neg_x = -x  # 음수 부호 단항 연산자
is_T = True
not_is_T = not is_T  # 논리 부정 단항 연산자

print("=== 1. 단항 연산자 ===")
print(f"x = {x}, -x = {neg_x}")
print(f"is_T = {is_T}, not is_T: {not_is_T}\n")

# 2. 이항 연산자 (피연산자 2개)
a, b = 10, 3  # 다중 할당
int_div = a // b  # 산술 이항 연산자 (//-정수나눗셈 몫)
is_greater = a > b  # 비교 이항 연산자 (>)

print("=== 2. 이항 연산자 ===")
print(f"{a} // {b} = {int_div}")
print(f"{a} 가 {b} 보다 큰가? {is_greater}\n")

# 3. 삼항 연산자 (피연산자 3개)
# 형식: 참일_때의_값 if 조건 else 거짓일_때의_값
print("=== 3. 삼항 연산자 ===")
score = int(input("점수를 입력하세요: "))

result = "합격" if score >= 80 else "불합격"
print(f"결과: {score}점 => {result}")
