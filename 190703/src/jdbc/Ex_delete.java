package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex_delete {

	public static void main(String[] args) {
		//
		Connection conn = null;
		PreparedStatement pst = null;
		Scanner scan = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			System.out.println("회원 탈퇴 프로그램");
			System.out.println("탈퇴할 회원의 아이디를 입력하세요. ");
			String del_id = scan.next();

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

			String sql = "delete from members where id=?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, del_id);
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("탈퇴 성공");
			} else {
				System.out.println("탈퇴 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
