import java.util.Scanner;

public class HW02_SOL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수식을 입력하세요 (예:   10 + 20 * 3  ): ");
        String expr = sc.nextLine();

        String number = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                number += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {

                // TODO: 공백 무시 추가
                if (!number.isEmpty()) {
                    System.out.println("NUMBER: " + number);
                    number = "";
                }
                System.out.println("OP: " + c);
            }
        }
        if (!number.isEmpty()) {
            System.out.println("NUMBER: " + number);
        }
        sc.close();
    }
}
