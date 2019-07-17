package Ex02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Menu [1]저금  [2]인출  [3]조회 [4]종료
		
		
		boolean end = false;
		piggyBank client1 = new piggyBank();
		
		while(!end) {
			Scanner scan = new Scanner(System.in);
			System.out.println("[1]저금  [2]인출  [3]조회 [4]종료 : ");
			String mainmenu = scan.next(); 
			
			switch (mainmenu) {
			case "1":
				System.out.println("입급할 금액은? ");
				int svQty = scan.nextInt();
				client1.save(svQty);
				break;
			
			case "2":
				System.out.println("인출할 금액은? ");
				int wdQty = scan.nextInt();
				int savings = client1.current();
				if (wdQty>savings) {
					System.out.println("잔금이 충분하지 않습니다.");
				} else {
					client1.withdraw(wdQty);
				}
				break;
			case "3":
				System.out.println(client1.current());
				break;
			case "4":
				System.out.println("감사합니다.");
				end=true;
				break;
			default:
				System.out.println("다시 입력해 주세요.");
			
			
			}
			scan.close();
			
		}
		

	}

}
