package Ex04_adressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 
		ArrayList<adressbook> adressBook = new ArrayList<>();
			
		// 메뉴구성  [1]추가  [2]검색
		boolean end=false;
		while (!end) {
			Scanner scan = new Scanner(System.in);
			System.out.println("[1]추가  [2]검색  [3]전체조회 [4]종료 : ");
			String menu = scan.next();
			
			
			switch (menu) {
			
			case "1":
				System.out.println("이름 입력 : ");
				String name = scan.next();
				System.out.println("전화번호 입력 : ");
				String phone = scan.next();
				System.out.println("나이 입력 : ");
				int age = scan.nextInt();
				adressBook.add(new adressbook(name, phone, age));
				break;
				
			case "2":
				System.out.println("[1]이름으로 검색  [2]전화번호로 검색 : ");
				System.out.println("검색할 이름을 입력해 주세요 : ");
				int search = scan.nextInt();
				if (search==1) {
					String sName = scan.next();
					int index = searchName(sName, adressBook);
					if (index==-1) {
						System.out.println("주소록에 없는 이름입니다.");
					}
				} else if(search==2) {
					System.out.println("검색할 전화번호를 입력해 주세요 : ");
					String phonenum = scan.next();
					
				} else {
					System.out.println("메뉴 번호를 확인해 주세요.");
				}
				
				break;
				
			case "3":
				showAdressBook(adressBook);
				break;
				
			case "4":
				System.out.println("종료합니다. 감사합니다.");
				end=true;
				break;
				
			default:
				System.out.println("다시 입력해 주세요.");
				break;
			
			
			}
			scan.close();
		}
		
	}


	private static int searchName(String sName, ArrayList<adressbook> adressBook) {
		// 이름을 받아 arrayList에 있는 index를 리턴함
		int len = adressBook.size();
		for (int i=0; i<len; i++) {
			if (adressBook.get(i).getName().equals(sName)) {
				return i;
			}
		}
		
		return -1;
	}


	private static void showAdressBook(ArrayList<adressbook> adressBook) {
		// Show all list
		
		System.out.println("============ 주소록 ============");
		int len = adressBook.size();

		if (len > 0) {
			for (int i = 0; i < len; i++) {
				adressBook.get(i).Status();
			}
		} else {
			System.out.println("목록이 없습니다.");
		}

		System.out.println("===================================");
		System.out.println();
		
	}

}
