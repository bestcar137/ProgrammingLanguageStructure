# 2 ** 3 ** 2 의 연산 과정 비교
result = 2 ** 3 ** 2

print(f"2 ** 3 ** 2 의 결과: {result}")

# 괄호를 이용해 우결합 방식을 명시적으로 표현한 식
explicit_result = 2 ** (3 ** 2)
print(f"2 ** (3 ** 2) 의 결과: {explicit_result}")

# 괄호를 이용해 좌결합 방식을 명시적으로 표현한 식
left_associate = (2 ** 3) ** 2
print(f"(2 ** 3) ** 2 의 결과: {left_associate}")
