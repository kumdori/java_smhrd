package jdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
		// 
		
		Scanner scan = new Scanner(System.in);
		PhoneDAO dao = new PhoneDAO();
		PhoneDTO dto = new PhoneDTO();
		ArrayList<PhoneDTO> dtoList = new ArrayList<PhoneDTO>();
		boolean end=false;

		dao.getCon();

		
		while(!end) {
			System.out.println("전화번호부 관리 프로그램");
			System.out.println("[1]추가  [2]모든 정보 보기  [3]선택 정보 보기  [4]종료 : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("추가할 정보를 입력해 주세요.");
				System.out.println("이름 : ");
				dto.setName(scan.next());
				System.out.println("전화번호 : ");
				dto.setPhoneNum(scan.next());
				System.out.println("나이 : ");
				dto.setAge(scan.nextInt());
				
				dao.insert(dto);
				end=true;
				
				break;
			case 2:
				 dtoList = dao.selectAll();
				 System.out.println("이름\t전화번호\t나이");
				 for (int i=0; i<dtoList.size(); i++) {
					 System.out.println(dtoList.get(i).getName()+"\t"+dtoList.get(i).getPhoneNum()+"\t"+dtoList.get(i).getAge());
				 }
				 System.out.println();
				 end=true;
				break;
			case 3:
				//이름 입력시 해당 이름의 번호를 출력
				System.out.print("검색할 이름을 입력해 주세요 : ");
				String name = scan.next();
				System.out.println(dao.selectOne(name));
				end=true;
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				end=true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		scan.close();
		

	}

}
