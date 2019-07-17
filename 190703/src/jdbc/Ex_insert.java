package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex_insert {

	public static void main(String[] args) {
		//
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pst = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("======회원가입 프로그램=========");
			System.out.print("아이디 : ");
			String id = scan.next();
			System.out.print("패스워드 : ");
			String pw = scan.next();
			System.out.print("나이 : ");
			int age = scan.nextInt();
			System.out.print("주소 : ");
			String adress = scan.next();

			String sql = "insert into members  values(?,?,?,?)"; // 쿼리문의 매개변수

			pst = conn.prepareStatement(sql);

			pst.setString(1, id); // 쿼리문 매개변수 값 지정
			pst.setString(2, pw);
			pst.setInt(3, age);
			pst.setString(4, adress);

			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if (pst != null)
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
			if (conn != null)
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			scan.close();
		}
	}

}
