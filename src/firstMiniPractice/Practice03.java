package firstMiniPractice;

import java.util.Scanner;

public class Practice03 {

    public static void main(String[] args) {

        /*
            서채영
            놀이동산 입장권 계산 프로그램
         */

        Scanner sc = new Scanner(System.in);
        int age = 0;
        int time = 0;
        String discount1 = null;
        String discount2 = null;
        int price = 10000;

        System.out.println("[입장권 계산]");

        System.out.print("나이를 입력해 주세요.(숫자): ");
        age = sc.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자): ");
        time = sc.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n): ");
        discount1 = sc.next();

        System.out.print("복지카드 여부를 입력해 주세요.(y/n): ");
        discount2 = sc.next();

        if (age < 3) {
            price = 0;
        } else if (age < 13 || time >= 17) {
            price = 4000;
        } else if ("y".equals(discount1) || "y".equals(discount2)) {
            price = 8000;
        }

        sc.close();

        System.out.println("입장료: " + price);



    }
}
