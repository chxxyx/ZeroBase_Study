package firstMiniPractice;

import java.util.Calendar;
import java.util.Scanner;

public class Practice05 {

    public static void main(String[] args) {

        /*
            서채영
            달력 출력 프로그램
         */

        Scanner sc = new Scanner(System.in);
        int year = 0;
        int month = 0;

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        month = sc.nextInt();


        Calendar cal = Calendar.getInstance(); //캘린더 사용위한 캘린더 인스턴스를 변수 cal에 담는다

        System.out.printf("[%d년 %02d월]", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");      //달력 윗 부분
        cal.set(year, month - 1, 1); //시작 날짜를 정함 (month-1 = 캘린더는 0부터 시작해서)

        int week = cal.get(Calendar.DAY_OF_WEEK);
        //  일: 0,  월: 1, 화 : 2, 수: 3, 목 : 4, 금 : 5, 토 : 6 : 각 요일 표현 숫자

        for (int i = 1; i < week; i++) { //일요일이 1이니까 1부터 시작해서 시작 요일 이전은 빈 공간으로 출력되게 함 (\t=tab)
            System.out.print("\t");
        }
                                //해당 월이 가질 수 있는 최댓값까지만
        for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
            System.out.printf("%02d\t", i);
            if(week % 7 == 0) {
                System.out.println();
            }
            week++;
        }

        sc.close();


    }

}









