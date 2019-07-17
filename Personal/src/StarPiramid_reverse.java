import java.util.Scanner;

public class StarPiramid_reverse {

	public static void main(String[] args) {
		// 행 개수를 입력 받아 역피라밋 모양을 출력하시오.

		Scanner scan = new Scanner(System.in);
		System.out.print("행 개수 : ");
		int row = scan.nextInt();
		int star = 5;

		for (int i = 0; i < row; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}

			for (int j = star; j >= i * 2 + 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		scan.close();

	}

}
