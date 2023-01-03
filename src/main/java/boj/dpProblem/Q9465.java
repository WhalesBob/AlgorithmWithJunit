package boj.dpProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {
    static int[][] maxScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = makeStickers(br,n);
            maxScore = new int[2][n];
            System.out.println(Math.max(getMaxStickers(stickers,n,0),getMaxStickers(stickers,n,1)));
        }
    }
    static int[][] makeStickers(BufferedReader br,int n) throws IOException{
        int[][] stickers = new int[2][n];
        for(int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++){
                stickers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return stickers;
    }
    static int getMaxStickers(int[][] stickers,int n, int upDown){
        if(n == 1){
            return stickers[upDown][0];
        }
        int opposite = Math.abs(1-upDown);
        if(n == 2){
            return stickers[upDown][1] + stickers[opposite][0];
        }

        if(maxScore[opposite][n-2] == 0){
            maxScore[opposite][n-2] = getMaxStickers(stickers,n-1,opposite);
        }
        if(maxScore[opposite][n-3] == 0){
            maxScore[opposite][n-3] = getMaxStickers(stickers,n-2,opposite);
        }
        maxScore[upDown][n-1] = Math.max(maxScore[opposite][n-2],maxScore[opposite][n-3]) + stickers[upDown][n-1];
        return maxScore[upDown][n-1];
    }
}
