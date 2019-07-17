import java.util.ArrayList;
import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
		//
		Scanner scan = new Scanner(System.in);
		PhoneDAO dao = new PhoneDAO();
		PhoneDTO dto = null;
		ArrayList<PhoneDTO> list;
		while (true) {
			System.out.println("[1]추가  [2]삭제  [3]전체보기  [4]종료: ");

			int choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("Name: ");
				String name = scan.next();
				System.out.println("Age: ");
				int age = scan.nextInt();
				System.out.println("Phone: ");
				String phoneNum = scan.next();

				int cnt = dao.insert(name, age, phoneNum);
				if (cnt > 0) {
					System.out.println("연결 성공");
				} else {
					System.out.println("연결 실패");
				}
				
			} else if (choice == 2) {
				
				System.out.println("삭제할 이름: ");
				String delname = scan.next();
				
				int cnt = dao.delete(delname);
				if (cnt > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				} 
				

			} else if (choice == 3) {
				list = dao.selectAll();
				System.out.println("이름\t전화번호\t나이");
				for (int i=0; i<list.size(); i++) {
					System.out.println(list.get(i).getName()+"\t"+list.get(i).getPhoneNum()+"\t"+list.get(i).getAge());
				}

			} else {
				System.out.println("종료합니다.");
				break;

			}
		}
		scan.close();

	}

}
