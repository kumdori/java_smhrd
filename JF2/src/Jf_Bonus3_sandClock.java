import java.util.Scanner;

public class Jf_Bonus3_sandClock {

	public static void main(String[] args) {
		// 모래시계.

		Scanner scan = new Scanner(System.in);
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		System.out.print("행 개수 : ");
		int row = (scan.nextInt()+1)/2;
		int star = 4;
		int count = 0;
		System.out.println("Row : "+row+","+star);
		


		for (int i = 0, j = 0; i < star*2-1; i++) {

			for (int k = 0; k < star*2-1-j; k++) {
				
				System.out.print((k < j)? " " : alphabet[count]);
				count+=k<j?0:1;

			}

			if (i < star-1) {

				j++;

			} else {

				j--;

			}

			System.out.println();

		}
		System.out.println("Count: "+count);
		scan.close();

	}

}
