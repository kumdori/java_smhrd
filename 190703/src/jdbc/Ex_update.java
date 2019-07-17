package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex_update {

	public static void main(String[] args) {
		//

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			Connection conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
			
			String sql = "update members set id='park' where age=20";
			PreparedStatement pst = conn.prepareStatement(sql);
			int cnt = pst.executeUpdate();
			
			if (cnt>0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
