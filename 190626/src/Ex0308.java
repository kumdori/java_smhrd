
public class Ex0308 {

	public static void main(String[] args) {
		// 1. 학생(stu1)의 국, 영, 수 점수를 저장할 수 있는 배열
		
		int[] stu1 = new int[3];

		stu1[0] = 30;
		stu1[1] = 100;
		stu1[2] = 50;
		
		int[] stu2 = {100,20, 80};
		stu1 = stu2;
		stu1[1]=0;
//		System.out.println(stu2[1]);
		
		int[] stu3 = new int[4];
		
		int[][] students = {stu1, stu2, stu3};

		System.out.println(students.length);
		System.out.println(students[0].length);
		System.out.println(students[1].length);
		System.out.println(students[2].length);
		
//		imprimir (students, 3);
		
		// 1. 배열에는 같은 자료형 밖에 넣을 수 없다.
		// 10명 학생의 5과목을 저장할 메모리를 생성하세요.
		
				int[][] all_s = new int[10][5];

		

	}
	
	public static void imprimir(int[][] matrix, int n) {
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.print("\n");
		}
	}

}
