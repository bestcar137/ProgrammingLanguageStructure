# PLS_2026 파일 구성

프로그래밍언어구조론의 2026년 실습을 장별로 모은 디렉터리이다. 2026-11-12 기준으로 `Chapters` 아래에 2~5장 실습이 있다.

```text
PLS_2026/
├── README.md
└── Chapters/
    ├── README.md
    ├── chap02/   어휘 분석·구문 분석·수식 평가
    ├── chap03/   S 언어 인터프리터와 예제 프로그램
    ├── chap04/   변수·타입·스코프·매개변수 전달
    └── chap05/   연산자·평가 순서·반복문·분기문
```

| 디렉터리                            | 안내                                            |
|-------------------------------------|-------------------------------------------------|
| [chap02](Chapters/chap02/README.md) | Python으로 작성한 산술식 인터프리터의 구성      |
| [chap03](Chapters/chap03/README.md) | 선언·대입·입출력·조건문·반복문 실습             |
| [chap04](Chapters/chap04/README.md) | C, C++, Python, Pascal, Java의 변수와 영역 비교 |
| [chap05](Chapters/chap05/README.md) | 실습 번호별 제어문 예제와 빌드 구성             |

2026-10-29의 `94961e2` 커밋에서 기존 `Programming_Language_Structures`의 실습이 현재 `PLS_2026/Chapters` 경로로 통합되었다. 2026-11-05의
`e3b2dd8`에서는 5장 파일을 실습 번호별 폴더로 정리했다. 각 README는 커밋 메시지와 현재 소스를 대조하여 작성했다.

저장소 루트의 `CMakeLists.txt`가 4·5장의 C/C++ 실행 대상을 관리하며 C11과 C++17을 사용한다. Python, Pascal, Java 파일은 해당 언어의 실행 도구를 사용한다. 장별
README에 파일 역할과 현재 코드의 참고 사항을 정리했다.
