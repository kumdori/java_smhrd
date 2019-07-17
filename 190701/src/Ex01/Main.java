package Ex01;

public class Main {

	public static void main(String[] args) {
		// 
		
		tv samsung = new tv();
		tv lg = new tv();
		

		System.out.println("Samsung TV");
		samsung.volUP();
		samsung.tvStatus();
		System.out.println();
		
		System.out.println("LG TV");
		lg.chDown();
		lg.volDown();
		lg.powerTurn();
		lg.tvStatus();


	}

}
