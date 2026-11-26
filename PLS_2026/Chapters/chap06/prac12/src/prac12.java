import java.util.Scanner;
public class prac12 {
	public static void main(String[] args) {
		final int COUNT = 5;

		System.out.print(COUNT + " 개의 정수를 입력하세요 : ");
		Scanner in = new Scanner(System.in);
		int score[] = new int[COUNT];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			score[i] = in.nextInt();
			sum += score[i];
		}

		System.out.print("list : ");

		for (int i = 0; i < 5; i++)
			System.out.print(score[i] + " ");

		float avg = (float)sum / COUNT;
		System.out.print("\nsum = " + sum + ", avg = " + avg);
	}
}