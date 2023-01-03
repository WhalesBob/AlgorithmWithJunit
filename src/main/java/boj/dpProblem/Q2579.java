package boj.dpProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {
    static int[][] maxScores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairCount = Integer.parseInt(br.readLine());

        maxScores = new int[2][stairCount];
        int[] stairScore = new int[stairCount];
        for(int i = 0; i < stairCount; i++){
            stairScore[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxScoreOfStair(stairScore,stairCount,false));

    }
    static int getMaxScoreOfStair(int[] stairScore, int n, boolean sequent){
        if(n == 1){
            return stairScore[n-1];
        }
        if(n == 2){
            if(sequent){
                return stairScore[n-1];
            }
            return stairScore[n-1] + stairScore[n-2];
        }
        // 이거, 2차원 배열로 해서 연속으로 올라간 애들과 그렇지 않은 애들을 분리해서 처리해야 줘야 하는 것 같다.
        // 그렇게 해서, 연속으로 올라간 애들과 아닌 애들 중 더 큰 값을 넘겨주는게 맞다.
        // 0은 바로 연속으로 올라오는 애.

        // 이미 위에서 연속으로 올라갔다고 판단되면, 그냥 무조건 두 칸 아래 숫자 받기.

        if(sequent){
            if(maxScores[1][n-1] == 0){
                maxScores[1][n-1] = getMaxScoreOfStair(stairScore,n-2,false) + stairScore[n-1];
            }
            return maxScores[1][n-1];
        }

        if(maxScores[0][n-1] == 0){
            maxScores[0][n-1] = Math.max(getMaxScoreOfStair(stairScore,n-1,true),getMaxScoreOfStair(stairScore,n-2,false)) + stairScore[n-1];
        }
        if(maxScores[1][n-1] == 0){
            maxScores[1][n-1] = getMaxScoreOfStair(stairScore,n-2,false) + stairScore[n-1];
        }
        return Math.max(maxScores[0][n-1],maxScores[1][n-1]);
    }
}
