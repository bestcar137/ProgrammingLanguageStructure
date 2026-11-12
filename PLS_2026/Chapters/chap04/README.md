# 4장 실습 파일 구성

C, C++, Python, Pascal, Java를 사용하여 변수의 타입과 유효 범위, 값 전달과 참조 전달, 정적 변수와 상수를 비교한다. 실습 번호와 강의 슬라이드 번호를 파일명으로 사용한다.

## 검토한 커밋

2026-11-12 기준 현재 파일과 관련 이력을 확인했다.

- `62138ec`(2026-10-15)에서 여러 언어의 영역·스코프 예제를 추가했다.
- `330394e`(2026-10-27)에서 Pascal 예제의 출력 함수와 서식을 수정했다.
- `94961e2`(2026-10-29)에서 실습을 현재 `PLS_2026/Chapters` 경로로 통합하고 CMake 구성을 정비했다.

## 폴더 구조

```text
chap04/
├── README.md
├── prac01-03/
│   └── prac01-03.c
├── prac04/
│   ├── prac04_1.py
│   └── prac04_2.py
├── prac05/
│   └── prac05.py
├── prac06-07/
│   └── prac06-07.py
├── prac08/
│   ├── prac08.c
│   ├── prac08_pas.pas
│   ├── prac08
│   ├── prac08_pas
│   └── prac08_pas.o
├── prac09/
│   ├── prac09.c
│   └── prac09
├── prac_p23/
│   └── prac_p23.c
├── prac_p33/
│   ├── prac_p33.cpp
│   └── prac_p33
├── prac_p34/
│   ├── prac_p34.cpp
│   └── prac_p34
├── prac_p35/
│   ├── prac_p35.pas
│   ├── prac_p35
│   └── prac_p35.o
└── prac_p36/
    ├── prac_p36.cpp
    ├── prac_p36_java.java
    └── prac_p36
```

실습 번호별로 파일을 모으되, 통합 예제는 `prac01-03/`, `prac06-07/`에 함께 보관한다. 슬라이드 예제는 `prac_p번호/`를 사용한다. 확장자 없는 실행 파일 7개와 `.o` 오브젝트 파일
2개는 기존 산출물이며 해당 실습 폴더로 함께 이동했다. 소스 14개와 산출물 9개의 내용과 파일명은 유지했다.

## 파일별 실습 내용

| 파일                                                       | 내용                                                                                                                       |
|------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| [prac01-03/prac01-03.c](prac01-03/prac01-03.c)             | 중첩 블록의 지역 변수와 같은 이름의 변수가 바깥 변수를 가리는 동작을 확인한다.                                             |
| [prac04/prac04_1.py](prac04/prac04_1.py)                   | `score`에 정수와 문자열을 차례로 대입하고 값과 `type()`을 출력한다.                                                        |
| [prac04/prac04_2.py](prac04/prac04_2.py)                   | 같은 변수에 정수 80과 문자열 `80 %`를 차례로 대입한다.                                                                     |
| [prac05/prac05.py](prac05/prac05.py)                       | 전역 할인율 `persent`를 함수에서 읽어 50,000원에 할인을 적용한 지불 금액을 계산하고 출력한다.                              |
| [prac06-07/prac06-07.py](prac06-07/prac06-07.py)           | `global percent`로 전역 할인율을 20에서 30으로 바꾸고 할인 적용 후 지불 금액을 반환한다. 호출 결과를 출력하는 문장은 없다. |
| [prac08/prac08.c](prac08/prac08.c)                         | swap 함수에서 값으로 전달받은 매개변수를 교환하고, 함수 내부와 호출자의 값을 출력한다.                                     |
| [prac08/prac08_pas.pas](prac08/prac08_pas.pas)             | Pascal의 var 매개변수로 호출자의 `x`, `y`를 교환한다. 출력문은 없다.                                                       |
| [prac09/prac09.c](prac09/prac09.c)                         | 매개변수 `x`와 전역 `x`의 범위를 구분하고, `f(2)`의 결과를 전역 변수에 저장한다.                                           |
| [prac_p23/prac_p23.c](prac_p23/prac_p23.c)                 | 함수 안의 static 변수가 호출 사이에 값을 유지하여 1~10을 출력한다.                                                         |
| [prac_p33/prac_p33.cpp](prac_p33/prac_p33.cpp)             | 전역 정수 `x`와 함수 안의 지역 실수 `x`를 비교한다.                                                                        |
| [prac_p34/prac_p34.cpp](prac_p34/prac_p34.cpp)             | 지역 `x`가 있는 함수에서 `::x`로 전역 변수에 접근해 500을 대입한다.                                                        |
| [prac_p35/prac_p35.pas](prac_p35/prac_p35.pas)             | `sub2`의 지역 `x = 4`와 전역 `x = 2`를 두고, `sub1`이 정적 범위 규칙에 따라 전역 값 2를 출력한다.                          |
| [prac_p36/prac_p36.cpp](prac_p36/prac_p36.cpp)             | 매크로 상수 PI와 입력한 반지름으로 원의 넓이를 계산한다.                                                                   |
| [prac_p36/prac_p36_java.java](prac_p36/prac_p36_java.java) | final 상수 PI와 고정 반지름 10으로 원의 넓이를 계산하는 `CircleArea` 클래스이다.                                           |

## 빌드 구성과 참고 사항

저장소 루트의 `CMakeLists.txt`는 C11·C++17을 사용하며 다음 대상을 등록한다.

