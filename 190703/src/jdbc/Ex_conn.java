package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex_conn {

	public static void main(String[] args) {
		// Oracle DB 연결하여 데이터 삽입하기

		try {
			// 1. 동적 로딩 : 어떤 DBMS를 사용할지 사용자가 지정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // Oracle DB 주소
			String user = "hr";
			String password = "hr";

			String sql = "Insert into members values ('Esteban', '1234', 20, 'Jisan 1dong')";

			// 2. DB 연결
			Connection conn = DriverManager.getConnection(url, user, password);

			// 3. 연결 여부 메시지
			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

			// PreparedStatement는 Sql문이 실행될 수 있는 통로
			PreparedStatement pst = conn.prepareStatement(sql);
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("데이터 삽입 성공");
			} else {
				System.out.println("데이터 삽입 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
