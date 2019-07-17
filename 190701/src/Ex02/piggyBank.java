package Ex02;

public class piggyBank {
   // 속성 (잔액) -> 변수
	private int savings = 0;
	
	//기능 (저금, 배가르기) -> method
	public void save(int svQty) {
		this.savings+=svQty;
	}
	
	public int current() {
		return this.savings;
	}
	
	public void withdraw(int wdQty) {
		this.savings-=wdQty;
	}
}
