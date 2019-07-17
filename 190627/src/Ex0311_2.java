
public class Ex0311_2 {

	public static void main(String[] args) {
		// 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수
		// 완전수를 확인하기
		
		int[] pfNum = new int[5];
		int count = 0;
		int n =0;

		while(count<pfNum.length) {
			n++;
			if (isPerfectNum(n)) {
				pfNum[count]=n;
				System.out.println(count+" "+pfNum[count]);
				count++;
			}
		}
		
	}

	private static boolean isPerfectNum(int i) {
		int sumDiv = getSumDivisibles(i);
		if (sumDiv == i) {
			return true;
		}
		return false;

	}

	public static int getSumDivisibles(int i) {
		// isPerfectNum()
		// isprimeNum()
		int sumDiv = 0;
		for (int j = 1; j < i; j++) {
			if (i % j == 0) {
				sumDiv += j;
				System.out.println(i + "," + j + "," + sumDiv);
			}
		}
		return sumDiv;
	}

}
