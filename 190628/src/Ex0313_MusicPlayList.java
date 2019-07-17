import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex0313_MusicPlayList {

	public static void main(String[] args) {
		/*
		 * 마지막 위치에 추가를 선택할 시 추가할 노래제목과 추가할 위치를 입력받고, 입력 받은 위치의 인덱스에 노래를 추가하세요.
		 * 
		 * [1]노래 추가 [2]노래 삭제 [3]종료 >> 1 ============ 현재 재생 목록 ============ 재생 목록이 없습니다.
		 * ================================== [1]마지막 위치에 추가 [2]원하는 위치에 추가 >> 1 추가할 노래 입력
		 * : 뱅뱅뱅 추가가 완료되었습니다. [1]노래 추가 [2]노래 삭제 [3]종료 >>
		 * 
		 */
		
		// Definition of variables

		ArrayList<String> currentList = new ArrayList<String>();
		ArrayList<String> playlistName = new ArrayList<String>();
		ArrayList<ArrayList<String>> allPlaylist = new ArrayList<ArrayList<String>>();
		boolean endFlag = false;
		int mainmenu = 0;

		// Main menu
		
		while (!endFlag) {
			Scanner scan = new Scanner(System.in);
			try {
				System.out.print("[1]노래 목록  [2]노래 추가  [3]노래 삭제  [4]Playlist 추가  [5]Playlist 조회  [6]종료 >> ");
				mainmenu = scan.nextInt();
				if (mainmenu>6) {
					mainmenu=7;
				}

			} catch (InputMismatchException e) {
				mainmenu = 7;
			}

			switch (mainmenu) {
			case 1:
				showCurrentList(currentList);         //[1]노래 목록
				break;
			case 2:
				showCurrentList(currentList);
				addCurrentList(currentList, scan);    //[2]노래 추가
				break;
			case 3:
				if (currentList.size()>0) {
				showCurrentList(currentList);
				deleteCurrentList(currentList, scan); //[3]노래 삭제
				} else {
					System.out.println("삭제 할 노래가 없습니다.");
				}
				
				break;
			case 4:
				// addPlaylists
				System.out.print("PlayList이름 >> ");
	            String name = scan.next();
	            playlistName.add(name);               //[4]Playlist 추가
	            allPlaylist.add(currentList);
	            break;
			case 5:                                   //[5]Playlist 조회
				System.out.println("0. 새로운 트랙");
				showCurrentList(playlistName);
	            System.out.print("index >> ");
	            int choice = scan.nextInt();
	            if (choice == 0) {
	               currentList = new ArrayList<String>();
	            }else {
	               currentList = allPlaylist.get(choice - 1);
	            }
	            
	            break;
			case 6:
				System.out.println("프로그램이 종료되었습니다."); //[6]종료
				endFlag = true;
				scan.close();
				break;
			case 7:
				System.out.println("올바른 번호를 입력해 주세요."); //Try Exception - 숫자가 아닌 글자를 입력시.
				System.out.println();
				break;
			}
			
		}
		

	}


/// Methods


	private static void deleteCurrentList(ArrayList<String> playlist, Scanner scan) {
		// Delete a song of the current list or the whole list

		boolean choice = true;
		int delmenu = 0;

		while (choice) {
			choice = false;
			try {
				System.out.print("[1]선택 삭제  [2]전체 삭제 >> ");
				delmenu = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("올바른 번호를 입력해 주세요.");
				System.out.println();
				choice = true;
			}
		}

		if (delmenu == 1) {
			System.out.print("삭제할 노래 선택 : ");
			int songId = scan.nextInt();
			playlist.remove(songId - 1);
			System.out.println("노래가 삭제되었습니다.");
			System.out.println();
		} else if (delmenu == 2) {
			System.out.print("정말 모든 노래를 삭제하시겠습니까? (1.예 / 2.아니오) ");
			int allclear = scan.nextInt();
			if (allclear == 1) {
				playlist.clear();
				System.out.println("모든 노래가 삭제되었습니다.");
				System.out.println();
			}

		}

	}

	private static void addCurrentList(ArrayList<String> playlist, Scanner scan) {
		// Add a song to current list
		
		boolean choice = true;
		int addmenu = 0;

		while (choice) {
			choice = false;
			try {
				System.out.print("[1]마지막 위치에 추가  [2]원하는 위치에 추가  >> ");
				addmenu = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("올바른 번호를 입력해 주세요.");
				System.out.println();
				choice = true;
			}
		}

		if (addmenu == 1) {
			System.out.print("추가할 노래 입력 : ");
			String addsong = scan.next();
			playlist.add(addsong);
			System.out.println("추가가 완료되었습니다.");
			System.out.println();
		} else if (addmenu == 2) {
			System.out.print("추가할 노래 입력 : ");
			String songName = scan.next();

			boolean position = true;
			while (position) {

				System.out.print("원하는 위치 입력 : ");
				int songId = scan.nextInt();
				if (songId <= playlist.size()) {
					playlist.add(songId - 1, songName);
					position = false;
				} else {
					System.out.println("범위에서 벗어납니다. 다시 입력해 주세요.");
					System.out.println();
					position = true;
				}
			}

			System.out.println("추가가 완료되었습니다.");
			System.out.println();
		}

	}

	private static void showCurrentList(ArrayList<String> playlist) {
		// Show the list of the ArrayList
		// 

		System.out.println("============ 현재 목록 ============");
		int len = playlist.size();

		if (len > 0) {
			for (int i = 0; i < len; i++) {
				System.out.println(i + 1 + "." + playlist.get(i));
			}
		} else {
			System.out.println("재생 목록이 없습니다.");
		}

		System.out.println("===================================");
		System.out.println();

	}

}
