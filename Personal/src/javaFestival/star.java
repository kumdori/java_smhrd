package javaFestival;

public class star {

	public static void Box(int row) {

		// 별 상자

		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
	
	public static void stair(int row) {
		
		// 별 사다리 1. 왼쪽에서 오른쪽
		
		
		
	}
	
	
	public static void piramid(int arg1, String arg2) {
		
		// 역 삼각형
		
		int star = arg1;
		String shape = arg2;

		for (int i = 0; i < star; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}

			for (int j = star; j >= i * 2 + 1; j--) {
				System.out.print(shape);
			}
			System.out.println();
		}
		
	}
	
	
	public static void diamond(int arg1, String arg2) {

		// 별 다이아몬드
		int star = arg1;
		String shape = arg2;

		for (int i = 0, j = 0; i < star*2-1; i++) {
			for (int k = 0; k < j + star; k++) {
				System.out.print((k < (star-1-j)) ? " " : shape);
			}

			if (i < star-1) {
				j++;
			} else {
				j--;
			}
			System.out.println();

		}
	}
}
