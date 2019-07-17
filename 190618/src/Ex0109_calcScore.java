import java.util.Scanner;

public class Ex0109_calcScore {

	public static void main(String[] args) {
		// 성적계산기
		// 국어, 영어, 수학 점수를 입력받아서
		// 총합과 평균(소수점까지)을 출력
		
		Scanner scan = new Scanner(System.in);
		System.out.println("**************");
		System.out.println("성적 계산기");
		System.out.println("**************");
		System.out.print("국어: ");
		int lang = scan.nextInt();
		System.out.print("영어: ");
		int engl = scan.nextInt();
		System.out.print("수학: ");
		int math = scan.nextInt();
		int total = lang + engl + math;
		double totalmean = total/3.0;
		System.out.println("**************");
		System.out.println("총합 : " + total);
		System.out.print("평균 : ");
		
		// 소수점 xx 자리까지 출력하기
		// 1. printf
		System.out.printf("%.2f", totalmean);
		System.out.println("");
		// 2. strDouble
		String strDouble = String.format("%.2f", totalmean);
		System.out.println("strDouble 방법: " + strDouble);
		// 3. 형변환
		int totalf = (int)(totalmean*100);
		//System.out.println(totalmean);
		//System.out.println(totalf);
		System.out.println("형변화 방법 : " + totalf/100.0);
		// 4. Math.round
		System.out.print("math.round 방법");
		System.out.println(Math.round(totalmean*100)/100.0);
		scan.close();

	}

}
