package Ex04_adressbook;

public class adressbook {
	private String name;
	private String phone;
	private int age;
	public int length;

	public adressbook(String name, String phone, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void Status() {
		// Print All Data
		System.out.println("Name : "+this.name);
		System.out.println("Phone : "+this.phone);
		System.out.println("Age : "+this.age);
		System.out.println();
	}
	
	
}
