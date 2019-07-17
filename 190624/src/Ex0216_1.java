
public class Ex0216_1 {

	public static void main(String[] args) {
		// 3-5 for문 예제
		// 구구단 2단~9단까지 출력하세요.
		
		for (int i=2; i<10; i++) {
			System.out.println("=="+i+"단==");
			for (int j=1; j<10; j++) {
				System.out.println(i+"x"+j+"="+i*j);
			}
			System.out.println("");
		}
		

	}

}
