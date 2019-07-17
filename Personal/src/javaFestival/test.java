package javaFestival;
public class test {

	public static void main(String[] args) {
		// Matriz test
		
		int[][] matrix = new int[6][6];
		Matriz.iniciarAzar(matrix, 6);
		Matriz.imprimir(matrix, 6);
		Matriz.rotar(matrix, 6);
		Matriz.imprimir(matrix, 6);

	}

}
