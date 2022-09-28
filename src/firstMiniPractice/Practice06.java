package firstMiniPractice;

import java.util.Random;


public class Practice06 {

    public static void main(String[] args) {

         /*
            서채영
            대선 당선 시뮬레이션
         */


        Random random = new Random();
        int[] voteCount = new int[PresidentVoteSimulation.nextPresident.length];
        PresidentVoteSimulation start = new PresidentVoteSimulation();


        for (int i = 0; i < PresidentVoteSimulation.totalCount; i++) {
            int vote = random.nextInt(4);
            voteCount[vote]++;
            start.voteView(vote, i+1, voteCount);
        }
        start.voteResult(voteCount);

    }
}

class PresidentVoteSimulation {

    public static String[] nextPresident = {"이재명" , "윤석열", "심상정", "안철수"}; // 0 1 2 3
    public static int totalCount = 10000;



    public void voteView(int vote, double currentVote, int[] voteCount) { //투표 진행

        System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s\n"
                , ((currentVote / totalCount) * 100)
                , (int)currentVote
                , nextPresident[vote]
        );

        for (int i = 0; i < nextPresident.length; i++) {
            System.out.printf("[기호:%d] %s: %.2f%%, (투표수: %d)\n"
                    , i+1
                    , nextPresident[i]
                    , ((double)voteCount[i] / currentVote * 100)
                    , voteCount[i]
            );
        }

        System.out.println();

    }

    public void voteResult(int[] voteCount) { // 동률 제거랑 결과 발표
        int presidentIndex = 0;

        for (int i = 0; i < voteCount.length; i++) {
            if(presidentIndex > voteCount[i]) {
                presidentIndex = i ;
            }
        }
        System.out.printf("[투표결과] 당선인: %s\n", nextPresident[presidentIndex]);
    }

}
