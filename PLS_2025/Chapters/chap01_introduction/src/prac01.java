/// 프로그래밍 언어구조론 제 2장
/// 재귀 하강 파싱(recursive-descent parsing), p36~

/*
import java.util.*;
import java.io.*;


public class prac01 {


    main() {
        parse();
        return 0;
    }

    void command(void) {
        int result = expr();
        if (token == '\n')
            System.out.println("The result is : "+ result + "\n");
        else error();
    }

    void parse(void) {
            token = new getToken();
        command();
    }

    void expr(void) {
        term();
        while (token == '+') {
            match('+');
            term();
        }
    }

    void match(int c) {
        /// 현재 토큰 확인 후 다음 토큰 읽기
        if (token == c)
            token = getToken();
        else error();
    }

    int getToken() {
        /// 다음 토큰(수 혹은 문자)을 읽어서 리턴
        while (true) {
            try {
                ch = input.read();
                if (ch == ' ' || ch == '\t' || ch == '\r') ;
                else if (Character.isDigit(ch)) {
                    value = number();
                    input.unread(ch);
                    return NUMBER;
                } else return ch;
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    int expr(void) {    // 수식 값 계산
        int result = term();
        while (token == '+') {
            match('+');
            result += term();
        }
        return result;
    }

    int term(void) {    // 항의 값 계산
        int result = factor();
        while (token == '*') {
            match('*');
            result *= factor();
        }
        return result;
    }

        int term(void) {    // 항의 값 계산
        int result = factor();
        while (token == '-') {
            match('-');
            result -= factor();
        }
        return result;
    }


        int term(void) {    // 항의 값 계산
        int result = factor();
        while (token == '/') {
            match('/');
            result /= factor();
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
*/

/*  36p

 파싱
입력 스트링을 유도하여 문법에 맞는지 검사

 파서
입력 스트링을 유도하여 문법에 맞는지 검사하는 프로그램

 재귀 하강 파서의 기본 원리
입력 스트링을 좌측 유도 (leftmost derivation 하도록
문법으로부터 직접 파서 프로그램을 만든다

 */

/// 38p, 예제
///  수식을 재귀 하강 파싱
///  <command> → <expr> '\n’

public class prac01 {
/*
// TODO: command, expr, error, token 처리하기
void command(void) {
    int result = expr();
    if (token == '\n')
        System.out.println("The result is: "+ result);
    else error();
}

// TODO: parse, token 처리
void parse(void) {
    token = getToken();
    command();
}

main() {
    parse();
    return 0;
}

/// 39, 예제
/// <expr> -> <term> {+<term>}

void expr(void) {
    term();
    while (token =='+') {
        match('+');
        term();
    }
}

void match(int c) {
    if (token == c)
        token = getToken();
    else error();
}


// 어휘분석기 getToken()

int getToken() {
    while (true) {
        try {
            ch = input.read();
            if (ch == ' ' || ch == '\t' || ch == '\r') ;
            else if (Character.isDigit(ch)) {
                value = number();
                input.unread(ch);
                return NUMBER;
            } else return ch;
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

void main() {
}}*/
}