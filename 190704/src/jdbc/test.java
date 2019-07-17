package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";

			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, password);
				if (conn != null) {
					System.out.println("연결 성공");
				} else {
					System.out.println("연결 실패");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


	}

}
