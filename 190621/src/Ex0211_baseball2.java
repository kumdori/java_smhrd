import java.util.Random;
import java.util.Scanner;

public class Ex0211_baseball2 {

	public static void main(String[] args) {
		// Step 1. 중복없이 숫자 3개 뽑기 (1~5)
		// Step 2. strike와 ball 개수 세기
		
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		
		// 변수 초기화
		int r = 5;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int unum1 = 0;
		int unum2 = 0;
		int unum3 = 0;
		int strike = 0;
		int ball = 0;
		
		//랜덤 수 구하기
		
		
		while (true) {
			num1 = rand.nextInt(r)+1;
			num2 = rand.nextInt(r)+1;
			num3 = rand.nextInt(r)+1;
			if (num1!=num2 && num2!=num3 && num3!=num1) {
				break;
				}
		}
	//	System.out.println(num1);
	//	System.out.println(num2);
	//	System.out.println(num3);
	 	while (true) {
	 	// 사용자 번호 입력 받기
			System.out.println("첫번째 번호: ");
			unum1 = scan.nextInt();
			System.out.println("두번째 번호: ");
			unum2 = scan.nextInt();
			System.out.println("세번째 번호: ");
			unum3 = scan.nextInt();
			
			//체크
			if (unum1==num1) {
				strike++;
			} else if (unum1==num2 || unum1==num3) {
				ball++;
			}
			if (unum2==num2) {
				strike++;
			} else if (unum2==num1 || unum2==num3) {
				ball++;
			}
			if (unum3==num3) {
				strike++;
			} else if (unum3==num2 || unum3==num1) {
				ball++;
			}
			if (strike==0 && ball==0) {
				System.out.println("Out!");
			} else if (strike==3) {
				System.out.println("축하합니다!");
				break;
			} else {
			System.out.println("Strike: "+strike);
			System.out.println("Ball: "+ball);
			}

		}
		scan.close();
	}

}
