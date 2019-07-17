package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
	public static void main(String[] args) {
		// 동적로딩 : 어떤 DBMS를 사용할지
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			Connection conn = DriverManager.getConnection(url, user, password);
			
			if (conn!=null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
			
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
	}

}
