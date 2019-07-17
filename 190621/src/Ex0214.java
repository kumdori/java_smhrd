import java.util.Scanner;

public class Ex0214 {

	public static void main(String[] args) {
		// 숫자(n)를 하나 입력받아서 1~n까지 출력. 짝수는 음수로.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("마지막 숫자를 입력해 주세요 : ");
		int num = scan.nextInt();
		
		int sign = 1;
		
		for (int i=-1; i>=-num; i--) {
			sign*=-1; //swich 변수. i-- 뒤에 ','로 이어서 연산식를 여러개 넣을 수 있음.
			System.out.print(i*sign+" ");
		}
		System.out.println("");
		scan.close();

	}

}
