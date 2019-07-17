import java.util.Scanner;

public class Ex0309_ssem {

	public static void main(String[] args) {
		// [1]회원가입 [2]로그인
		// * 회원은 3명만 가입가능
		// * 회원 가입시 ID와 PW를 입력받아 저장
		// * 로그인을 하면 ID와 PW를 입력해서 ____님 환영합니다!
		// * 일치하지 않습니다. 다시 확인해 주세요!

		Scanner scan = new Scanner(System.in);
		Boolean isRunning = true;

		while (isRunning) {
			System.out.println("[1]회원가입 [2]로그인 [3]종료 >>");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				String[][] members = new String[3][2];
				int index = 0;
				join(members, index);
				index++;
				break;
			case 2:
				String id = login(members);
				if (id != null) {
					System.out.println(id + "님 환영합니다.");
				} else {
					System.out.println("일치하는 데이터가 없습니다...");
				}
				break;
			case 3:
				System.out.println("종료합니다. 감사합니다.");
				isRunning = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다...");
			}

		}
		scan.close();

	}

	private static String login(String[][] members) {
		// 로그인 관리
		Scanner scan = new Scanner(System.in);
		System.out.println("ID >> ");
		String id = scan.next();
		System.out.println("PW >> ");
		String pw = scan.next();

		for (int i = 0; i < members.length; i++) {
			if (members[i][0].equals(id) && members[i][1].equals(pw)) {
				return members[i][0];
			}
		}
		scan.close();
		return null;
	}

	private static void join(String[][] members, int index) {
		// 회원 가입 관리

		Scanner scan = new Scanner(System.in);
		System.out.println("ID >> ");
		String id = scan.next();
		System.out.println("PW >> ");
		String pw = scan.next();

		members[index] = new String[] { id, pw };

	}

}
