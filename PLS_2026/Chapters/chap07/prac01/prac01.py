#
# Created by MinGyu on 26. 11. 26..
#

ch = 'A'
num = 5

# sum_val = ch + num  # TypeError 발생(주석 처리)

sum_val = ord(ch) + num

next_ch = chr(ord(ch) + num)

print("정수 결과:", sum_val)
print("문자 결과:", next_ch)
