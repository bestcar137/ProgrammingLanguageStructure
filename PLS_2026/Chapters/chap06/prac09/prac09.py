f_name = "GIL DONG"
l_name = "HONG "

name = l_name + f_name # 문자열 연결
print(name)

print(len(name)) # 문자열 길이 반환
name += " Fighting!" # 문자열 뒤에 추가
print(name)

print(name[10]) # 특정 인덱스 문자 접근
print(name.find("L")) # 특정 문자(열)의 첫 번째 위치 검색

name = name[4:] # 인덱스[0~4]글자 삭제→슬라이싱
print(name)
