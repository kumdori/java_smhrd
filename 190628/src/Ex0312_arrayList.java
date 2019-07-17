import java.util.ArrayList;

public class Ex0312_arrayList {

	public static void main(String[] args) {
		// 가변 배열
		ArrayList<String> team = new ArrayList<String>();
		
		// 셀 추가하기
		team.add("장진");
		team.add("김미희");
		team.add("이명호");
		team.add("이은비");
		team.add("김동원");

		// 멤버 수 보기
		System.out.println(team.size());
		
		team.add(3, "박원호");
		
		// 멤버 지우기
		team.remove(0);
		
		// 멤버 인덱스로 보기
		System.out.println(team.get(0));
		
		// 팀 전체 지우기
		team.clear();
		System.out.println(team.size());
		
	}

}
