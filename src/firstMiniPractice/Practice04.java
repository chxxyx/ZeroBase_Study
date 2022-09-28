package firstMiniPractice;

import java.util.Random;
import java.util.Scanner;

public class Practice04 {

    public static void main(String[] args) {

         /*
            서채영
            주민등록번호 계산 프로그램
         */

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        String userYear;
        String userMonth;
        String userDay;
        String userSex;
        String userBackNum;

        System.out.println("[주민등록번호 계산]");


        System.out.print("출생년도를 입력해 주세요.(yyyy): ");
        userYear = sc.nextLine();
        userYear = userYear.substring(2); //문자열 자르기(인덱스 번호)
        System.out.print("출생월을 입력해 주세요.(mm): ");
        userMonth = sc.nextLine();
        System.out.print("출생일을 입력해 주세요.(dd): ");
        userDay = sc.nextLine();
        System.out.print("성별을 입력해 주세요.(m/f): ");
        userSex = sc.nextLine();

        //남, 여 번호
        userBackNum = "m".equals(userSex) ? "3" : "4" ;

        sb.append(userYear).append(userMonth).append(userDay).append("-").append(userBackNum);

        for (int i=0; i<6; i++) {
            int ran = random.nextInt(9)+1; //  random.nextInt() 사용하기 (0~9 = 범위)
            sb.append(ran);
        }

        String str = sb.toString();
        System.out.println(str);





//        for (int i=0; i<6; i++) {
//            int ran = (int) (Math.random()*9);
//            userBackNum += ran;
//        }
//
//        System.out.print(userYear+userMonth+userDay+"-"+userBackNum);



//          내가 한 거
//        System.out.print(userYear+userMonth+userDay+"-"+userBackNum);
//
//        for (int i=0; i<6; i++) {
//            System.out.print((int) (Math.random()*9));
//
//        }

        //
//        int a = 1;
//        String b = "3";
//        System.out.println(b+a); //int 형은 string을 더해주기만 해도 형변환








    }
}
