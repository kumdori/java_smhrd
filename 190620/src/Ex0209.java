import java.util.Random;
import java.util.Scanner;

public class Ex0209 {

	public static void main(String[] args) {
		/* 1. 컴퓨터가 랜덤수를 하나 생성 1~99
		 *    Random rd = new Random();
		 * 2. 사용자는 숫자 입력
		 * 2-1. 컴퓨터가 생각한 숫자보다 입력한 숫자가 더 크면 down.
		 * 2-2. 컴퓨터가 생각한 숫자보다 입력한 숫자가 더 크면 up.
		 * 3. 맞추면 종료!
		 */
 
		//랜덤 숫자 생성
		Random rd = new Random();
		int computer = rd.nextInt(99)+1;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//사용자 숫자 입력
			System.out.print("정수를 입력하세요 : ");
			int user = scan.nextInt();
			
			//컴퓨터와 사용자 숫자 비교
			if (computer==user) {
				System.out.println("맞췄습니다.");
				break;
			} else if (computer>user) {
				System.out.println("Up!");
			} else {
				System.out.println("Down!");
			}
			count+=1;
		}
		System.out.println(count + "번만에 맞췄습니다.");
		scan.close();
	}

}
