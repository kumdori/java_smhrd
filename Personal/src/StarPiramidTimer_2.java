
public class StarPiramidTimer_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int star = 5;

		for (int i = 0; i < star; i++) {

			for (int j = 0; j < star*2-1-i; j++) {

				System.out.print((j < i)? " " : "*");

			}

			System.out.println();

		}

	}

}
