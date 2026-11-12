# 프로그래밍 언어구조론

프로그래밍 언어구조론 과목의 예제와 과제, 실습 코드를 연도별로 보관하는 학습 저장소입니다. 어휘·구문 분석과 인터프리터, 변수의 유효 범위, 연산자와 제어문, 자료형의 동작을 여러 언어로 비교합니다.

## 자료 바로가기

| 구분                                            | 내용                                             |
|-------------------------------------------------|--------------------------------------------------|
| [2026년 실습 안내](PLS_2026/README.md)          | Python, C, C++, Java, Pascal을 활용한 2~6장 실습 |
| [2026년 장별 목차](PLS_2026/Chapters/README.md) | 각 장의 파일 구성·실습 내용·실행 방법            |
| [2025년 자료](PLS_2025/Chapters/)               | Java 중심의 예제, 과제와 풀이 자료               |
| [IntelliJ 참고 자료](INTELLIJ_GUIDE/)           | 주석, 단축키, 도구 창과 공백 표시 안내           |
| [CMake 구성](CMakeLists.txt)                    | 2026년 4~6장 C/C++ 실습별 실행 대상              |

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
│       └── chap06/             # 정수 표현과 형변환
├── INTELLIJ_GUIDE/             # IDE 사용 참고 문서
├── CMakeLists.txt              # C11·C++17 빌드 설정
├── sample.py                   # PyCharm 기본 실행 예제
└── README.md                   # 저장소 전체 안내
```

IDE 설정과 일부 기존 빌드 산출물도 함께 보관되어 있습니다. `cmake-build-wsl/`의 생성 파일, 실습 폴더의 확장자 없는 실행 파일과 `.o` 파일은 기존 환경의 결과물이므로 현재 소스를 확인할 때는
해당 소스와 장별 문서를 기준으로 봅니다.

## 2026년 실습

| 장  | 주요 내용                                                 | 상세 문서                                    |
|-----|-----------------------------------------------------------|----------------------------------------------|
| 2장 | 정규식 토큰화, 재귀 하강 파싱, AST와 산술식 평가          | [chap02](PLS_2026/Chapters/chap02/README.md) |
| 3장 | S 언어의 선언·대입·지역 범위·입출력·조건문·반복문         | [chap03](PLS_2026/Chapters/chap03/README.md) |
| 4장 | 동적 타입, 변수 가림, 전역·정적 변수, 값·참조 전달과 상수 | [chap04](PLS_2026/Chapters/chap04/README.md) |
| 5장 | 연산자, 평가 순서와 단락 평가, 반복문·분기문과 학점 판정  | [chap05](PLS_2026/Chapters/chap05/README.md) |
| 6장 | 하위 16비트 출력, 정수 승격, 형변환과 부호 없는 정수      | [chap06](PLS_2026/Chapters/chap06/README.md) |

2~3장은 장 폴더에 Python 소스를 직접 두고, 4~6장은 실습 번호별 하위 폴더로 구성합니다. `prac_p23` 등의 이름은 강의 슬라이드 번호에 대응합니다. 파일별 역할, 코드와 주석의 차이, 입력 조건
및 기존 검증 기록은 각 장의 README에서 확인할 수 있습니다.

## 2025년 자료

| 디렉터리                                                      | 현재 자료                                                      |
|---------------------------------------------------------------|----------------------------------------------------------------|
| [chap01_introduction](PLS_2025/Chapters/chap01_introduction/) | Java 시작 예제와 재귀 하강 파싱 학습 메모·코드                 |
| [chap03_parsing](PLS_2025/Chapters/chap03_parsing/)           | 숫자·연산자 구분, 공백 처리, 잘못된 토큰 처리와 수식 계산 과제 |
| [chap04_variable](PLS_2025/Chapters/chap04_variable/)         | 변수와 중첩 스코프를 다루는 과제·풀이                          |
| [chap05_semantics](PLS_2025/Chapters/chap05_semantics/)       | 출력·형변환·조건문·반복문 평가 코드와 과제 틀                  |

`chap02_grammar`와 6~13장 폴더에는 현재 Java 소스 없이 IntelliJ 모듈 설정이 있습니다. 과제 틀, 주석 처리된 코드, 풀이가 함께 있으므로 파일마다 구현 상태와 실행 진입점을 확인해야
합니다. 같은 이름의 클래스가 여러 장에 있으므로 Java 소스는 실습별로 나누어 실행합니다.

## 실행 방법

아래 명령은 저장소 루트 기준입니다. 각 언어의 도구가 설치되어 있어야 하며, 장별 README에 추가 예제와 주의 사항을 정리했습니다.

### Python

Python 3을 사용하며, 5장의 대입 표현식 `:=` 예제에는 Python 3.8 이상이 필요합니다. 2026년 Python 예제는 표준 라이브러리를 사용합니다.

```powershell
py PLS_2026/Chapters/chap02/prob04.py
py PLS_2026/Chapters/chap03/S_Program.py
```

`py`는 Windows Python 런처입니다. 환경에 따라 `python` 또는 `python3`를 사용합니다. 3장의 일부 실습과 5장의 학점 판정 등은 실행 중 입력을 받습니다.

### C / C++

루트 CMake 설정은 CMake 3.20 이상, C11·C++17 컴파일러를 사용합니다. 2026년 4~6장 실습을 각각 독립된 실행 파일로 만들며, Python·Java·Pascal 소스는 별도의 도구로
실행합니다.

다음은 CMake·Ninja·GCC/G++가 PATH에 등록된 Windows PowerShell 환경의 예입니다. 기존 IDE 캐시와 충돌하지 않도록 임시 빌드 폴더를 만듭니다.

```powershell
$plsBuildDir = Join-Path $env:TEMP ("pls-build-" + [guid]::NewGuid().ToString("N"))
cmake -S . -B $plsBuildDir -G Ninja -DCMAKE_C_COMPILER=gcc -DCMAKE_CXX_COMPILER=g++
cmake --build $plsBuildDir --target PLS_2026_Chapters_chap06_prac01
'5' | & (Join-Path $plsBuildDir 'PLS_2026_Chapters_chap06_prac01.exe')
```

대상 이름은 `PLS_2026_Chapters_장_실습명` 형태이며 정확한 이름은 `CMakeLists.txt`에서 확인합니다. 5장 `prac07`의 두 C++ 대상은 `void main()` 때문에 기본 전체
빌드에서 제외되어 있습니다. 기존 `cmake-build-wsl/` 캐시에는 과거 소스 경로가 남아 있으므로 사용 환경에 맞춰 새로 구성해야 합니다.

### Java / Pascal

- Java 예제는 JDK와 실습별 소스 폴더를 사용합니다. 2025년 일부 코드에는 `instanceof` 패턴 매칭이 있어 JDK 17 이상을 사용하는 것이 적합합니다.
- 2026년 4장의 `prac_p36_java.java`는 public 클래스 이름이 `CircleArea`입니다. 원래 파일명을 보존한 상태이며, 일반적인 `javac` 컴파일을 위한 임시 사본 작성
  방법은 [4장 README](PLS_2026/Chapters/chap04/README.md)에 있습니다.
- 5장 `prac04/src/`의 `prac6_Java_for.java`와 `prac6_Java_while.java`는 현재 빈 클래스 틀입니다.
- Pascal 실습은 별도의 Pascal 컴파일러가 필요합니다. 기존 실행·오브젝트 파일은 소스의 재빌드 결과와 구별합니다.

## 문서와 검증 기록

장별 README에 적힌 빌드·실행 결과는 해당 문서에 명시된 날짜와 환경의 기록입니다. 이번 루트 안내 작성에서는 저장소 구성, 기존 문서, CMake 대상과 문서 링크를 대조했으며 전체 언어·실습을 새로
빌드하거나 실행하지는 않았습니다.
