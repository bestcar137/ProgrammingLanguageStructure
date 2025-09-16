import java.util.Scanner;

public class HW01_SOL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수식을 입력하세요 (예: 12+3*4): ");
        String expr = sc.nextLine();

        String number = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                number += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
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
