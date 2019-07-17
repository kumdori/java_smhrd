package Ex03;

public class Pocketmon {
	
	// 속성 (type, 공격력, 방어력, 이름, 체력)
	private String type;
	private String name;
	private int attack;
	private int shield;
	private int HP;
	
	//생성자(Constructor)
	//1.객체 생성시 함께 호출
	//2.Return Type이 없음
	//3.이름이 클래스명과 같음
	//4.Public-Private 설정해도/안해도 그만
	
	
	//Constructor
	
	Pocketmon(String name, String type, int attack, int shield, int hp) {
		this.name=name;
		this.type=type;
		this.attack=attack;
		this.shield=shield;
		this.HP=hp;
	}
	
	// Setters
	
	public void setName(String name) {
		// 이름을 입력함
		this.name=name;
		
	}
	public void setType(String type) {
		// type
		this.type=type;
		
	}
	public void setAttack(int attack) {
		// Attack
		this.attack=attack;
	}
	public void setShield(int shield) {
		// Shield
		this.shield=shield;
	}
	public void setHP(int hp) {
		// Health Point
		this.HP=hp;
		
	}
	public void showStatus() {
		// Status
		System.out.println("Name: "+this.name);
		System.out.println("Type: "+this.type);
		System.out.println("Attack: "+this.attack);
		System.out.println("Shield: "+this.shield);
		System.out.println("HP: "+this.HP);
	}
	
	
	// Getters
	
	public String getName() {
		// 
		return this.name;
	}
	public String getType() {
		// 
		return this.type;
	}
	public int getAttack() {
		// 
		return this.attack;
	}
	public int getShield() {
		// 
		return this.shield;
	}
	public int getHP() {
		// 
		return this.HP;
	}
	
	// Source -> Generate Getters and Setters...
	// Source -> Generate Constructor using Fields...

}
