package car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Random rd = new Random();
	Calendar cal = Calendar.getInstance();

	// DB에 접속
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			final String user = "car";
			final String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
			} else {
				System.out.println("연결실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//입차 차량 번호 랜덤으로 생성하고 입차 시간 입력
	public DTO getCamData() {
		
		String car_num;
		String in_time;
		car_num = Integer.toString(rd.nextInt(9000) + 1000);
		in_time = time.format(System.currentTimeMillis());
		DTO dto = new DTO(in_time, car_num);
		return dto;
	}
	
	// 랜덤으로 출차하는 차 선택
	public ArrayList<DTO> rd_out_car() {
		getCon();
		String sql = "select car_num, in_time from (select car_num, in_time from CUSTOMER "
				+ "where out_time is null order by DBMS_RANDOM.RANDOM) where rownum=1";
		DTO dto = null;
		ArrayList<DTO> list_rdcar = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				dto = new DTO();
				dto.setCar_num(rs.getString(1));
				dto.setIn_time(rs.getString(2));
				list_rdcar.add(dto);
			}
			return list_rdcar;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 출차시간을 받아 주차 요금 계산
	public int money(String out_time) {
		int fare_sum = 0;
		getCon();
		String sql = "select extract(day from fare_sum)*86400 + extract(hour from fare_sum)*3600 + extract(minute from fare_sum)*60 + extract(second from fare_sum) from (select (out_time-in_time)/60 as fare_sum from CUSTOMER where out_time = ?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, out_time);
			rs = pst.executeQuery();
			while (rs.next()) {
				fare_sum = rs.getInt(1) * 100;
			}
			return fare_sum;
		} catch (Exception e) {

		} finally {
			close();
		}
		return fare_sum;
	}
	
	// 출차시간을 받아 입차시간부터 몇분이 지났는지 계산 해줌
	public int stayTime(String out_time) {
		int st = 0;
		getCon();
		String sql = "select extract(day from fare_sum)*86400 + extract(hour from fare_sum)*3600 + extract(minute from fare_sum)*60 + extract(second from fare_sum) from (select (out_time-in_time)/60 as fare_sum from CUSTOMER where out_time = ?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, out_time);
			rs = pst.executeQuery();
			while (rs.next()) {
				st = rs.getInt(1);
			}
			return st;
		} catch (Exception e) {

		} finally {
			close();
		}
		return st;
	}

	// 주차된 차량 정보 조회
	public ArrayList<DTO> selectAll() {
		// 모든정보보기
		getCon();
		String sql = "select car_num, in_time, out_time, fare_sum from customer where out_time is not null";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			ArrayList<DTO> list = new ArrayList<DTO>();
			while (rs.next()) {
				DTO dto = new DTO();
				dto.setCar_num(rs.getString(1));
				dto.setIn_time(rs.getString(2));
				dto.setOut_time(rs.getString(3));
				dto.setFare_sum(rs.getInt(4));
				list.add(dto);
				
//				System.out.print(rs.getString(1)+"\t");
//				System.out.print(rs.getString(2)+"\t");
//				System.out.print(rs.getString(3)+"\t");
//				System.out.print(rs.getString(4)+"\t");
//				System.out.println();
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 아래 check_memeber()로 대체.
//	public ArrayList<String> select_ad_car(String input_car_num) {
//		// 모든정보보기
//		getCon();
//		String sql = "select distinct a.car_num  from admin a, customer c where a.car_num in(?)";
//
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.setString(1, input_car_num);
//			ArrayList<String> list = new ArrayList<>();
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				String car_num = rs.getString(1);
//				list.add(car_num);
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return null;
//	}
	
	// 정액권 회원 여부 확인
	public boolean check_memeber(String input_car_num) {
		getCon();
		boolean check;
		String sql = "select distinct car_num from admin where car_num in(?)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, input_car_num);
			ArrayList<String> list = new ArrayList<>();
			rs = pst.executeQuery();
			while (rs.next()) {
				String car_num = rs.getString(1);
				list.add(car_num);
			}
			if (list.size()>0 && list.get(0).contentEquals(input_car_num)) {
				check = true;
			} else {
				check = false;
			}
			return check;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	//계산된 요금을 DB에 업데이트 해줌.
	public int update_fare(DTO dto) {// 요금 업데이트 하는거.
		getCon();
		String sql = "update customer set fare_sum = ? where car_num = ?";
		//요금을 메인문에서 직접 받아줘야함.
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dto.getFare_sum());
			pst.setString(2, dto.getCar_num());

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	// 위와 같은 함수인데, 변수를 String과 int로 받아 줌.
	public int update_fare(String car_num, int fare) {// 요금 업데이트 하는거.
		getCon();
		String sql = "update customer set fare_sum = ? where car_num = ?";
		//요금을 메인문에서 직접 받아줘야함.
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fare);
			pst.setString(2, car_num);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 출차하는 차량 시간 DB에 업데이트
	public int update_outtime(DTO dto) {
		getCon();
		String sql = "update customer set out_time = ? where car_num = ?";
		// main 문에 초이스 2번에 차번호를 랜덤으로 찍어준다음
		// 그 차번호에 맞는 아웃타임을 찍어줌.
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getOut_time());
			pst.setString(2, dto.getCar_num());

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	
	// 회원 등록
	public int insert(DTO dto) {
		getCon();
		String sql = "insert into admin values(?,?,?)";
		// 카 넘은 이미 카 넘에 데이터가 있어야만 들어가고
		// 아이디는 따로 입력해줘야함,
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getCar_num());
			pst.setString(2, dto.getId());
			pst.setString(3, dto.getPhone());

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}


	// DB member 테이블에 신규 회원 id를 입력함 (옆에 널값들은 정액권 날짜 입력란임) - 다른 함수가 쓰는 내부용 함수
	public int insert_id(DTO dto) {
		getCon();
		String sql = "insert into member values(?,null,null)";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getId());

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 정액권 구매일 - 유효 마지막날.
	public int st_ed_update(String id) {
		getCon();
		String sql = "update member set start_day = ?, end_day = ? where id = ?";
		try {
			
			String start_day = time.format(System.currentTimeMillis());
			Date date = time.parse(start_day);
			cal.add(Calendar.DATE, 30);
			String end_day = time.format(cal.getTime());
//			int cnt2 = dao.st_ed_update(start_day, end_day, id);

			pst = conn.prepareStatement(sql);
			pst.setString(1, start_day);
			pst.setString(2, end_day);
			pst.setString(3, id);
			
			cal.add(Calendar.DATE, -30);
			int cnt = pst.executeUpdate();
			return cnt;
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 위치 정보를 지우지 않고도 주차 여부를 확인 할 수 있도록 함수들이 업데이트 되어 이 함수는 사용하지 않음.
//	public void del_position() {// 요금 낸 고객의 위치를 지우는 함수
//		getCon();
//		String sql = "update customer set position = null where out_time is not null";
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//	}

	
	// 입차 하는 차 정보를 DB에 저장하는 함수
	public int insert_member(DTO dto) {
		getCon();
		String sql = "insert into customer values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dto.getCar_num());
			pst.setString(2, dto.getIn_time());
			pst.setString(3, dto.getOut_time());
			pst.setInt(4, dto.getFare_sum());
			pst.setInt(5, dto.getPosition());

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 
	public ArrayList<String> selectOne(int position) {
		getCon();
		String sql = "select car_num from customer where position = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, position);
			rs = pst.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				String customer = rs.getString(1);
				list.add(customer);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}

	//
	public ArrayList<DTO> out_selectOne(String car_num1) {
		getCon();

		String sql = "select car_num, in_time, out_time, fare_sum from customer where car_num = ?";
		DTO dto = null;
		ArrayList<DTO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, car_num1);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getString(1);
				rs.getString(2);
				rs.getString(3);
				rs.getInt(4);

				dto = new DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}

	// 1층 빈공간 위치 정보 리스트로 받기
	public ArrayList<DTO> select_floorseat_1() {
		getCon();

		String sql = "select l.floor, c.position, c.car_num from customer c, location l"
				+ " where l.position = c.position" + " and floor = 1 and c.out_time is null";
		DTO dto = null;
		ArrayList<DTO> list_1 = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getInt(1);
				rs.getInt(2);
				rs.getString(3);

				dto = new DTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list_1.add(dto);
			}
			return list_1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 2층 빈공간 위치 정보 리스트로 받기
	public ArrayList<DTO> select_floorseat_2() {
		getCon();

		String sql = "select l.floor, c.position, c.car_num" + " from customer c, location l"
				+ " where l.position = c.position" + " and floor = 2 and c.out_time is null";
		DTO dto = null;
		ArrayList<DTO> list_1 = new ArrayList<>();
		try {

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getInt(1);
				rs.getInt(2);
				rs.getString(3);

				dto = new DTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list_1.add(dto);
			}
			return list_1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 3층 빈공간 위치 정보 리스트로 받기
	public ArrayList<DTO> select_floorseat_3() {
		getCon();

		String sql = "select l.floor, c.position, c.car_num" + " from customer c, location l"
				+ " where l.position = c.position" + " and floor = 3 and c.out_time is null";
		DTO dto = null;
		ArrayList<DTO> list_1 = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getInt(1);
				rs.getInt(2);
				rs.getString(3);

				dto = new DTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list_1.add(dto);
			}
			return list_1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 4층 빈공간 위치 정보 리스트로 받기
	public ArrayList<DTO> select_floorseat_4() {
		getCon();

		String sql = "select l.floor, c.position, c.car_num" + " from customer c, location l"
				+ " where l.position = c.position" + " and floor = 4 and c.out_time is null";
		DTO dto = null;
		ArrayList<DTO> list_1 = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getInt(1);
				rs.getInt(2);
				rs.getString(3);

				dto = new DTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list_1.add(dto);
			}
			return list_1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}

	// 회원 조회
	public ArrayList<DTO> selectMember() {
		getCon();
		String sql = "select a.id, a.car_num, a.phone, m.start_day, m.end_day from admin a, member m where a.id=m.id";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			ArrayList<DTO> list = new ArrayList<DTO>();
			while (rs.next()) {
				String id = rs.getString(1);
				String car_num = rs.getString(2);
				String phone = rs.getString(3);
				String start_day = rs.getString(4);
				String end_day = rs.getString(5);
				DTO dto = new DTO(id, car_num, phone, start_day, end_day);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// ADMIN 화면에서 차번호로 조회
	public ArrayList<DTO> check_car(String car_num2) {
		getCon();

		String sql = "select car_num, position, in_time, out_time, fare_sum from customer where car_num = ?";
		DTO dto = null;
		ArrayList<DTO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, car_num2);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getString(1);
				rs.getInt(2);
				rs.getString(3);
				rs.getString(4);
				rs.getInt(5);
				dto = new DTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}
	
	// ADMIN 화면에서 날짜별 조회
	public ArrayList<DTO> check_day(String in_time) {
		getCon();

		String sql = "select car_num, position, in_time, out_time, fare_sum from customer where to_char(in_time,'yyyymmdd') = ? order by in_time";
		DTO dto = null;
		ArrayList<DTO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, in_time);
			rs = pst.executeQuery();
			while (rs.next()) {
				rs.getString(1);
				rs.getInt(2);
				rs.getString(3);
				rs.getString(4);
				rs.getInt(5);
				dto = new DTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}

	// 전체 주차장에 빈 공간 위치 정보 리스트 만들기
	public ArrayList<DTO> selectEmpty(int floor) {
	      getCon();

	      String sql = "select c.position, l.floor" + " from customer c, location l"
	            + " where l.position = c.position" + " and l.floor = ? and c.out_time is null";
	      DTO dto = null;
	      ArrayList<DTO> list_1 = new ArrayList<>();
	      try {
	         pst = conn.prepareStatement(sql);
	         pst.setString(1, floor+"");
	         rs = pst.executeQuery();
	         while (rs.next()) {
	            rs.getInt(1);
	            rs.getInt(2);

	            dto = new DTO(rs.getInt(1), rs.getInt(2));
	            list_1.add(dto);
	         }
	         return list_1;

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return null;

	   }
	

	
}