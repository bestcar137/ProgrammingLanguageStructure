
public class Main {
    static int x = 10;

    public static int func() {
        x = 20;
        return 30;
    }

    public static void main(String[] args) {
        System.out.println("x + func() = " + (x + func()));
        System.out.println("func() + x = " + (func() + x));
    }
}
