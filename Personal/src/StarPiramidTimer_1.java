
public class StarPiramidTimer_1 {

	public static void main(String[] args) {
		// Piramid 위로

		int star = 4;

		for (int i = 0; i < star; i++) {

			for (int j = 0; j < star + i; j++) {

				System.out.print((j < (star - 1 - i)) ? " " : "*");

			}

			System.out.println();

		}

	}

}
