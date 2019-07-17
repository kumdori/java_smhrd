package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex_update2 {

	public static void main(String[] args) {
		// 회원 수정 프로그램

		Connection conn = null;
		PreparedStatement pst = null;

		Scanner scan = new Scanner(System.in);
		System.out.println("회원 수정 프로그램");
		System.out.println("수정할 아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.println("아이디의 비밀번호를 입력하세요 : ");
		String pw = scan.next();

		// jdbc를 연동해서 테이블 안에 있는 정보를 수정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

			String sql = "update members set pw=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, id);

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
