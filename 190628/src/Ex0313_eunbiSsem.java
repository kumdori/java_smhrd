import java.util.ArrayList;
import java.util.Scanner;

public class Ex0313_eunbiSsem {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      ArrayList<String> musiclist = new ArrayList<String>();

      ArrayList<ArrayList<String>> allPlayList = new ArrayList<ArrayList<String>>();
      ArrayList<String> playListName = new ArrayList<String>();
      boolean isRunning = true;

      while (isRunning) {
         System.out.print("[1]노래추가 [2]노래삭제 [3]PlayList추가 [4]PlayList조회 [5]종료");

         switch (scan.nextInt()) {
         case 1:
            musicAdd(musiclist, scan);
            break;
         case 2:
            musicDelete(musiclist, scan);
            break;
         case 3:
            System.out.print("PlayList이름 >> ");
            String name = scan.next();
            
            
            playListName.add(name);
            allPlayList.add(musiclist);
            break;
         case 4:
            System.out.println("0. 새로운 트랙");
            print(playListName);
            System.out.print("index >> ");
            int choice = scan.nextInt();
            if (choice == 0) {
               musiclist = new ArrayList<String>();
            }else {
               musiclist = allPlayList.get(choice - 1);
            }
            
            break;
         case 5:
            isRunning = false;
            System.out.println("종료되었습니다.");
            break;
         }
      }
   }



   private static void musicDelete(ArrayList<String> current, Scanner scan) {
      print(current);
      if (current.size() > 0) {
         System.out.print("[1]선택삭제 [2]모두삭제");
         switch (scan.nextInt()) {
         case 1:
            System.out.print("index >> ");
            int index = scan.nextInt();
            current.remove(index - 1);
            break;
         case 2:
            current.clear();
            break;
         }
      }
   }

   private static void musicAdd(ArrayList<String> current, Scanner scan) {
      print(current);
      System.out.print("[1]마지막위치에 추가 [2]원하는 위치에 추가");
      int choice = scan.nextInt();
      System.out.println("노래제목 >> ");
      String music = scan.next();

      switch (choice) {
      case 1:
         current.add(music);
         break;
      case 2:
         System.out.print("index : ");
         int index = scan.nextInt();
         current.add(index - 1, music);
         break;
      }
   }

   private static void print(ArrayList<String> current) {
      if (current.size() == 0) {
         System.out.println("재생목록이 존재하지 않습니다.");
      } else {
         for (int i = 0; i < current.size(); i++) {
            System.out.println(i + 1 + "." + current.get(i));
         }
      }

   }

}