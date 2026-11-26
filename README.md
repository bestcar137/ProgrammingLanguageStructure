# 프로그래밍 언어구조론

프로그래밍 언어구조론 과목의 예제와 과제, 실습 코드를 연도별로 보관하는 학습 저장소입니다. 어휘·구문 분석과 인터프리터, 변수의 유효 범위, 연산자와 제어문, 자료형의 동작을 여러 언어로 비교합니다.

## C 실습에서 입력 안내가 바로 보이지 않을 때

IntelliJ 콘솔에서는 입력 안내를 출력한 뒤에도 내용이 표준 출력 버퍼에 남을 수 있습니다. `printf()` 직후에 `fflush(stdout)`을 호출하면 입력을 기다리기 전에 안내가 표시됩니다.

```c
printf("실수를 입력하세요(종료하려면 문자를 입력): ");
fflush(stdout);
```

[6장 실습 16](PLS_2026/Chapters/chap06/prac16/prac16.c)을 실행하고 `1.0`이나 `64`를 입력하면 각각 `0x3F800000`, `0x42800000`이 출력됩니다.
종료하려면 `q`를 입력합니다.

## Ubuntu 터미널에서 실습 폴더 한 번에 만들기

Bash의 중괄호 확장을 사용하면 현재 디렉터리에 `chap01`부터 `chap10`까지 만들 수 있습니다.

```bash
mkdir chap{01..10}
```

같은 이름의 폴더가 있으면 `mkdir`은 해당 폴더에 대해 오류를 표시합니다. 기존 폴더와 그 안의 파일을 유지하면서 빠진 폴더만 만들려면 `mkdir -p chap{01..10}`을 사용합니다.

## 자료 바로가기

| 구분                                            | 내용                                  |
|-------------------------------------------------|---------------------------------------|
| [2026년 실습 안내](PLS_2026/README.md)          | 2~7장 구성과 공통 실행 환경           |
| [2026년 장별 목차](PLS_2026/Chapters/README.md) | 장별 예제와 2026-11-26 변경·검증 기록 |
| [2025년 자료](PLS_2025/Chapters/)               | Java 중심의 예제, 과제 및 풀이        |
| [IntelliJ 참고 자료](INTELLIJ_GUIDE/)           | 주석, 단축키, 도구 창, 공백 표시      |
| [CMake 구성](CMakeLists.txt)                    | 2026년 4~7장의 C/C++ 빌드 타깃        |

## 저장소 구성

```text
ProgrammingLanguageStructure/
├── PLS_2025/
│   └── Chapters/
│       ├── chap01_introduction/
│       ├── chap02_grammar/
│       ├── chap03_parsing/
│       ├── chap04_variable/
│       ├── chap05_semantics/
│       └── chap06_type/ ~ chap13_functional_language/
├── PLS_2026/
│   ├── README.md
│   └── Chapters/
│       ├── README.md
│       ├── chap02/             # 산술식 인터프리터
│       ├── chap03/             # S 언어 인터프리터
│       ├── chap04/             # 변수·스코프·인수 전달
│       ├── chap05/             # 연산자·반복문·분기문
│       ├── chap06/             # 자료형과 내부 표현
│       └── chap07/             # 타입 시스템
├── INTELLIJ_GUIDE/             # IDE 사용 참고 문서
├── CMakeLists.txt              # C11·C++17 빌드 설정
├── sample.py                   # PyCharm 기본 실행 예제
└── README.md                   # 저장소 전체 안내
```

2026년 2~3장은 Python 소스를 장 폴더에 직접 두고, 4~7장은 실습별 하위 폴더를 사용합니다. `prac_p23`과 같은 이름의 숫자는 강의 슬라이드 번호입니다. Java 파일이 있는 실습은 해당 폴더의
`src`를 사용합니다.

`cmake-build-wsl/`와 실습 폴더에 남아 있는 실행·오브젝트 파일은 이전 환경에서 만든 결과물입니다. 현재 소스를 빌드할 때는 사용하는 운영체제와 컴파일러에 맞춰 새 빌드 폴더를 구성합니다.

## 2026년 실습

