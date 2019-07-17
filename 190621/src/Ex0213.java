
public class Ex0213 {

	public static void main(String[] args) {
		// 3~100까지 3의 배수
		
		for (int i=3; i<101; i++) {
			if (i%3==0) {
				System.out.print(i+" ");
			}
		}
		System.out.println("");
		
		
		
		
		// 57~11까지 출력
		int b=57;
		for (int a=b;a>10;a--) {
			System.out.print(a+" ");
		}
		System.out.println("");
		System.out.println("");
		
		
		
		
		// 1 -2 3 -4 5 -6 ... -10
		int sign = 1;
		
		for (int i=-1; i>-11; i--) {
			sign*=-1; //i-- 뒤에 ','로 이어서 연산식를 여러개 넣을 수 있음.
			System.out.print(i*sign+" ");
		}
		System.out.println("");
		
		
		
	}

}
