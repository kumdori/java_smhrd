package music;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class MusicCon {
	ArrayList<Music_VO> list = new ArrayList<Music_VO>();
	Scanner scan = new Scanner(System.in);
	MP3Player mp3 = new MP3Player();
	int index = 0;

	public MusicCon() {

		list.add(new Music_VO("뱅뱅뱅", "빅뱅", "D:\\한종대\\Java Workspace\\Lib\\music\\bangbangbang.mp3", 16));
		list.add(new Music_VO("What is Love", "Twice", "D:\\한종대\\Java Workspace\\Lib\\music\\WhatisLove.mp3", 25));
		list.add(new Music_VO("달라달라", "잇지", "D:\\한종대\\Java Workspace\\Lib\\music\\daladala.mp3", 23));
		list.add(new Music_VO("Believer", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\Believer.mp3", 20));
		list.add(new Music_VO("오빠차", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\brothercar.mp3", 20));
		list.add(new Music_VO("Cheer Up", "Twice", "D:\\한종대\\Java Workspace\\Lib\\music\\cheerup.mp3", 20));
		list.add(new Music_VO("Daddy", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\daddy.mp3", 20));
		list.add(new Music_VO("Dumbdumb", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\dumbdumb.mp3", 20));
		list.add(new Music_VO("Icecreamcake", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\icecreamcake.mp3", 20));
		list.add(new Music_VO("No", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\no.mp3", 20));
		list.add(new Music_VO("party", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\party.mp3", 20));
		list.add(new Music_VO("위아래", "AOA", "D:\\한종대\\Java Workspace\\Lib\\music\\updown.mp3", 20));
		list.add(new Music_VO("uptownpunk", "--", "D:\\한종대\\Java Workspace\\Lib\\music\\uptownpunk.mp3", 20));

	}

	public void playSong() {
		//
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(list.get(index).getPath());
	}

	public int checkIndex(int index) {
		//

		int len = list.size();
		if (index >= len || index < 0) {
			return index;
		} else {
			return -1;
		}
	}

	public void playNext() {
		index++;
		if (this.checkIndex(index) < 0) {
			mp3.stop();
			System.out.println("재생할 노래가 없습니다.");
			System.out.println();
			index--;
		} else {
			this.playSong();
//			System.out.println("제목 : " + list.get(index).getSong());
//			System.out.println("가수 : " + list.get(index).getSinger());
//			System.out.println("제목 : " + list.get(index).getTime());
//			System.out.println();
		}
	}

	public String toString() {

		return list.get(index).getSong() + "/" + list.get(index).getSinger() + "/" + list.get(index).getTime() + "초";
	}
}
