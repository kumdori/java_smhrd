import java.util.Scanner;

public class StarPiramid_timer {

	public static void main(String[] args) {
		// 행 개수를 입력 받아 역피라밋 모양을 출력하시오.

		Scanner scan = new Scanner(System.in);
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		System.out.print("행 개수 : ");
		int row = (scan.nextInt()+1)/2;
		int star = 4;
		int count=0;
		System.out.println("Row : "+row+","+star);
		


		for (int i = 0, j = 0; i < star*2-1; i++) {
			for (int k = 0; k < j + star; k++) {
				if (k < (star-1-j)) {
					System.out.print(" ");
				} else {
					System.out.print(alphabet.charAt(count++));
				}

			}
			if (i < star-1) {
				j++;
			} else {
				j--;
			}
			System.out.println();
		}
		scan.close();
	}

}
