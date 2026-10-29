/* 문제 1. 하나의 수식을 입력받아, 문자열을 한 글자씩 읽어가며
 숫자와 연산자를 구분해서 출력하는 프로그램을 작성하시오.
 숫자는 연속된 자리수를 합쳐 하나의 숫자로 처리하고,
 연산자는 +, -, *, / 네 가지만 인식하도록 처리하시오.*/

public class HW01 {

    enum Token {
        NUMBER(""), PLUS("+"), MINUS("-"),
        MULTIPLY("*"), DIVIDE("/"), EOF("");
        private String value;

        private Token(String v) {
            value = v;
        }

        public String value() {
            return value;
        }
    }

    ;
    public static class Lexer {
        //TODO: ...안에 작성
        private String s;
        private int i = 0;
        private String lastToken = "";

        public Lexer(String s) {
            this.s = (s == null) ? "" : s;}


        }


    public static void main(String[] args) {
        System.out.println("수식을 입력하세요 (예: 12+3*4): ");
    }
}