package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Member_cntr {

	private Scanner scan = new Scanner(System.in);
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public boolean dbConn(String className, String url, String user, String password) {

		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean joinup() {
		try {
			System.out.println("======회원가입 프로그램=========");
			System.out.print("아이디 : ");
			String id = scan.next();
			System.out.print("패스워드 : ");
			String pw = scan.next();
			System.out.print("나이 : ");
			int age = scan.nextInt();
			System.out.print("주소 : ");
			String adress = scan.next();

			PhoneDTO dto = new PhoneDTO(id, pw, age, adress);
			
			String sql = "insert into members values(?,?,?,?)"; // 쿼리문의 매개변수

			pst = conn.prepareStatement(sql);

			pst.setString(1, dto.getId()); // 쿼리문 매개변수 값 지정
			pst.setString(2, dto.getPw());
			pst.setInt(3, dto.getAge());
			pst.setString(4, dto.getAddr());

			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update() {
		try {
			System.out.println("무엇을 업데이트 하시겠습니까?");
			System.out.println("[1]아이디  [2]비밀번호  [3]나이  [4]주소: ");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;

			}

			String a = scan.next();
			String b = scan.next();
			String c = scan.next();
			String d = scan.next();

			String sql = "update members set ?=? where ?=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, a);
			pst.setString(2, b);
			pst.setString(3, c);
			pst.setString(4, d);
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete() {

		try {

			System.out.println("탈퇴할 회원의 아이디를 입력하세요. ");
			String del_id = scan.next();

			String sql = "delete from members where id=?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, del_id);
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public void search() {
		try {
			
			String sql = "select * from members";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			
			//Print
			System.out.println("ID\tPW\tAge\tAdress");
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				int age = rs.getInt(3);
				String adress = rs.getString(4);

				System.out.print(id+"\t"+pw+"\t"+age+"\t"+adress);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

//
//	
//	 finally {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				pst.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
