package car;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		for (int i=0; i<dao.select_floorseat_1().size(); i++)
		System.out.print(dao.select_floorseat_1().get(i).getPosition()+" ");

	}

}
