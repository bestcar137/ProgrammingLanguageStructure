import java.util.Scanner;

public class HW04_SOL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수식을 입력하세요 (예: 2+3*4-6/2): ");
        String expr = sc.nextLine();

        String number = "";
        int result = 0;
        Integer term = null;
        char sign = '+';
        char op = 0;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                number += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!number.isEmpty()) {
                    int n = Integer.parseInt(number);
                    if (term == null) term = n;
                    else if (op == '*') term *= n;
                    else if (op == '/') term /= n;
                    else term = n;
                    number = "";
                }

                if (c == '*' || c == '/') {
                    op = c;
                } else {
                    if (term != null) {
                        result += (sign == '+') ? term : -term;
                        term = null;
                    }
                    sign = c;
                    op = 0;
                }
            } else {
                if (!number.isEmpty()) {
                    int n = Integer.parseInt(number);
                    if (term == null) term = n;
                    else if (op == '*') term *= n;
                    else if (op == '/') term /= n;
                    else term = n;
                    number = "";
                }
                System.out.println("ERROR: invaLid token -> " + c);
            }
        }

        if (!number.isEmpty()) {
            int n = Integer.parseInt(number);
            if (term == null) term = n;
            else if (op == '*') term *= n;
            else if (op == '/') term /= n;
            else term = n;
        }
        if (term != null) result += (sign == '+') ? term : -term;

        System.out.println("결과: " + result);
        sc.close();
    }
}
