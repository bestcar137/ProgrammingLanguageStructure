# PLS_2026 파일 구성

프로그래밍언어구조론의 2026년 실습을 장별로 모은 디렉터리이다. 2026-11-26 기준으로 `Chapters` 아래에 2~7장 실습이 있다. [장별 실습 안내](Chapters/README.md)에서 장별 목차를
확인하고, 아래에서 현재 파일과 최종 검증 결과를 확인할 수 있다.

```text
PLS_2026/
├── README.md
└── Chapters/
    ├── README.md
    ├── chap02/   어휘 분석·구문 분석·수식 평가
    ├── chap03/   S 언어 인터프리터와 예제 프로그램
    ├── chap04/   변수·타입·스코프·매개변수 전달
    ├── chap05/   연산자·평가 순서·반복문·분기문
    ├── chap06/   자료형과 내부 표현·문자열·구조체·포인터
    └── chap07/   타입 시스템·형변환·비트 재해석
```

| 디렉터리                            | 안내                                                       |
|-------------------------------------|------------------------------------------------------------|
| [chap02](Chapters/chap02/README.md) | Python 산술식 인터프리터                                   |
| [chap03](Chapters/chap03/README.md) | S 언어의 선언·대입·입출력·조건문·반복문                    |
| [chap04](Chapters/chap04/README.md) | C, C++, Python, Pascal, Java의 변수와 영역 비교            |
| [chap05](Chapters/chap05/README.md) | 연산자와 제어문 예제, `break`와 `continue` 비교            |
| [chap06](Chapters/chap06/README.md) | 정수·실수 표현, 문자열, 구조체, 배열 주소 계산과 연속 저장 |
| [chap07](Chapters/chap07/README.md) | 강의 자료의 타입 오류 예제 세 쌍과 C/C++·Python 실행 방법  |

## 2026-11-26 실습 정리

- **5장**은 실습 7의 두 C++ 진입점을 `int main()`으로 바꿨다. `break`와 `continue`의 출력 차이를 확인했고 5장과 6장 소스는 각자 독립된 실행 타깃에서 빌드한다.
- **6장**은 소스 23개로 구성한다. 13주 실습 자료의 배열 선언은 `prac12`의 C++·Java·Python에, 배열 주소 출력과 연속 저장은 제출용 C 파일 두 개와 학습용 C 파일 하나에 대응한다.
  레코드 예제의 위치와 `%u`·`%p`의 차이는 [6장 README](Chapters/chap06/README.md#13주-실습-자료와-파일-대응)를 참고한다.
- **7장**은 문자·정수 혼합 연산, 실수의 소수부 손실, 실수 비트 재해석을 다루는 C/C++·Python 소스 6개로 구성한다. 강의 자료의 변수, 출력 문구,
  주석을 [실습 파일](Chapters/chap07/README.md)에 반영했다.

## 공통 실행 환경

- **C/C++**는 [루트 CMake 설정](../CMakeLists.txt)에서 4~7장 실습을 독립 실행 타깃으로 등록한다. CMake 3.20 이상과 C11·C++17 컴파일러가 필요하다.
  Windows에서는 IntelliJ의 도구 체인에 CMake 및 MinGW를 지정하고, Ninja를 사용하는 구성에는 Ninja 경로도 지정한다. 현재 타깃 이름은 기존 IntelliJ 실행 구성과 호환된다.
- **Python**은 각 스크립트를 Python 3으로 실행한다. IntelliJ에서 모듈 SDK 오류가 나면 Python 실행 구성에 프로젝트의 `.venv` 인터프리터를 직접 지정한다. 이번 실습은
  Python 3.13.5로 확인했다.
- **Java**는 JDK와 실습별 `src` 소스 루트를 사용한다. 현재 IntelliJ 프로젝트 JDK는 OpenJDK 25이고, 실행 구성의 클래스 경로에는 Java 소스를 포함하는 모듈을 지정한다.
  CMake의 Python 자동 연동은 프로젝트의 Java SDK 설정과 충돌할 수 있어 꺼져 있다. 모듈 또는 소스 루트 문제와 IntelliJ의 캐시 저장
  대기는 [6장 Java 실행 안내](Chapters/chap06/README.md#intellij에서-java-실행이-멈출-때)를 참고한다.
- **Pascal** 실행 방법과 터미널 팁은 [저장소 README](../README.md)에 있다. Ubuntu의 Bash에서는 `mkdir -p chap{01..10}`으로 기존 폴더를 유지하면서 빠진 폴더를
  만들 수 있다. C 콘솔에서 입력 안내가 늦으면 `printf()` 뒤와 입력 함수 호출 사이에 `fflush(stdout)`을 둔다.

## 검증 결과

Windows에서 공통 CMake 구성으로 기본 빌드 제외 2개를 포함한 타깃 45개를 Debug로 빌드했다. 이 중 5장 실습 7의 두 동작, 6장 C/C++ 타깃 16개, 7장 C/C++ 타깃 3개를 실행했다.
OpenJDK 25에서 Java 예제 3개, Python 3.13.5에서 Python 예제 5개를 명령줄로 실행했다.

## 구성 이력

2026-10-29의 `94961e2` 커밋에서 기존 `Programming_Language_Structures`의 실습을 `PLS_2026/Chapters`로 통합했다. 2026-11-05의 `e3b2dd8`
커밋에서 5장 파일을 실습 번호별로 정리했다. 2026-11-26 작업에서는 5장 C++ 실습의 실행 진입점을 고치고, 6장 예제를 확장했으며, 7장 실습과 실행 안내를 추가했다.