| 소스                                           | CMake 대상                           |
|------------------------------------------------|--------------------------------------|
| [prac01-03/prac01-03.c](prac01-03/prac01-03.c) | `PLS_2026_Chapters_chap04_prac01_03` |
| [prac08/prac08.c](prac08/prac08.c)             | `PLS_2026_Chapters_chap04_prac08`    |
| [prac09/prac09.c](prac09/prac09.c)             | `PLS_2026_Chapters_chap04_prac09`    |
| [prac_p23/prac_p23.c](prac_p23/prac_p23.c)     | `PLS_2026_Chapters_chap04_prac_p23`  |
| [prac_p33/prac_p33.cpp](prac_p33/prac_p33.cpp) | `PLS_2026_Chapters_chap04_prac_p33`  |
| [prac_p34/prac_p34.cpp](prac_p34/prac_p34.cpp) | `PLS_2026_Chapters_chap04_prac_p34`  |
| [prac_p36/prac_p36.cpp](prac_p36/prac_p36.cpp) | `PLS_2026_Chapters_chap04_prac_p36`  |

Python 파일은 아래처럼 저장소 루트에서 실행하거나 해당 실습 폴더에서 `python 파일명.py`로 실행한다. Pascal 소스는 별도의 Pascal 컴파일러가 필요하며 CMake 대상에는 포함되지 않는다.
Java 파일의 public 클래스 이름은 `CircleArea`이므로 일반적인
javac 파일 컴파일에는 `CircleArea.java`라는 파일명이 필요하다.

[prac06-07/prac06-07.py](prac06-07/prac06-07.py)의 오류 관련 주석은 global 선언을 제거했을 때를 설명하지만 현재 코드에는 선언이 포함되어
있다. [prac08/prac08.c](prac08/prac08.c)는 값 전달이므로 호출 후 main의 `x = 5`, `y = -3`
이 유지된다. 이러한 차이를 Pascal의 var 매개변수 예제와 비교할 수 있다.

## 실행 방법

아래 PowerShell 명령은 저장소 루트 기준이며, Windows용 CMake·Ninja·GCC가 PATH에 등록되어 있어야 한다. 빌드 경로는 기존 IDE 캐시와 겹치지 않는 임시 폴더를 사용한다.

```powershell
$buildDir = Join-Path $env:TEMP ("pls-chap04-" + [guid]::NewGuid().ToString("N"))
cmake -S . -B $buildDir -G Ninja -DCMAKE_C_COMPILER=gcc -DCMAKE_CXX_COMPILER=g++
cmake --build $buildDir --target PLS_2026_Chapters_chap04_prac01_03 PLS_2026_Chapters_chap04_prac08 PLS_2026_Chapters_chap04_prac09 PLS_2026_Chapters_chap04_prac_p23 PLS_2026_Chapters_chap04_prac_p33 PLS_2026_Chapters_chap04_prac_p34 PLS_2026_Chapters_chap04_prac_p36
& (Join-Path $buildDir 'PLS_2026_Chapters_chap04_prac08.exe')
'10' | & (Join-Path $buildDir 'PLS_2026_Chapters_chap04_prac_p36.exe')
py PLS_2026/Chapters/chap04/prac04/prac04_1.py
py PLS_2026/Chapters/chap04/prac04/prac04_2.py
py PLS_2026/Chapters/chap04/prac05/prac05.py
py PLS_2026/Chapters/chap04/prac06-07/prac06-07.py
```

Java 예제는 원래 파일명을 보존했다. 컴파일하려면 임시 폴더에 클래스 이름에 맞춰 복사한 뒤 실행한다 (JDK 필요).

```powershell
$javaDir = Join-Path $env:TEMP ("pls-circle-" + [guid]::NewGuid().ToString("N"))
New-Item -ItemType Directory -Path $javaDir | Out-Null
Copy-Item -LiteralPath 'PLS_2026/Chapters/chap04/prac_p36/prac_p36_java.java' -Destination (Join-Path $javaDir 'CircleArea.java')
javac -encoding UTF-8 -d $javaDir (Join-Path $javaDir 'CircleArea.java')
java -cp $javaDir CircleArea
```

[상위 장 안내](../README.md) · [5장 실습 구조](../chap05/README.md)
## 구조 정리 후 검증

2026-11-12(한국 시간)에 Windows 환경에서 확인했다.

- 소스 14개와 기존 산출물 9개를 이동 전 SHA-256과 대조하여 내용 보존을 확인했다. 누락·중복·추가 파일은 없다.
- `PLS_2026` 아래 README의 상대 링크 33개가 실제 경로를 가리키는지 확인했다.
- 임시 폴더의 CMake 4.4.4·Ninja 1.13.2와 Windows UCRT64 GCC/G++ 14.2.0으로 구성하고, 이 장의 C/C++ 대상 7개를 모두 빌드·실행했다. 해당 구성·빌드에서 경고나 오류는 없었다. 다른 장의 빌드는 이번 검증 범위에 포함하지 않았다.
- Python 3.13으로 스크립트 4개를 실행했다. 위 명령의 `py`는 Windows Python 런처이며 `python`이 설정된 환경에서는 이를 대신 사용할 수 있다.
- JDK 21로 임시 `CircleArea.java` 사본을 컴파일·실행하여 `Circle Area = 314.0` 출력을 확인했다. 원본 파일명과 코드는 보존했다.
- Pascal 컴파일러를 확인하지 못하여 Pascal 소스 2개는 빌드하지 않았다. 함께 저장된 기존 실행·오브젝트 파일은 이번 빌드 결과가 아니다.
- 기존 `cmake-build-wsl` 생성 파일에는 이동 전 경로가 남아 있다. 이 캐시는 수정하지 않았으며 재사용 전에 해당 환경에서 CMake를 재구성해야 한다.
