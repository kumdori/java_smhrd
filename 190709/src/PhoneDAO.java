import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PhoneDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	PhoneDTO dto = null;
	ArrayList<PhoneDTO> list;
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
			if (conn!=null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int insert(String name, int age, String phoneNum) {
		getCon();
		String sql = "insert into phone values (?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, phoneNum);
			pst.setInt(3, age);
			
			int cnt = pst.executeUpdate();
			return cnt;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
		
	}
	
	public int delete(String delname) {
		getCon();
		
		String sql = "delete from phone where name = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, delname);
			
			int cnt = pst.executeUpdate();
			return cnt;
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (pst!=null) pst.close();	
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}


	public ArrayList<PhoneDTO> selectAll() {
		getCon();
		String sql = "select * from phone";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			ArrayList<PhoneDTO> list = new ArrayList<PhoneDTO>();
			while(rs.next()) {
				String selectName = rs.getString(1);
				String selectPhoneNum = rs.getString(2);
				int selectAge = rs.getInt(3);
				
				dto = new PhoneDTO(selectName, selectPhoneNum, selectAge);
				list.add(dto);
			}
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
		
		
	}

}
