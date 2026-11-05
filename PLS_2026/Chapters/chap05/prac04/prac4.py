x = 10


def func():
    global x  # 이 문장이 있을 때와 없을 때의 차이 확인
    x = 20  # global 문장이 없으면 새로운 x 동적 타입 할당
    return 30


print("x + func() = ", (x + func()))

print("func() + x = ", (func() + x))
