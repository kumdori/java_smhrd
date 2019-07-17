import java.util.Scanner;

public class Ex0104 {

	public static void main(String[] args) {
		// 더치페이 계산기
		// 전체 금액과 인원수를 입력하면 한명당 얼마 내야 하는지 출력
		Scanner scan = new Scanner(System.in);
		System.out.print("전체 금액은 얼마인가요? ");
		int total = scan.nextInt();
		System.out.print("전체 인원은 몇 명인가요? ");
		int people = scan.nextInt();
		
		System.out.println("각자 "+ total/people +"씩 내세요.^^");
		scan.close();
		
	}

}
