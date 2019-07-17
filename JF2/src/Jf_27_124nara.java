
public class Jf_27_124nara {

	public static void main(String[] args) {
		/* 1, 2, 4 세 개의 숫자만 쓰는 124나라가 있습니다.
		 * 124나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
		 * 10진법의 1 → 1
		 * 10진법의 2 → 2
		 * 10진법의 3 → 4
		 * 10진법의 4 → 11
		 * 10진법의 5 → 12
		 * 10진법의 6 → 14
		 * 
		 * change124()  메소드에 십진수 숫자를 넣으면
		 * 124 나라 숫자로 바꾸는 프로그램을 작성하시오.
		 */
		
		System.out.println(change124(39));
		

	}

	private static String change124(int n) {
		// change124(int i);
		// 
		
		String ans="";
		
		while (n>3) {
			System.out.println(n+","+ans);
			
			if (n%3==1) {
				ans+="1";
				n=n/3;
			} else if (n%3==2) {
				ans+="2";
				n=n/3;
			} else {
				ans+="4";
				n=(n-3)/3;
			}
		}
		
		if (n%3==1) {
			ans+="1";
		} else if (n%3==2) {
			ans+="2";
		} else {
			ans+="4";
		}
		return ans;
	}

}





