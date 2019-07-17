import java.util.Scanner;

public class Ex0309 {

	public static void main(String[] args) {

		// [1]회원가입 [2]로그인
		// * 회원은 3명만 가입가능
		// * 회원 가입시 ID와 PW를 입력받아 저장
		// * 로그인을 하면 ID와 PW를 입력해서 ____님 환영합니다!
		// * 일치하지 않습니다. 다시 확인해 주세요!

		Scanner scan = new Scanner(System.in);
		String[][] joinInUp = new String[3][2];

		String login = "";
		String pass = "";
		Boolean check = false;
		Boolean logout = false;
		Boolean end = false;
		int count = 0;

		while (!end) {
			System.out.println("[1]회원가입 [2]로그인  [3]종료 : ");
			String main = scan.next();
			if (main.equals("1")) {
				if (count > 3) {
					System.out.println("죄송합니다. 더 이상 회원을 받을 수 없습니다.");
				} else {
				System.out.println("회원 가입을 환영합니다.");
				System.out.print("ID를 입력해 주세요 : ");
				joinInUp[count][0] = scan.next();
				System.out.print("암호를 입력해 주세요 : ");
				joinInUp[count][1] = scan.next();
				System.out.println("가입이 되셨습니다.");
				System.out.println();
				count++;
				for (int j = 0; j < count; j++) {
					if (joinInUp[j][0].equals(login)) {
						System.out.println("ID가 이미 등록되었습니다."); 
						break;
					}
				}
				}

			} else if (main.equals("2")) {
				while (!logout) {
					System.out.print("로그인 ID: ");
					login = scan.next();
					System.out.print("Password: ");
					pass = scan.next();

					for (int j = 0; j < joinInUp.length; j++) {
						if (joinInUp[j][0].equals(login)) {
							if (joinInUp[j][1].equals(pass)) {
								check = true;
								break;
							} else {
								check = false;
							}
						}
					}

					if (check) {
						System.out.println("로그인 되었습니다.");
						break;
					} else {
						System.out.println("일치하지 않습니다. 다시 확인해 주세요.");

						while (true) {
							System.out.println("다시 시도하시겠습니까? 예(1) 아니오(다른키)");
							String menu = scan.next();
							if (menu.equals("1")) {
								break;
							} else {
								System.out.println("감사합니다.");
								logout = true;
								break;
							}
						}
					}
				}

			} else if (main.equals("3")) {
				System.out.println("종료합니다.");
				end = true;
				break;

			} else {
				System.out.println("감사합니다!");
				end = true;
				break;
			}

		}

		System.out.println();
		System.out.println();
		scan.close();

	}

}
