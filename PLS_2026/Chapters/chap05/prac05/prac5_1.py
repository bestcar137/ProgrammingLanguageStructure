print("2026-11-05, 24117000, 차민규")
print("=== 파이썬 단락 회로 평가 예제 ===")

# 1. 논리 AND (and) 단락 회로
a, b = -1, 5

print(f"a = {a}, b = {b}")

if a > 0 and (b := b + 1) > 0:
    # print("AND 조건 만족 -> 양쪽 평가")
    print("참")

else:
    # print("AND 조건 만족하지 않음 -> 앞 부분만 평가")
    print("거짓")

print(f"AND 연산 후 : a = {a}, b = {b}\n")

# 2. 논리 OR (or) 단락 회로
x, y = -1, 5

print(f"x = {x}, y = {y}")

if x > 0 or (y := y + 1) > 0:
    # print("OR 조건 만족 -> 앞 부분만 평가")
    print("참")
else:
    # print("OR 조건 만족하지 않음 -> 양쪽 평가")
    print("거짓")

print(f"OR 연산 후 : x = {x}, y = {y}")
