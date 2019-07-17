import java.sql.ResultSet;

public class select {
	
	public void select() {
		getCon();
		String sql = "select * from members";
		
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String selectId = rs.getString(1);
				String selectPw = rs.getString(2);
				int selectAge = rs.getInt(3);
				String selectAddr = rs.getString(4);
				
				System.out.println(selectId+"/"+selectPw+"/"+selectAge+"/"+selectAddr);
			}
			
		} catch(Exception e) {
			
		}
	}

}
