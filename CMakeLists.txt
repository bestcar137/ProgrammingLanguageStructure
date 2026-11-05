cmake_minimum_required(VERSION 3.20)
project(ProgrammingLanguageStructure LANGUAGES C CXX)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)
set(CMAKE_C_EXTENSIONS OFF)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

# 실습마다 독립된 실행 파일을 만든다.
function(add_exercise chapter target source)
    add_executable(PLS_2026_Chapters_${chapter}_${target}
            ${ARGN}
            "PLS_2026/Chapters/${chapter}/${source}"
    )
endfunction()

# 4장
add_exercise(chap04 prac01_03 prac01-03.c)
add_exercise(chap04 prac08 prac08.c)
add_exercise(chap04 prac09 prac09.c)
add_exercise(chap04 prac_p23 prac_p23.c)
add_exercise(chap04 prac_p33 prac_p33.cpp)
add_exercise(chap04 prac_p34 prac_p34.cpp)
add_exercise(chap04 prac_p36 prac_p36.cpp)

# 5장
add_exercise(chap05 prac01 prac01/prac01.c)
add_exercise(chap05 prac4_c prac04/prac4.c)

add_exercise(chap05 prac5 prac05/prac5.c)
add_exercise(chap05 prac05_prac5_1 prac05/prac5_1.c)

add_exercise(chap05 prac6 prac06/prac6.cpp)
add_exercise(chap05 prac6_1 prac06/prac6_1.cpp)
add_exercise(chap05 prac6_C_for prac06/prac6_C_for.c)
add_exercise(chap05 prac6_C_while prac06/prac6_C_while.c)

# GCC에서 빌드하려면 두 소스의 void main()을 int main()으로 수정해야 한다.
add_exercise(chap05 prac7 prac07/prac7.cpp EXCLUDE_FROM_ALL)
add_exercise(chap05 prac7_1 prac07/prac7_1.cpp EXCLUDE_FROM_ALL)

add_exercise(chap05 prac8 prac08/prac8.c)
add_exercise(chap05 prac8_while prac08/prac8_while.c)

add_exercise(chap05 prac9 prac09/prac9.c)
add_exercise(chap05 prac9_if prac09/prac9_if.c)

add_exercise(chap05 prac10_prac10_C_if prac10/prac10_C_if.c)
add_exercise(chap05 prac10_prac10_C_switch_case prac10/prac10_C_switch_case.c)
