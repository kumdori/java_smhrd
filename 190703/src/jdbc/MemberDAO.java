package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {
	Scanner scan = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pst = null;
	
	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "hr";
	String password = "hr";
	
	
	public void getCon() {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url);
			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insert(PhoneDTO dto) {
		getCon();
		
		String sql = "insert into members values(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPw());
			pst.setInt(3, dto.getAge());
			pst.setString(4, dto.getAddr());
			
			int cnt = pst.executeUpdate();
			if (cnt>0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		getCon();
		
		try {
			
			System.out.println("탈퇴할 회원의 아이디를 입력하세요. ");
			String del_id = scan.next();

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
		}
	}
		
		public ArrayList<PhoneDTO> select() {
			getCon();
			String sql = "select * from members";
			
			try {
				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				PhoneDTO dto = null;
				ArrayList<PhoneDTO> list = new ArrayList<PhoneDTO>();
				while(rs.next()) {
					String selectId = rs.getString(1);
					String selectPw = rs.getString(2);
					int selectAge = rs.getInt(3);
					String selectAddr = rs.getString(4);
					
					dto = new PhoneDTO(selectId, selectPw, selectAge, selectAddr);
					list.add(dto);
					return list;
				}
				
			} catch(Exception e) {
				
			}
			return null;
		}


}
