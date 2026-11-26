# 6장 실습 · 자료형과 내부 표현

정수와 부동소수점의 비트 표현에서 시작해 문자열, 열거형, 배열, 구조체, 포인터, 공용체를 다룬다. 실습 9와 12에서는 같은 작업을 C++, Java, Python으로 구현해 자료형과 연산의 차이를 비교한다.

## 실습 목록

CMake 대상 열에는 공통 접두사 `PLS_2026_Chapters_chap06_` 뒤에 붙는 이름을 적었다.

| 실습 | 소스                                                                                                                                | 내용                                                                                                                           | CMake 대상 접미사                  |
|------|-------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|------------------------------------|
| 01   | [C](prac01/prac01.c)                                                                                                                | 정수의 하위 16비트를 오른쪽 시프트와 비트 AND로 출력                                                                           | `prac01`                           |
| 02   | [C](prac02/prac02.c)                                                                                                                | 32767에 1을 더한 `int` 결과와 `short` 변환 결과 비교                                                                           | `prac02`                           |
| 03   | [C](prac03/prac03.c)                                                                                                                | `short`의 -32768을 `unsigned short`로 변환                                                                                     | `prac03`                           |
| 06   | [C](prac06/prac06.c)                                                                                                                | 0.1의 반복 덧셈과 곱셈 결과를 비교해 부동소수점 누적 오차 관찰                                                                 | `prac06_prac06`                    |
| 07   | [C](prac07/prac07.c)                                                                                                                | 문자, 문자 배열, 문자열 리터럴을 가리키는 포인터 선언                                                                          | `prac07_prac07`                    |
| 08   | [C++](prac08/prac08.cpp)                                                                                                            | 이름 다섯 줄을 읽고 `std::string` 비교에서 가장 큰 문자열 출력                                                                 | `prac08_prac08`                    |
| 09   | [C++](prac09/prac09.cpp), [Java](prac09/src/prac09.java), [Python](prac09/prac09.py), [Java StringTest](prac09/src/StringTest.java) | 연결, 길이, 인덱스 접근, 검색, 앞 네 문자 제거를 비교한다. `StringTest`는 괄호가 문자열 결합과 덧셈에 미치는 영향을 보여 준다. | `prac09_prac09`                    |
| 10   | [C++](prac10/prac10.cpp)                                                                                                            | 0(일요일)부터 6(토요일)까지의 정수를 열거형과 `switch`로 처리                                                                  | `prac10_prac10`                    |
| 11   | [C](prac11/prac11.c)                                                                                                                | 구조체의 초기화, 멤버 대입, 동적 할당과 포인터를 통한 멤버 접근                                                                | `prac11_prac11`                    |
| 12   | [C++](prac12/prac12.cpp), [Java](prac12/src/prac12.java), [Python](prac12/prac12.py)                                                | 정수 다섯 개를 저장하고 목록, 합계, 평균을 출력                                                                                | `prac12_prac16`                    |
| 12-1 | [C 제출용](prac12/prac12_1.c)                                                                                                       | `A[0][0]`과 `A[3][2]`의 주소를 출력                                                                                            | `prac12_prac12_1`                  |
| 12-2 | [C 제출용](prac12/prac12_2.c)                                                                                                       | 배열에 1~20을 채우고 각 원소의 값과 주소를 출력                                                                                | `prac12_prac12_2`                  |
| 12   | [C 학습용](prac12/prac12_array_address.c)                                                                                           | 행 우선 주소 계산과 실제 주소를 비교하고 연속 저장을 확인                                                                      | `prac12_array_address`             |
| 13   | [C](prac13/prac13.c)                                                                                                                | 포인터로 같은 정수를 읽고 수정하는 별칭 예제                                                                                   | `prac13_prac13`                    |
| 14   | [C](prac14/prac14.c)                                                                                                                | 동적 메모리 해제 후 포인터를 다시 쓰는 허상 참조 예제                                                                          | `prac14_prac14`                    |
| 15   | [C++ 구조체](prac15/prac15.cpp), [C++ 공용체](prac15/prac15_1.cpp)                                                                  | 같은 멤버를 가진 구조체와 공용체의 `sizeof` 결과 비교                                                                          | `prac15_prac15`, `prac15_prac15_1` |
| 16   | [C](prac16/prac16.c)                                                                                                                | 입력한 `float`의 16진수와 IEEE 754 단정밀도 부호·지수·가수 비트 출력                                                           | `prac16_prac16`                    |

