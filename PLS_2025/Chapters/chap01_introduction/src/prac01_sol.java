/*
import java.io.*;   // PushbackReader, InputStreamReader, IOException

public class sol {

    // === 전역 상태 (슬라이드 p.40 전제) ===
    static int token;              // 현재 토큰
    static int value;              // NUMBER 토큰의 실제 값
    static int ch;                 // 최근에 읽은 문자 (number()와 getToken()이 공유)
    static PushbackReader input;   // 되읽기 가능한 입력
    static final int NUMBER = 256; // 숫자 토큰 식별용 임의 상수

    // === 프로그램 시작점 (p.38 main/parse 흐름) ===
    public static void main(String[] args) throws IOException {
        input = new PushbackReader(new InputStreamReader(System.in));
        parse(); // p.38: main(){ parse(); return 0; }에 해당 :contentReference[oaicite:4]{index=4}
    }

    static void parse() throws IOException {
        token = getToken(); // p.38: parse(){ token = getToken(); command(); } :contentReference[oaicite:5]{index=5}
        command();
    }

    // <command> → <expr> '\n' (p.38)
    static void command() throws IOException {
        int result = expr(); // 계산 버전(p.41) 사용 :contentReference[oaicite:6]{index=6}
        if (token == '\n') {
            System.out.printf("The result is: %d\n", result); // p.38의 printf 대응 :contentReference[oaicite:7]{index=7}
        } else {
            error();
        }
    }

    // <expr> → <term> { + <term> }  (파싱+계산, p.41)
    static int expr() throws IOException {
        int result = term();
        while (token == '+') {
            match('+');
            result += term();
        }
        return result;
    }

    // <term> → <factor> { * <factor> } (파싱+계산, p.42)
    static int term() throws IOException {
        int result = factor();
        while (token == '*') {
            match('*');
            result *= factor();
        }
        return result;
    }

    // <factor> → <number> | '(' <expr> ')' (p.43)
    static int factor() throws IOException {
        if (token == NUMBER) {           // 숫자
            int result = value;
            token = getToken();
            return result;
        } else if (token == '(') {       // 괄호식
            match('(');
            int result = expr();
            match(')');
            return result;
        } else {
            error();
            return 0; // 도달하지 않음
        }
    }

    // p.39 match: 현재 토큰 확인 후 다음 토큰 읽기
    static void match(int c) throws IOException {
        if (token == c) {
            token = getToken();
        } else {
            error();
        }
    }

    // p.40 어휘분석기: 공백/탭/\r 스킵, 숫자면 number(), 아니면 문자 그대로 반환
    static int getToken() throws IOException {
        while (true) {
            ch = input.read();
            if (ch == -1) return '\n';            // 입력 종료 시 줄끝 취급(편의)
            if (ch == ' ' || ch == '\t' || ch == '\r') {
                continue;                         // 공백류 스킵
            } else if (Character.isDigit(ch)) {
                value = number();                 // 연속 숫자 읽어 value 설정
                input.unread(ch);                 // 숫자 아닌 첫 문자 되밀기
                return NUMBER;                    // 숫자 토큰 반환
            } else {
                return ch;                        // '+', '*', '(', ')', '\n' 등
            }
        }
    }

    // p.43 <number> → <digit>{<digit>} : 연속 자리수를 정수로
    static int number() throws IOException {
        int result = 0;
        do {
            result = result * 10 + (ch - '0');
            ch = input.read();
        } while (Character.isDigit(ch));
        return result; // 여기서 ch는 "숫자가 아닌 첫 문자"
    }

    static void error() {
        throw new RuntimeException("Syntax error, token=" + token);
    }
}
*/
