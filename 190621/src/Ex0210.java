import java.util.Scanner;

public class Ex0210 {

	public static void main(String[] args) {
		/* 2-1 다이어트 관리 프로그램
		 * 1. 현재 몸무게와 목표 몸무게를 입력 받고 주차 별 감량 몸무게를 입력 받으세요.
		 * 2. 목표 몸무게를 달성하면 축하한다는 문구를 출력하고 입력을 멈추세요.
		 * 화면예)
		 * 현재 몸무게: 80
		 * 목표 몸무게: 70
		 * 1주차 감량 몸무게: 2
		 * 2주차 감량 몸무게: 3
		 * 3주차 감량 몸무게: 4
		 * 4주차 감량 몸무게: 5
		 * 66kg 달성!! 축하합니다! 
		 * 
		*/
		
		int actWeight = 0;
		int objWeight = 0;
		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("현재 몸무게: ");
		actWeight = scan.nextInt();
		while (true) {
			System.out.print("목표 몸무게: ");
			objWeight = scan.nextInt();
			if (actWeight>objWeight) {
				break;
			} else {
				System.out.println("목표 몸무게가 더 높습니다. 다시 입력해 주세요.");
			}
		}
		
		while (actWeight > objWeight) {
			count += 1;
			System.out.print(count + "주차 감량 몸무게: ");
			int lossWeight = scan.nextInt();
			actWeight-=lossWeight;
		}
		System.out.println(actWeight+"kg 달성!! 축하합니다.");
		scan.close();

	}

}