## 13주 실습 자료와 파일 대응

- **1페이지 · 배열 선언의 예**는 실습 12의 C++·Java 배열 및 Python 리스트를 비교한다.
- **2페이지 · 배열의 주소 계산** 상단은 [prac12_1.c](prac12/prac12_1.c), 하단의 **2차원 배열 연속 저장**은 [prac12_2.c](prac12/prac12_2.c)에 해당한다.
  두 제출용 파일은 자료의 코드와 출력 형식을 따른다.
- **3페이지 · 레코드 타입 정의 및 선언**은 기존 [prac11.c](prac11/prac11.c)에 해당한다. `typedef struct`로 `student` 타입을 정의하고, 구조체 변수와 동적으로
  할당한 구조체의 멤버를 각각 `.`과 `->`로 접근한다.

[학습용 배열 예제](prac12/prac12_array_address.c)는 주소 출력에 `%p`와 `(void *)`를 사용한다. `short A[4][5]`에서 C의 행 우선 오프셋은
`(행 × 열 개수 + 열) × sizeof(short)`이다. `short`가 2바이트이고 기준 주소가 9840이라고 가정하면 `A[3][2]`는 34바이트 뒤인 9874번지다. 자료의 열 우선 가정에서는
`(2 × 4 + 3) × 2 = 22`바이트 뒤인 9862번지가 된다. 실제 C 배열을 실행하면 행 우선 배치가 나타나며 `A[0][4]` 다음에 `A[1][0]`이 이어진다.

제출용 예제의 `%u`는 자료의 표기를 따른다. 포인터를 `%u`에 직접 전달하는 동작은 C 표준에서 정의되지 않으므로 실제 주소를 확인할 때는 학습용 예제를 기준으로 본다.

## 실행 방법

아래 명령은 Windows PowerShell에서 저장소 루트를 기준으로 실행한다.

### C와 C++

[CMake 설정](../../../CMakeLists.txt)은 C11과 C++17을 사용한다. IntelliJ에서는 표의 접두사와 접미사를 합친 CMake 타깃을 선택한다. 실습 12의 C++ 소스는
`prac12.cpp`이며 등록된 대상 이름은 `PLS_2026_Chapters_chap06_prac12_prac16`이다.

CMake, Ninja, MinGW의 GCC/G++가 `PATH`에 등록된 환경에서는 다음처럼 실습 16을 빌드할 수 있다. MinGW의 `bin` 경로는 실행에 필요한 C++ 런타임 DLL 검색에도 사용된다.

```powershell
$buildDir = Join-Path $env:TEMP ("pls-chap06-" + [guid]::NewGuid().ToString("N"))
cmake -S . -B $buildDir -G Ninja -DCMAKE_C_COMPILER=gcc -DCMAKE_CXX_COMPILER=g++
cmake --build $buildDir --target PLS_2026_Chapters_chap06_prac16_prac16
& (Join-Path $buildDir 'PLS_2026_Chapters_chap06_prac16_prac16.exe')
```

이미 구성한 빌드 폴더에서 배열 예제 세 개를 모두 빌드하려면 다음 명령을 사용한다.

```powershell
cmake --build $buildDir --target PLS_2026_Chapters_chap06_prac12_prac12_1 PLS_2026_Chapters_chap06_prac12_prac12_2 PLS_2026_Chapters_chap06_prac12_array_address
& (Join-Path $buildDir 'PLS_2026_Chapters_chap06_prac12_array_address.exe')
```

실습 16은 값을 출력한 뒤 다음 입력을 기다린다. `1.0` 또는 `64`를 입력하고 Enter를 누른다. 종료하려면 `q`를 입력한다. 실습 1, 14, 16은 `scanf()` 또는 `scanf_s()`로
입력을 받기 전에 `fflush(stdout)`을 호출해 IntelliJ 콘솔에 입력 안내를 즉시 표시한다.

### Java와 Python

Java는 각 실습의 `src` 폴더를 IntelliJ의 소스 루트로 지정하고 해당 클래스의 `main()`을 실행한다. 실행 구성의 클래스 경로에는 Java 소스를 포함하는 모듈을 지정한다. JDK 25가
`PATH`에 등록되어 있다면 PowerShell에서 소스 파일을 직접 실행할 수 있다. Python은 Python 3으로 실행한다.

