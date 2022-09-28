package firstMiniPractice;

public class Practice01 {

    public static void main(String[] args) {

         /*
            서채영
            구구단 출력 (String.format 함수 사용)
         */

        System.out.println("[구구단 출력]");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {

                System.out.print(String.format("%02d x %02d = %02d", j, i, i * j));
                System.out.print("   ");
            }
            System.out.println();

        }

    }

}
