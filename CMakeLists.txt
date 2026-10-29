cmake_minimum_required(VERSION 3.20)
project(ProgrammingLanguageStructure LANGUAGES C CXX)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)
set(CMAKE_C_EXTENSIONS OFF)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

# Each exercise has its own main(), so build it as a separate executable.
set(CHAPTERS "${CMAKE_CURRENT_SOURCE_DIR}/PLS_2026/Chapters")

add_executable(PLS_2026_Chapters_chap04_prac01_03 "${CHAPTERS}/chap04/prac01-03.c")
add_executable(PLS_2026_Chapters_chap04_prac08 "${CHAPTERS}/chap04/prac08.c")
add_executable(PLS_2026_Chapters_chap04_prac09 "${CHAPTERS}/chap04/prac09.c")
add_executable(PLS_2026_Chapters_chap04_prac_p23 "${CHAPTERS}/chap04/prac_p23.c")
add_executable(PLS_2026_Chapters_chap04_prac_p33 "${CHAPTERS}/chap04/prac_p33.cpp")
add_executable(PLS_2026_Chapters_chap04_prac_p34 "${CHAPTERS}/chap04/prac_p34.cpp")
add_executable(PLS_2026_Chapters_chap04_prac_p36 "${CHAPTERS}/chap04/prac_p36.cpp")
add_executable(PLS_2026_Chapters_chap05_prac01 "${CHAPTERS}/chap05/prac01.c")

add_executable(PLS_2026_Chapters_chap05_prac4_c PLS_2026/Chapters/chap05/prac4.c)
add_executable(PLS_2026_Chapters_chap05_prac5 PLS_2026/Chapters/chap05/prac5.c)