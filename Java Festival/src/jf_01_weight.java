import java.util.Scanner;

public class jf_01_weight {

	public static void main(String[] args) {
		/* 현재몸무게와 목표몸무게를 각각 입력 받고
		 * 주차별 감량몸무게를 입력 받아 목표 달성 시 
		 * 축하메세지를 띄우는 프로그램을 구현하시오.
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
