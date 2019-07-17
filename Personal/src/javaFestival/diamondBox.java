package javaFestival;

import java.util.Scanner;

public class diamondBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		int result = 1;
		int plu = 1;
		System.out.print("홀수만 입력 : ");
		int n = scan.nextInt();
		int[][] array = new int[n][n];

		int m = n / 2;
//		int l = m;
		for (int i = 0; i < array.length; i++) {
			if (i <= m) {
				for (int j = m - i; j <= m + i; j++) {
					array[i][j] = plu++;
				}
			} else {
				for (int j = i - m; j <= m * 3 - i; j++) {
					array[i][j] = plu++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[j][i] + "\t");
			}
			System.out.println();
		}
		scan.close();

	}
	

}
