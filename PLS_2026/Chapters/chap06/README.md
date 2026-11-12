# 6장 실습: 자료형과 정수의 내부 표현

정수의 비트 표현, 정수 승격과 명시적 형변환, 부호 있는 정수와 부호 없는 정수의 차이를 C로 확인한다. 실습마다 독립된 `main` 함수가 있다.

## 디렉터리 구조

```text
chap06/
├── README.md
├── prac01/
│   └── prac01.c
├── prac02/
│   └── prac02.c
└── prac03/
    └── prac03.c
```

기존 장 폴더에 있던 소스 3개를 실습 번호별 폴더로 이동했다. 파일명과 소스 내용은 유지했으며, CMake 대상 이름도 기존 등록을 보존했다.

## 파일별 내용

| 파일                               | 내용                                                                  | CMake 대상                        |
|------------------------------------|-----------------------------------------------------------------------|-----------------------------------|
| [prac01/prac01.c](prac01/prac01.c) | 입력한 정수의 하위 16비트를 오른쪽 시프트와 비트 AND로 출력           | `PLS_2026_Chapters_chap06_prac01` |
| [prac02/prac02.c](prac02/prac02.c) | 32767에 1을 더한 `int` 결과와 `short`로 명시적으로 변환한 결과를 비교 | `PLS_2026_Chapters_chap06_prac02` |
| [prac03/prac03.c](prac03/prac03.c) | `short`의 -32768을 `unsigned short`에 대입한 뒤 두 값을 출력          | `PLS_2026_Chapters_chap06_prac03` |

## 코드를 읽을 때 참고할 점

- `prac01`의 `BIT`는 16이다. `int` 전체 크기를 조사하는 코드가 아니라 하위 16비트를 표시한다. 입력은 정수라고 가정하며 `scanf`의 성공 여부는 검사하지 않는다. 음수의 오른쪽 시프트
  결과는 C11에서 구현에 따라 달라질 수 있다.
- `prac02`의 `x + 1`은 정수 승격 후 `int`로 계산된다. 주석의 “오버플로우”는 여기서 `short` 범위를 벗어난 값을 다시 `short`로 변환하는 상황을 가리킨다. 표현할 수 없는 값을 부호
  있는 정수형으로 변환한 결과는 C11에서 구현에 따라 달라지므로 모든 환경에서 -32768이 나온다고 가정하지 않는다.
- `prac03`의 부호 없는 정수형 변환은 해당 형의 범위에 맞춰 이루어진다. 검증 환경의 16비트 `unsigned short`에서는 -32768이 32768로 변환된다. 주석의 정수 범위는 16비트
  `short`를 전제로 한다.

## 빌드와 실행

저장소 루트의 [CMakeLists.txt](../../../CMakeLists.txt)는 C11을 사용한다. Windows용 CMake, Ninja, GCC가 PATH에 등록된 PowerShell에서 저장소 루트를
기준으로 실행한다. 빌드 폴더는 기존 IDE 캐시와 분리한다.

```powershell
$buildDir = Join-Path $env:TEMP ("pls-chap06-" + [guid]::NewGuid().ToString("N"))
cmake -S . -B $buildDir -G Ninja -DCMAKE_C_COMPILER=gcc -DCMAKE_CXX_COMPILER=g++
cmake --build $buildDir --target PLS_2026_Chapters_chap06_prac01 PLS_2026_Chapters_chap06_prac02 PLS_2026_Chapters_chap06_prac03
'5' | & (Join-Path $buildDir 'PLS_2026_Chapters_chap06_prac01.exe')
& (Join-Path $buildDir 'PLS_2026_Chapters_chap06_prac02.exe')
& (Join-Path $buildDir 'PLS_2026_Chapters_chap06_prac03.exe')
```

[상위 장 안내](../README.md)

## 검증 결과

2026-11-12 (한국 시간), Windows 환경에서 검증했다.

- CMake 4.4.4, Ninja 1.13.2, UCRT64 GCC/G++ 14.2.0으로 별도 임시 빌드 폴더에 구성하고 6장 대상 3개를 모두 빌드했다. 구성·빌드 경고와 오류는 없었다. 다른 장의 빌드는
  이번 검증 범위에 포함하지 않았다.
- `prac01`에 0, 5, 32767, 65535, -1을 입력하여 하위 16비트 출력을 확인했다. 5의 출력은 공백을 제외하면 `0000000000000101`이다.
- `prac02`는 `int`의 덧셈 결과 32768과 `short` 변환 결과 -32768을 출력했다.
- `prac03`은 부호 있는 값 -32768과 부호 없는 값 32768을 출력했다.
- 이동 전후 소스 3개의 SHA-256이 일치하며 누락이나 중복 파일이 없다. `PLS_2026` 아래 README 상대 링크 40개가 모두 유효하다.
