
public class Ex0217_3 {

	public static void main(String[] args) {
		// *****
		//  ****
		//   ***
		//    **
		//	   *
		
		int j;

		for (int i = 0; i < 5; i++) {
			for (j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 5-j; k++) {
			    System.out.print("*");
			}
			System.out.println();
		}

	}

}
