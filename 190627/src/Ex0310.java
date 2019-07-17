
public class Ex0310 {

	public static void main(String[] args) {
		// 소수판별
		
		boolean check = isPrimeNum(18);
		System.out.println(check);
		

	}

	private static boolean isPrimeNum(int i) {
		// 
		int count = 0;
		for (int j=1; j<=i; j++ ) {
			if (i%j==0) {
				count++;
			}
			if (count>2) {
				return false;
			}
		}
		if (count==2) {
			return true;
		}
		return false;
	}

}
