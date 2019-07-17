import java.util.Scanner;

public class Ex0208 {

	public static void main(String[] args) {
		/* 가위바위보 게임입니다.
		 * user1과 user2의 이름을 입력받아 가위바위보 게임을 진행해 주세요.
		 * 
		*/
		
		Scanner scan = new Scanner(System.in);
		
		//user입력
		System.out.print("user1 : ");  // 문자열 입력
		String user1 = scan.next();
		System.out.print("user2 : ");
		String user2 = scan.next();
		String result = "";

		//가위바위보 입력
		System.out.print(user1 + "님 : ");
		String rsp1 = scan.next();
		System.out.print(user2 + "님 : ");
		String rsp2 = scan.next();
		
		// 게임 결과 계산
		// 문자열 비교 : a.equals(b)
		
		if (rsp1.contentEquals(rsp2)) {
			result = "무승부 입니다.";
		} else if (rsp1.contentEquals("가위") && rsp2.contentEquals("보")) {
			result = user1 + "님의 승리입니다.";
		} else if (rsp1.contentEquals("바위") && rsp2.contentEquals("가위")) {
			result = user1 + "님의 승리입니다.";
		} else if (rsp1.contentEquals("보") && rsp2.contentEquals("바위")) {
			result = user1 + "님의 승리입니다.";
		} else {
			result = user2 + "님의 승리입니다.";
		}
		
		//결과 출력
		System.out.println(result);
	}

}
