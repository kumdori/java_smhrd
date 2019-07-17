import java.util.Scanner;

public class Ex0208_srp2 {

	public static void main(String[] args) {
		/* 가위바위보 게임입니다.
		 * user1과 user2의 이름을 입력받아 가위바위보 게임을 진행해 주세요.
		 * 3번 이기면 게임 끝.
		*/
		
		Scanner scan = new Scanner(System.in);

		//user입력
		System.out.print("user1 : ");  // 문자열 입력
		String user1 = scan.next();
		System.out.print("user2 : ");
		String user2 = scan.next();
		String result = "";

		//변수
		boolean count = false;
		int user1Win = 0;
		int user2Win = 0;
		
		while (count==false) {
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
				user1Win += 1;
				result = user1 + "님이" + user1Win + "번 이겼습니다.";
			} else if (rsp1.contentEquals("바위") && rsp2.contentEquals("가위")) {
				user1Win += 1;
				result = user1 + "님이" + user1Win + "번 이겼습니다.";
			} else if (rsp1.contentEquals("보") && rsp2.contentEquals("바위")) {
				user1Win += 1;
				result = user1 + "님이" + user1Win + "번 이겼습니다.";
			} else {
				user2Win += 1;
				result = user2 + "님이" + user2Win + "번 이겼습니다.";
			}
			if (user1Win>=3 || user2Win>=3) {
				count=true;
			}
			
			//결과 출력
			System.out.println(result);
		}
		System.out.println("게임 종료.");				
	}

}
