package Ex03;

public class Main {

	public static void main(String[] args) {
		// 사용자 정의 자료형 (Value Object)
		
		// PocketMon
		
		Pocketmon ggobugi = new Pocketmon("꼬부기", "물", 100, 80, 1000);
//		ggobugi.setName("꼬부기");
//		ggobugi.setType("물");
//		ggobugi.setAttack(100);
//		ggobugi.setShield(80);
//		ggobugi.setHP(1000);
//		ggobugi.showStatus();
		
		String name = ggobugi.getName();
		String type = ggobugi.getType();
		int attack = ggobugi.getAttack();
		int shield = ggobugi.getShield();
		int hp = ggobugi.getHP();
		
		System.out.println("Name: "+name);
		System.out.println("Type: "+type);
		System.out.println("Attack: "+attack);
		System.out.println("Shield: "+shield);
		System.out.println("HP: "+hp);
		System.out.println();
		
		Pocketmon pari = new Pocketmon("파이리", "불", 80, 70, 1000);
//		pari.setName("파이리");
//		pari.setType("불");
//		pari.setAttack(80);
//		pari.setShield(70);
//		pari.setHP(1000);
		pari.showStatus();

	}

}
