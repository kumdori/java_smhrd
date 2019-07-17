package music;

import java.util.InputMismatchException;

public class Music_main {

	public static void main(String[] args) {
		//

		Music_Controller mc = new Music_Controller();

		boolean end = false;
		int index = 0;

		while (!end) {

			System.out.println("[1]재생  [2]정지  [3]이전곡  [4]다음곡  [5]종료 : ");
			try {
				int mainmenu = mc.scan.nextInt();
				
				switch (mainmenu) {

				case 1:
					mc.playSong(index);
					System.out.println("제목 : "+mc.list.get(index).getSong());
					System.out.println("가수 : "+mc.list.get(index).getSinger());
					System.out.println("제목 : "+mc.list.get(index).getTime());
					System.out.println();
					break;
				case 2:
					mc.mp3.stop();
					break;
				case 3:
					index--;
					if (mc.checkIndex(index)) {
						System.out.println("재생할 노래가 없습니다.");
						System.out.println();
						index++;
					} else {
						mc.playSong(index);
						System.out.println("제목 : "+mc.list.get(index).getSong());
						System.out.println("가수 : "+mc.list.get(index).getSinger());
						System.out.println("제목 : "+mc.list.get(index).getTime());
						System.out.println();
					}
					break;
				case 4:
					index++;
					if (mc.checkIndex(index)) {
						mc.mp3.stop();
						System.out.println("재생할 노래가 없습니다.");
						System.out.println();
						index--;
					} else {
						mc.playSong(index);
						System.out.println("제목 : "+mc.list.get(index).getSong());
						System.out.println("가수 : "+mc.list.get(index).getSinger());
						System.out.println("제목 : "+mc.list.get(index).getTime());
						System.out.println();
					}
					break;
				case 5:
					if (mc.mp3.isPlaying()) {
						mc.mp3.stop();
					}
					System.out.println("종료합니다.");
					end = true;
					break;
				default:
					System.out.println("잘못된 정보입니다. 다시 입력해 주세요.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 정보입니다. 다시 입력해 주세요.");
				mc.scan.nextLine();
			}

		}
		mc.scan.close();

	}

}
