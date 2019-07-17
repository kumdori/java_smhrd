import java.util.Scanner;

public class Star1_to_4 {

	public static void main(String[] args) {
		// ★ 1~n까지의 총합 출력하기
		// ★★ Base와 n을 입력받아서 Base의 n제곱 출력하기
		// ★★★ n을 입력받아서 모든 약수 출력
		// ★★★★ n을 입력받아서 소수 판별 '소수입니다'
		
		Scanner scan = new Scanner(System.in);
		
		/*
		// ★ 1~n까지의 총합 출력하기
		System.out.println("마지막 숫자를 입력해 주세요 : ");
		int n1 = scan.nextInt();
		int total1 = 0;
		for (int i=1; i<=n1; i++) {
			total1+=i;
		}
		System.out.println("총합은 "+total1+"입니다.");
		
		
		// ★★ Base와 n을 입력받아서 Base의 n제곱 출력하기
		System.out.print("Base를 입력해 주세요 : ");
		int base = scan.nextInt();
		System.out.print("n을 입력해 주세요 : ");
		int pwr = scan.nextInt();
		int result = 1;
		for (int i=1; i<=pwr; i++) {
			result*=base;
			}	
		System.out.println("결과는 "+result+"입니다.");
		
		
		// ★★★ n을 입력받아서 모든 약수 출력
		System.out.print("n을 입력해 주세요 : ");
		int n2 = scan.nextInt();
		int count = 0;
		System.out.println(n2+"의 약수 : ");
		for (int i=1; i<=n2; i++ ) {
			if (n2%i==0) {
				System.out.print(i+" ");
			}
		}
		*/
		
		// ★★★★ n을 입력받아서 소수 판별 '소수입니다'
		System.out.print("n을 입력해 주세요 : ");
		int n3 = scan.nextInt();
		int count = 0;
		for (int i=1; i<=n3; i++ ) {
			if (n3%i==0) {
				count++;
			}
		}
		if (count==2) {
			System.out.println(n3+"는 소수입니다.");
		}
		else {
			System.out.println(n3+"는 소수가 아닙니다.");
			}

	}

}