```powershell
$chapter = 'PLS_2026/Chapters/chap06'
java "$chapter/prac09/src/prac09.java"
java "$chapter/prac09/src/StringTest.java"
'1 2 3 4 7' | java "$chapter/prac12/src/prac12.java"
py -3 "$chapter/prac09/prac09.py"
'1', '2', '3', '4', '7' | py -3 "$chapter/prac12/prac12.py"
```

실습 12에서 C++과 Java는 정수 다섯 개를 공백이나 줄바꿈으로 구분해 받는다. 현재 Python 코드는 `int(input())`을 사용하므로 한 줄에 하나씩 입력한다. IntelliJ에서 모듈 SDK를 찾지
못하면 실행 구성에 프로젝트의 `.venv` 인터프리터를 직접 지정한다.

#### IntelliJ에서 Java 실행이 멈출 때

- `ClassNotFoundException`이 발생하면 `prac09/src` 또는 `prac12/src`를 해당 Java 모듈의 소스 루트로 지정하고, 실행 구성의 클래스 경로로
  `ProgrammingLanguageStructure`를 선택한다. `prac09/src`와 `prac12/src`는 이 모듈에 등록되어 있다. 기존 로컬 `prac12 (1)` 구성이 소스 루트가 없는 `ProgrammingLanguageStructure3`를 가리키면 실행 모듈을 바꾼다.
- **완료됨. 캐시 저장 중…** 상태에서 멈췄을 때 로그에는 IntelliJ 내부 Java 빌드 (JPS)의 완료 신호를 기다리는 상태가 확인됐다. `prac12`의 입력을 받기 전 단계이며, 캐시 저장이 지연된
  원인은 확인되지 않았다. 위 PowerShell 명령으로 소스를 직접 실행해 확인할 수 있다.

## 코드에서 확인할 점

- 실습 1은 `BIT`가 16이므로 `int`의 하위 16비트만 표시한다. C11에서 음수의 오른쪽 시프트와 실습 2에서 `short` 범위를 벗어난 값을 부호 있는 정수형으로 변환한 결과는 구현에 따라 달라질 수
  있다. 실습 3의 `unsigned short` 결과 32768은 해당 형이 16비트인 환경의 값이다.
- 실습 6의 출력 문구에는 십만 번이라고 적혀 있지만 반복문의 조건이 `i <= 100000`이라 실제 덧셈은 100001번 수행된다.
- 실습 12에서 `1 2 3 4 7`을 입력하면 합계는 17이다. C++은 `sum / COUNT`를 정수로 먼저 계산해 평균이 3으로 출력된다. Java는 나누기 전에 `float`로 변환하고 Python은
  `/`를 사용해 3.4를 출력한다.
- 실습 13은 `void main()`과 포인터를 출력하는 `%u`를 사용한다. 표준적인 진입점은 `int main(void)`이고, 포인터 출력은 `%p`와 `(void *)` 캐스트를 사용한다. 실습 14의
  `scanf_s()` 지원은 환경에 따라 다르며, `free(ptr)` 이후 `*ptr` 접근의 결과는 정의되지 않는다.
- 실습 15의 형 크기는 ABI와 정렬 규칙에 따라 달라진다. 실습 16은 32비트 IEEE 754 `float`를 전제로 하며, 포인터 캐스트로 읽는 방식은 C의 별칭 규칙을 위반한다. 비트 패턴을 이식성 있게
  읽으려면 해당 표현을 지원하는 환경에서 `memcpy()`로 `uint32_t`에 복사한다.

## 검증 결과

2026-11-26 Windows에서 CMake 4.3.1, Ninja 1.13.2, MinGW GCC/G++ 15.2.0으로 6장의 C/C++ 타깃 **18개**를 Debug로 빌드했다. 실습 13·14는 컴파일과
링크까지 확인했고, 나머지 16개는 실행했다.

학습용 배열 예제에서 원소 20개의 주소가 2바이트 간격이고 `A[3][2]`의 실제 주소가 계산한 34바이트 오프셋과 일치함을 확인했다. 제출용 연속 저장 예제는 `1`부터 `20`까지 출력했다. 실습 15의
구조체와 공용체는 각각 24바이트, 16바이트였고, 실습 16의 `1.0`과 `64`는 각각 `0x3F800000`과 `0x42800000`을 출력했다.

OpenJDK 25에서 Java 예제 3개, Python 3.13.5에서 Python 예제 2개를 명령줄로 실행했다.

[상위 장 안내](../README.md) · [저장소 안내](../../../README.md)
