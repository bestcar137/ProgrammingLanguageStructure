#
# Created by MinGyu on 26. 11. 26..
#

import struct

# [1] 포인터 강제 형변환 불가
# 전용 모듈(struct)로 바이트 패킹
# 파이썬에는 메모리 주소를 직접 조작하는 포인터 캐스팅 문법이 원천 차단

f = 0.1

# float(4바이트, 'f')을 바이트열로 포장(pack)한 뒤, 부호 없는 정수('I')로 다시 풀어(unpack)
raw_bits = struct.unpack('>I', struct.pack('>f', f))[0]
print(f"1. 메모리 비트 재해석 (struct 모듈): {raw_bits} -> 0x{raw_bits:08X}")

# [2] 일반 값 형변환 (Value Casting)
# 강한 타입 언어인 파이썬에서도 '값 자체의 의미'를 바꾸는 명시적인 변환은 허용됨

x = 0.1

# 소수점 이하를 버리고 새로운 정수 객체 0을 생성
x_int = int(x)
print(f"2. 일반 값 형변환 (int(x)): {x_int} -> 0x{x_int:08X}")
# 출력 결과?
