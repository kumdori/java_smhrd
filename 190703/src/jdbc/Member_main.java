package jdbc;

import java.util.Scanner;

public class Member_main {

	public static void main(String[] args) {
		// 
		
		Scanner scan = new Scanner(System.in);
		Member_cntr dao = new Member_cntr();
		
		// Connects to DB
		final String a = "oracle.jdbc.driver.OracleDriver";
		final String b = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		final String c = "hr";
		final String d = "hr";
		
		if (dao.dbConn(a, b, c, d)) {
			System.out.println("연결 성공");
		} else {
			System.out.println("연결 실패");
		}
		
		
		
		
		System.out.println("[1]회원가입  [2]회원수정  [3]회원탈퇴  [4]회원정보보기  [5]종료  >>");
		int choice = scan.nextInt();
				
		switch (choice) {
		case 1:
			if (dao.joinup()) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}

			break;
		case 2:
			if (dao.update()) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
			break;
		case 3:
			if (dao.delete()) {
				System.out.println("탈퇴 성공");
			} else {
				System.out.println("탈퇴 실패");
			}
			break;
		case 4:
			dao.search();
			break;
		case 5:
			System.out.println("종료합니다.");
//			end=true;		
			break;
		default:
			System.out.println("다시 입력해 주세요.");
			break;
		}
		scan.close();

	}

}
