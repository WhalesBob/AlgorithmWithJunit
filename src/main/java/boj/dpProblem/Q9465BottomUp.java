package boj.dpProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = makeStickers(br, n);
            System.out.println(getMaxStickers(stickers));
        }
    }

    static int[][] makeStickers(BufferedReader br, int n) throws IOException {
        int[][] stickers = new int[2][n];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                stickers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return stickers;
    }
    static int getMaxStickers(int[][] stickers){
        int[][] maxScore = new int[2][stickers[0].length];

        if(stickers[0].length == 1){
            return Math.max(stickers[0][0],stickers[1][0]);
        }
        maxScore[0][0] = stickers[0][0];
        maxScore[1][0] = stickers[1][0];
        maxScore[0][1] = stickers[1][0] + stickers[0][1];
        maxScore[1][1] = stickers[0][0] + stickers[1][1];

        for(int x = 2; x < maxScore[0].length; x++){
            for(int y = 0; y <= 1; y++){
                int opposite = Math.abs(1-y);
                maxScore[y][x] = Math.max(maxScore[opposite][x-1],maxScore[opposite][x-2]) + stickers[y][x];
            }
        }

        return Math.max(maxScore[0][stickers[0].length-1], maxScore[1][stickers[0].length-1]);

    }

}