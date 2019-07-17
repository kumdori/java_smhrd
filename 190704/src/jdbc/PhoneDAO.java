package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneDAO {
	Scanner scan = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "hr";
	String password = "hr";

	public void getCon() {
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

	public void insert(PhoneDTO dto) {
		// 전화번호 추가하는 메소드
		getCon();
		String sql = "insert into phone values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, dto.getName());
			pst.setString(2, dto.getPhoneNum());
			pst.setInt(3, dto.getAge());

			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

	}

	private void getClose() {
		//
		try {
			if (rs!=null) {
			rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pst!=null) {
			pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn!=null) {
			conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<PhoneDTO> selectAll() {
		// 모든 정보 가져오기
		getCon();
		String sql = "select * from members";
		
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			PhoneDTO dto = null;
			ArrayList<PhoneDTO> list = new ArrayList<PhoneDTO>();
			while(rs.next()) {
				String selectName = rs.getString(1);
				String selectPhoneNum = rs.getString(2);
				int selectAge = rs.getInt(3);
				
				dto = new PhoneDTO(selectName, selectPhoneNum, selectAge);
				list.add(dto);
				return list;
			}
			
		} catch(Exception e) {
			
		} finally {
			getClose();
		}
		return null;

	}

	public String selectOne(String name) {
		// 이름 입력시 전화번호 가져오기
		getCon();
		
		String sql = "select phonenum from phone where name = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			rs.next();
			String selectPhoneNum = rs.getString(1);	
			return selectPhoneNum;
			
			
		} catch(Exception e) {
			
		} finally {
			getClose();
		}
		return "here";

	}

}
