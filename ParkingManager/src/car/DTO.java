package car;

public class DTO {
	private String car_num;
	private String in_time;
	private String out_time;
	private int fare_sum;
	private int position;
	private int floor;
	private String phone;
	private String id;
	private String start_day;
	private String end_day;

	public DTO() {
		// 어디서든지 쓸수있는 전역변수.
	}

	public DTO(String car_num, int position, String in_time, String out_time, int fare_sum) {
		this.car_num = car_num;
		this.position = position;
		this.in_time = in_time;
		this.out_time = out_time;
		this.fare_sum = fare_sum;
	}

	public DTO(String id, String car_num, String phone, String start_day, String end_day) {
		this.id = id;
		this.car_num = car_num;
		this.phone = phone;
		this.start_day = start_day;
		this.end_day = end_day;
	}

	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	public String getEnd_day() {
		return end_day;
	}

	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}

	public DTO(String car_num, String phone, String id) {
		super();
		this.car_num = car_num;
		this.phone = phone;
		this.id = id;
	}

	public DTO(int fare_sum, String car_num) {
		this.fare_sum = fare_sum;
		this.car_num = car_num;
	}

	public DTO(String out_time, String car_num) {
		this.out_time = out_time;
		this.car_num = car_num;
	}

	public DTO(String car_num) {
		this.car_num = car_num;
	}

	public DTO(int fare_sum) {
		this.fare_sum = fare_sum;
	}

	public DTO(String car_num, String in_time, String out_time, int fare_sum, int position) {
		super();
		this.car_num = car_num;
		this.in_time = in_time;
		this.out_time = out_time;
		this.fare_sum = fare_sum;
		this.position = position;
	}

	public DTO(String car_num, String in_time, String out_time, int fare_sum) {
		super();
		this.car_num = car_num;
		this.in_time = in_time;
		this.out_time = out_time;
		this.fare_sum = fare_sum;
	}

	public DTO(int floor, int position, String car_num) {
		this.floor = floor;
		this.position = position;
		this.car_num = car_num;
	}
	
	public DTO(String car_num, int position, String in_time) {
		this.in_time = in_time;
		this.position = position;
		this.car_num = car_num;
	}
	
	public DTO(int position, int floor) {
		this.floor = floor;
		this.position = position;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getFare_sum() {
		return fare_sum;
	}

	public void setFare_sum(int fare_sum) {
		this.fare_sum = fare_sum;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getCar_num() {
		return car_num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

}