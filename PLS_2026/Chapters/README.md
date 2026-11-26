# 장별 실습 안내

각 장의 README에서 소스 목록, 실습 내용, 입력 형식, 타깃 이름과 실행 방법을 확인할 수 있다.

| 장                      | 주요 내용                                                  | 구성                                             |
|-------------------------|------------------------------------------------------------|--------------------------------------------------|
| [2장](chap02/README.md) | 토큰화, AST 생성, 산술식 평가                              | `prob04.py`                                      |
| [3장](chap03/README.md) | S 언어 인터프리터와 선언·분기·반복                         | Python 파일 4개                                  |
| [4장](chap04/README.md) | 변수, 타입, 유효 범위, 상수, 인수 전달                     | C, C++, Python, Pascal, Java 예제                |
| [5장](chap05/README.md) | 연산자, 평가 순서, 반복문과 분기문                         | `prac01`~`prac10`                                |
| [6장](chap06/README.md) | 자료형과 내부 표현, 문자열, 열거형, 구조체, 포인터, 공용체 | `prac01`~`prac03`, `prac06`~`prac16`에 소스 23개 |
| [7장](chap07/README.md) | 정수와 문자(열)의 혼합 연산, 실수 변환과 비트 재해석       | `prac01`~`prac03`에 C/C++·Python 소스 6개        |

2~3장은 소스를 장 폴더에 직접 둔다. 4~7장은 실습 번호별 하위 폴더를 사용하며, 4장의 `prac_p23`, `prac_p33` 등은 강의 슬라이드 번호를 따른다. Java 소스는 해당 실습의 `src`에
둔다.

## 2026-11-26 변경 내용

### 5장 실습 7

[prac7.cpp](chap05/prac07/prac7.cpp)와 [prac7_1.cpp](chap05/prac07/prac7_1.cpp)는 `int main()`을 사용한다. 현재 조건식은 `x % 5 == 0`
이다. `break` 예제는 `1 2 3 4`에서 멈추고, `continue` 예제는 `5`와 `10`을 건너뛴다. `PLS_2026_Chapters_chap05_prac07_prac7`은 `prac7.cpp`만
빌드한다. 6장 [prac06.c](chap06/prac06/prac06.c)는 별도 타깃으로 빌드해 실행 파일마다 `main()`이 하나씩 들어간다.

### 6장 자료형과 내부 표현

- 실습 1~3은 하위 16비트, 정수 승격과 `short` 변환, 부호 없는 정수를 다룬다. 실습 2의 `int:` 출력 표기를 정리했다.
- 실습 6~8은 0.1의 누적 오차, C의 문자와 문자열 표현, C++의 이름 다섯 줄과 문자열 비교를 다룬다.
- 실습 9는 C++·Java·Python의 문자열 연산을 비교한다. Java의 [StringTest.java](chap06/prac09/src/StringTest.java)는 괄호에 따른 문자열 결합과 덧셈 결과를
  보여 준다.
- 실습 10~12는 요일 열거형, 구조체 초기화·동적 할당, 정수 다섯 개의 합계와 평균을 다룬다. 현재 실습 12의
  예제는 [C++](chap06/prac12/prac12.cpp), [Java](chap06/prac12/src/prac12.java), [Python](chap06/prac12/prac12.py)이다. C++과
  Java는 공백 또는 줄바꿈으로 입력을 구분하고, Python은 `int(input())`을 사용해 한 줄에 정수 하나를 읽는다. `1 2 3 4 7`을 입력하면 합계는 17이고 평균은 C++에서 3, Java와
  Python에서 3.4다.
- 실습 12의 배열 주소 계산과 연속 저장은 [제출용 C 예제 두 개와 학습용 C 예제](chap06/README.md#13주-실습-자료와-파일-대응)로 나누었다. 레코드 타입은 실습 11의 구조체 예제에서 확인한다.
- 실습 13~15는 포인터 별칭, 메모리 해제 후 참조, 구조체와 공용체의 크기를 비교한다.
- 실습 16은 [C 예제](chap06/prac16/prac16.c)로 정수나 실수 입력을 `float`로 읽고 IEEE 754 비트 패턴을 출력한다. `1.0`은 `0x3F800000`, `64`는
  `0x42800000`을 출력한다. 입력 전에 `fflush(stdout)`을 호출하며 `q`로 종료할 수 있다.

### 7장 타입 시스템

세 실습의 코드와 주석을 강의 자료에 맞췄다. 실습 1은 문자와 정수 혼합 연산 및 `ord()`·`chr()`, 실습 2는 C의 소수부 손실과 Python의 대입 후 타입 유지 및 `str()`, 실습 3은 C의
포인터 캐스트와 Python의 `struct`를 이용한 비트 재해석을 비교한다. Python의 `TypeError` 예시는 자료 표시대로 주석 처리했다. 실습 3에서 확인한 `0.1`의 단정밀도 비트 패턴은
`0x3DCCCCCD`이고, 정수로 변환한 값은 `0`이다. C의 포인터 재해석에는 C 표준에서 정의되지 않는 동작이 포함된다.

## 빌드와 실행 구성

- [루트 CMakeLists.txt](../../CMakeLists.txt)의 4~7장 등록은 `add_exercise()`로 통일했다. 기존 이름과 소스 경로는 유지했다. 5장의
  `PLS_2026_Chapters_chap05_prac7`과 `PLS_2026_Chapters_chap05_prac7_1`은 기본 빌드에서 제외되며 개별 지정으로 빌드할 수 있다. 6장 실습 12의 C++ 타깃
  이름은 `PLS_2026_Chapters_chap06_prac12_prac16`이다.
- IntelliJ의 Java 실행 구성에서 `prac09`의 클래스 경로는 해당 소스가 들어 있는 `ProgrammingLanguageStructure` 모듈을 사용한다. `chap06/prac09/src`와 `chap06/prac12/src`는 Java 소스 루트로 등록되어 있다. 터미널에서 JDK로 소스를 직접 실행하는
  명령은 [6장 README](chap06/README.md)에 있다.
- CMake 실행 파일을 찾지 못하는 경우 IntelliJ 도구 체인의 CMake 경로를 확인한다. Java 파일의 `ClassNotFoundException`은 소스 루트와 실행 구성의 클래스 경로를 확인한다.
  Python의 모듈 SDK 오류는 [2026년 공통 실행 환경](../README.md#공통-실행-환경)을 참고한다.

## 검증 기록

Windows에서 CMake 4.3.1, Ninja 1.13.2, MinGW GCC/G++ 15.2.0으로 기본 빌드 제외 2개를 포함한 C/C++ 타깃 45개를 Debug로 빌드했다. 5장 실습 7의 두 동작,
6장 C/C++ 16개와 7장 C/C++ 3개를 실행했다. 6장 실습 13과 14는 컴파일과 링크를 확인했다. Java 예제 3개는 OpenJDK 25, Python 예제 5개는 Python 3.13.5에서
실행했다. Java와 Python의 실행 검증은 명령줄 기준이다.

[2026년 파일 구성](../README.md) · [저장소 README](../../README.md)
