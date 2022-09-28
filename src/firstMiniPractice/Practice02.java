package firstMiniPractice;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {

        /*
            서채영
            캐시백 계산 프로그램 (최대 캐시백은 300까지, 백원 단위, 캐시백은 결제금액의 10프로)
         */

        Scanner sc = new Scanner(System.in);
        int pay = 0;
        int cashBack = 0;

        System.out.println("[캐시 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액): ");
        pay = sc.nextInt();
        cashBack = (int) (Math.floor(pay / 10));
        cashBack = cashBack > 300 ? 300 : cashBack;

        System.out.printf("결제금액은 %d원이고, 캐쉬백은 %d입니다.", pay,(cashBack / 100) *  100);

        sc.close();

    }


}
