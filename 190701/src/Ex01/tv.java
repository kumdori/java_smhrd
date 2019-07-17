package Ex01;

public class tv {
	// 속성 (볼륨, 체널, 전원)
	// 속성은 변수로 정의 해줌.
	// 클래스 변수, Field, 전역변수
	private int vol=0;
	private int ch=0;
	private boolean power=false;
	
	// 기능 (볼륨Up, 볼륨Down, 채널Up, 채널Down, 전원On/Off)
	public void volUP() {
		this.vol++;
	}
	
	public void volDown() {
		this.vol--;
	}
	
	public void chUP() {
		this.ch++;
	}

	public void chDown() {
		this.ch--;
	}
	
	public void powerTurn() {
		power=!power;
	}
		
	public void tvStatus() {
		int vol=0; //지역변수
		
		System.out.println("Volume: "+this.vol);
		System.out.println("Channel: "+this.ch);
		String powerS=power?"ON":"OFF";
		System.out.println("Power: "+powerS);
	}
	

}
