package firstMiniPractice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static firstMiniPractice.LottoProgram.*;


public class Practice07 {

    public static void main(String[] args) {

         /*
            서채영
            로또 당첨 프로그램 ////
         */

        Scanner sc = new Scanner(System.in); // 사용자에게 입력받기 위한 scanner 클래스 사용
        LottoProgram start = new LottoProgram(); //LottoProgram 클래스 객체 생성

        System.out.println("[로또 당첨 프로그램]");
        System.out.println();

        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10): ");
        lottoNumber = sc.nextInt(); // 사용자가 구매할 로또 갯수를 입력받음
        userLottoNumList = new int[lottoNumber+1][6]; // 입력받은 로또 갯수+1(=1등 번호)를 이차원 배열로 생성
        start.lottoNumCreate(lottoNumber); // 입력값을 parameter 값으로 lottoNumCreate 메소드를 실행한다

        System.out.println("[로또 발표]");
        lottoPrizeNum = userLottoNumList[lottoNumber]; // 1등 당첨 번호 리스트
        start.lottoPrizeNumView(); // 1등 당첨 번호 불러오는 메소드 실행

        System.out.println("[내 로또 결과]");
        lottoResult = userLottoNumList[lottoNumber];
        start.lottoResultView(lottoNumber);


    }

}

class LottoProgram {
    public static int lottoNumber = 0; //로또 갯수
    public static int[][] userLottoNumList; // 사용자의 로또 번호
    public static int[] lottoPrizeNum; // 1등 당첨 번호
    public static int[] lottoResult; // 로또 결과
    public static  String[] userLottoOrder = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", ""}; // 로또 번호 앞 알파벳 주문 번호
    Random random = new Random();

    public void lottoNumCreate(int lottoNumber) {

        if (lottoNumber <= 10) { // 로또 구매 갯수는 1 ~ 10 개까지만

            for (int i = 0; i < lottoNumber+1; i++) { // 입력한 구매 갯수 만큼 반복문으로 생성해서 바깥쪽 배열에 넣어줌 (+1은 1등번호 추가)

                for (int j = 0; j < 6; j++) { // 랜덤함수로 로또 번호 6개 생성
                    int lotto = random.nextInt(45)+1;
                    userLottoNumList[i][j] = lotto; // 랜덤 함수를 사용해서 [j]개의 행, [i]개의 열을 돌면서 랜덤함수로 들어간 데이터 모두 출력

                    for (int k = 0; k < j; k++) { //생성한 로또 번호의 숫자 중복 제거
                        if (userLottoNumList[i][j] == userLottoNumList[i][k]) {
                            j--;
                            break;
                        }
                    }
                }
            }
        }

        // 생성된 로또 번호들 오름차순으로 정렬
        for (int i = 0; i < userLottoNumList.length; i++) { //로또 리스트 만큼 반복
            int[] sortNum = userLottoNumList[i]; // sortNum 배열에 담아주고
            Arrays.sort(sortNum); // 오름차순으로 정렬시킴
        }

        //생성된 로또 번호 구매 갯수 만큼 출력할 때
        for (int i = 0; i < userLottoNumList.length - 1; i++) { //-1은 1등 번호 제외 해야 하니까
            int[] lottoNum = userLottoNumList[i];

            System.out.printf(userLottoOrder[i]+"\t"); // 로또 번호 앞 알파벳

            for (int j = 0; j < 6; j++) { // 출력 방식
                if (j != 5) { // j!=5
                    System.out.printf("%02d,", lottoNum[j]); // 따옴표가 5개까지만 있어야 하니까 (6개 출력이라서) 5가 아니면 ","를 포함해서 출력하고
                } else { // 따옴표가 5개 이상이면 ","가 없는 번호가 출력 되어야 함
                    System.out.printf("%02d", lottoNum[j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void lottoPrizeNumView() {

        System.out.printf("\t");
        for (int i = 0; i < 6; i++) {
            if (i != 5) {
                System.out.printf("%02d,", lottoPrizeNum[i]);
            } else {
                System.out.printf("%02d", lottoPrizeNum[i]);
            }
        }
        System.out.println();
        System.out.println();
    }

    public void lottoResultView(int lottoNumber) {

        for (int i = 0; i < lottoNumber; i++) {

            System.out.printf(userLottoOrder[i]+"\t");

            int count = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (userLottoNumList[i][j] == lottoResult[k]) {
                        count++; // 일치하는 갯수 만큼 +1씩 변수에 더해줌
                    }
                }
                if (j != 5) {
                    System.out.printf("%02d,", userLottoNumList[i][j]);
                } else {
                    System.out.printf("%02d", userLottoNumList[i][j]);
                    System.out.printf(" => %d개 일치\n", count);
                }
            }
        }
    }




}