| 장  | 주요 내용                                                           | 상세 문서                                    |
|-----|---------------------------------------------------------------------|----------------------------------------------|
| 2장 | 정규식 토큰화, 재귀 하강 파싱, AST와 산술식 평가                    | [chap02](PLS_2026/Chapters/chap02/README.md) |
| 3장 | S 언어의 선언·대입·입출력·조건문·반복문                             | [chap03](PLS_2026/Chapters/chap03/README.md) |
| 4장 | 변수 가림, 정적 변수, 값·참조 전달, 상수                            | [chap04](PLS_2026/Chapters/chap04/README.md) |
| 5장 | 평가 순서, 단락 평가, `break`·`continue`, 학점 판정                 | [chap05](PLS_2026/Chapters/chap05/README.md) |
| 6장 | 정수·부동소수점 표현, 문자열, 열거형, 배열, 구조체, 포인터와 공용체 | [chap06](PLS_2026/Chapters/chap06/README.md) |
| 7장 | 문자와 정수의 혼합 연산, 실수에서 정수로의 변환, 실수 비트의 재해석 | [chap07](PLS_2026/Chapters/chap07/README.md) |

6장에는 소스 23개가 있으며, 실습 9와 12는 C++·Java·Python의 동작을 비교합니다. 13주 실습의 배열 주소 계산과 연속 저장은 6장 `prac12`에 학습용과 제출용 C 파일로 정리했습니다. 레코드
타입 예제는 `prac11.c`에 있습니다. 파일별 대응과 실행 타깃은 [6장 README](PLS_2026/Chapters/chap06/README.md#13주-실습-자료와-파일-대응)에서 확인할 수 있습니다.

7장은 강의 자료의 코드와 주석을 옮긴 세 실습으로 구성합니다. 5장 실습 7의 두 C++ 예제는 `int main()`을 사용하며, `break`와 `continue`의
차이는 [장별 변경 기록](PLS_2026/Chapters/README.md#2026-11-26-변경-내용)에 정리했습니다.

## 2025년 자료

| 디렉터리                                                      | 현재 자료                                          |
|---------------------------------------------------------------|----------------------------------------------------|
| [chap01_introduction](PLS_2025/Chapters/chap01_introduction/) | Java 시작 예제와 재귀 하강 파싱                    |
| [chap03_parsing](PLS_2025/Chapters/chap03_parsing/)           | 토큰 구분, 공백 처리, 잘못된 토큰 처리와 수식 계산 |
| [chap04_variable](PLS_2025/Chapters/chap04_variable/)         | 변수와 중첩 스코프 과제 및 풀이                    |
| [chap05_semantics](PLS_2025/Chapters/chap05_semantics/)       | 출력·형변환·조건문·반복문 평가 코드와 과제 틀      |

`chap02_grammar`와 6~13장은 IntelliJ 모듈 설정을 보관합니다. Java 예제와 과제의 실행 진입점은 파일마다 다르며, 같은 이름의 클래스가 있는 실습은 개별적으로 실행합니다.

## 실행 방법

아래 명령은 Windows PowerShell에서 저장소 루트를 기준으로 실행합니다.

### Python

Python 3으로 실행합니다. 5장의 대입 표현식 `:=`를 사용하는 예제에는 Python 3.8 이상이 필요합니다. Windows에서 `py`는 Python 런처이며, Ubuntu에서는 일반적으로
`python3`를 사용합니다.

```powershell
py -3 PLS_2026/Chapters/chap02/prob04.py
py -3 PLS_2026/Chapters/chap03/S_Program.py
py -3 PLS_2026/Chapters/chap07/prac01/prac01.py
```

입력 형식은 실습마다 다릅니다. 6장 실습 12의 Python 코드는 정수를 한 줄에 하나씩 읽습니다. IntelliJ에서 Python SDK를 찾지 못하면 해당 실행 구성에 프로젝트의 `.venv` 인터프리터를
지정합니다.

### C / C++

[CMakeLists.txt](CMakeLists.txt)는 CMake 3.20 이상과 C11·C++17 컴파일러를 사용해 4~7장의 C/C++ 예제를 독립 실행 파일로 빌드합니다. IntelliJ에서는 도구 체인에
CMake와 C/C++ 컴파일러를 지정한 뒤, 장별 README에 적힌 CMake 타깃을 선택합니다.

CMake, Ninja, MinGW의 GCC/G++가 `PATH`에 등록된 환경에서는 다음 명령으로 6장 실습 1과 7장 실습 1을 빌드할 수 있습니다.

```powershell
$plsBuildDir = Join-Path $env:TEMP ("pls-build-" + [guid]::NewGuid().ToString("N"))
cmake -S . -B $plsBuildDir -G Ninja -DCMAKE_BUILD_TYPE=Debug -DCMAKE_C_COMPILER=gcc -DCMAKE_CXX_COMPILER=g++
cmake --build $plsBuildDir --target PLS_2026_Chapters_chap06_prac01 PLS_2026_Chapters_chap07_prac01
'5' | & (Join-Path $plsBuildDir 'PLS_2026_Chapters_chap06_prac01.exe')
& (Join-Path $plsBuildDir 'PLS_2026_Chapters_chap07_prac01.exe')
```

첫 실행은 5의 하위 16비트를 출력하고, 두 번째 실행은 `정수 결과: 70`과 `문자 결과: F`를 출력합니다. 5장의 `PLS_2026_Chapters_chap05_prac7`과
`PLS_2026_Chapters_chap05_prac7_1`은 개별 타깃으로 지정해 빌드합니다.

### Java / Pascal

현재 IntelliJ 프로젝트는 OpenJDK 25로 설정되어 있습니다. Java 예제는 실습별 `src`를 소스 루트로 지정하고, 실행 구성에 해당 소스를 포함한 Java 모듈의 클래스 경로를 선택합니다. 예를
들어 6장 `prac09`는 `ProgrammingLanguageStructure` 모듈을 사용합니다. JDK가 `PATH`에 등록되어 있으면 6장 예제를 다음처럼 소스 파일에서 직접 실행할 수 있습니다.

```powershell
java PLS_2026/Chapters/chap06/prac09/src/prac09.java
```

`prac12.java`는 `prac12/src`를 소스 루트로 지정해 실행합니다. IntelliJ의 **완료됨. 캐시 저장 중…** 메시지는 실행 전 Java 빌드 단계에서 표시됩니다. 소스 루트·실행 모듈 설정과
명령줄 실행 방법은 [6장 Java 실행 안내](PLS_2026/Chapters/chap06/README.md#intellij에서-java-실행이-멈출-때)에 정리했습니다.

4장의 `prac_p36_java.java`는 public 클래스 이름이 `CircleArea`입니다. 일반 `javac`로 컴파일할 때 사용할 임시 사본 작성
방법은 [4장 README](PLS_2026/Chapters/chap04/README.md)에 있습니다. 5장의 `prac6_Java_for.java`와 `prac6_Java_while.java`는 실습용 클래스
틀입니다.

4장 Pascal 예제는 별도의 Pascal 컴파일러로 실행합니다. 파일별 동작과 컴파일 시 참고할 점은 [4장 README](PLS_2026/Chapters/chap04/README.md)에 정리되어 있습니다.

## 문서와 검증 기록

2026-11-26 Windows에서 CMake 4.3.1, Ninja 1.13.2, MinGW GCC/G++ 15.2.0으로 기본 빌드 제외 2개를 포함한 C/C++ 타깃 **45개**를 Debug로 빌드했습니다.
5장 실습 7의 두 예제, 6장 C/C++ 타깃 16개, 7장 C/C++ 타깃 3개를 실행했습니다. 6장 실습 13과 14는 컴파일과 링크까지 확인했습니다.

6장 Java 예제 3개는 OpenJDK 25, 6·7장 Python 예제 5개는 Python 3.13.5로 명령줄에서 실행했습니다. 배열 주소, 정수 나눗셈, 부동소수점 비트 재해석의 확인
결과는 [6장 검증 기록](PLS_2026/Chapters/chap06/README.md#검증-결과)과 [7장 검증 기록](PLS_2026/Chapters/chap07/README.md#검증-결과)에서 볼 수
있습니다.
