package car;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MAIN {

   public static void main(String[] args) {
      DAO dao = new DAO();
      Scanner sc = new Scanner(System.in);
      Random rd = new Random();
      SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//      String out_car = "";



      while (true) {
         String in_time = format1.format(System.currentTimeMillis());
         String car_num = Integer.toString(rd.nextInt(9000) + 1000);
         System.out.print("[1]입장  [2]출차 [3]종료 : ");
         int choice = sc.nextInt();
         if (choice == 1) {

            System.out.println(car_num + "님 환영합니다");

            ArrayList<DTO> list_1 = dao.select_floorseat_1();
            ArrayList<DTO> list_2 = dao.select_floorseat_2();
            ArrayList<DTO> list_3 = dao.select_floorseat_3();
            ArrayList<DTO> list_4 = dao.select_floorseat_4();
            System.out.println("1층 : " + (40 - list_1.size()) + "\n" + "2층 : " + (40 - list_2.size()) + "\n"
                  + "3층 : " + (40 - list_3.size()) + "\n" + "4층 : " + (40 - list_4.size()));


               System.out.println("입장 시간 : " + in_time);
               while (true) {
               System.out.print("자리를 선택하세요 : ");
               int position = sc.nextInt();
               ArrayList<String> list = dao.selectOne(position);

               if (list.size() == 0) {
                  DTO dto = new DTO(car_num, in_time, null, 0, position);
                  int cnt = dao.insert(dto);
                  if (cnt > 0) {
                     System.out.println("입력완료");
                  } else {
                     System.out.println("입력실패");
                  }
                  break;
               } else {
                  System.out.println("다른 자리를 선택하세요.");
               }
            }

            // 만약에 데이터 베이스에서 포지션 i 번에 데이터가 있으면 "다른자리를 선택하시오" 라고 뜨도록
         } else if (choice == 2) {
            String out_time = format1.format(System.currentTimeMillis());
            System.out.print("나가는 차량번호 : ");
            String car_num1 = sc.next();
            car_num = car_num1;
            
            DTO dto = new DTO(out_time, car_num);
            int cnt = dao.update_outtime(dto);
            
            
            //시간-시간 해서 요금만 정해주면 끝. 쿼리문으로
            int fare_sum = 1;
            
            
            DTO dto1 = new DTO(fare_sum, car_num);
            int cnt2 = dao.update_fare(dto1);
            
            
            //이걸 조회하기전에 아웃타임과 fare을 업데이트 시켜줘야함.
            ArrayList<DTO> list = dao.out_selectOne(car_num1);
            for (int i = 0; i < list.size(); i++) {
               System.out.println("차번호 : " + list.get(i).getCar_num() + "\t" + "입장시간 : " + list.get(i).getIn_time()
                     + "\t" + "출차시간 : " + list.get(i).getOut_time() + "\t" + "요금" + list.get(i).getFare_sum());
            }
         } else if (choice == 3) {
            System.out.println("살펴 가세요.");
            break;
         }

      }
      sc.close();
   }
}