
public class Upcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getToy(new Pickachu());
//		getToy(new Kkobugi());
//		getToy(new Paili());

		
	}
	
	public static void getToy(Toy toy) {
		toy.print();

}
	
}
