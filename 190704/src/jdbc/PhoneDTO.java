package jdbc;

public class PhoneDTO {
	
	private String name;
	private String phoneNum;
	private int age;
	
	
	public PhoneDTO() {
		super();
	}


	public PhoneDTO(String name, String phoneNum, int age) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
