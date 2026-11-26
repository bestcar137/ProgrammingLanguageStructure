#
# Created by MinGyu on 26. 11. 26..
#

f_val = 3.141592

# 실수를 정수 변수에 넣는 개념이 아니라 이름표(참조)를 옮기는 것이므로 타입이 유지됨
x = f_val
print(type(x), x)  # 출력 결과?

# 명시적으로 변환하지 않으면 문자열 연결(+) 불가
# msg = "값: " + f_val  # TypeError 발생(주석 처리)
msg = "값: " + str(f_val)

print(type(msg), msg)  # 출력 결과?
