package music;

import java.util.ArrayList;
import java.util.Scanner;
import javazoom.jl.player.MP3Player;

public class Music_Controller {
	ArrayList<Music_VO> list = new ArrayList<Music_VO>();
	Scanner scan = new Scanner(System.in);
	MP3Player mp3 = new MP3Player();

	public Music_Controller() {

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

	public void playSong(int index) {
		//
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(list.get(index).getPath());
	}

	public boolean checkIndex(int index) {
		//

		int len = list.size();
		if (index >= len || index < 0) {
			return true;
		} else {
			return false;
		}
	}
	
//	public String toString() {
//		list.get()
//		return list.get(index).getSong()+"/"+list.get(index).getSinger()+"/"+list.get(index).getTime()+"초";
//	}

//	public int next() {
//
//	}
//
//	public int prev() {
//
//	}

}