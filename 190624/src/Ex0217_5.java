
public class Ex0217_5 {

	public static void main(String[] args) {
		//     *
		//    ***
		//   *****
		//  *******
		// *********

		int j;

		for (int i = 5; i > 0; i--) {
			for (j = 0; j < i-1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 5-j; k++) {
			    System.out.print("*");
			}
			for (int k = 0; k < 5-j-1; k++) {
			    System.out.print("*");
			}
			System.out.println();
		}

	}

}
