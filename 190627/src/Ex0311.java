
public class Ex0311 {

	public static void main(String[] args) {
		// 자기 자신을 제외한 약수의 합이 자기 자신과 같은 수
		// 완전수를 확인하기
		int n = 0;
		int count = 0;
		
		while(count<6) {
			n++;
		boolean check = isPerfectNum(n);
		if (check) {
		System.out.println(n+" "+check);
		count++;
		}
		}
		

	}

	private static boolean isPerfectNum(int i) {
		// isPerfectNum()
		int sumDiv = 0;
		for (int j=1; j<i; j++ ) {
			if (i%j==0) {
				sumDiv+=j;
//				System.out.println(i+","+j+","+sumDiv);
			}
			if (sumDiv>i) {
				return false;
			}
		}
		if (sumDiv==i) {
			return true;
		}
		return false;

	}

}
