package boj.dpProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] tokens = makeTokens(br,n);
        int[] count = new int[k+1];

        // 10을 만들 때 사용할 수 있는 케이스
        // 5 를 만드는 경우의 수 + 5 더하기
        // 8 을 만드는 경우의 수 + 2 더하기
        // 9 를 만드는 경우의 수 + 1 더하기

        count[0] = 1;  // 초기 식

        for(int i = 0; i < n; i++ ){
            for(int j = tokens[i]; j <= k; j++){ // 첫 케이스부터 만들고, 그 뒤로 쭉쭉 이어가기.
                count[j] += count[j - tokens[i]];
            }
        }
        System.out.println(count[k]);
    }
    static int[] makeTokens(BufferedReader br,int n) throws IOException{
        int[] tokens = new int[n];
        for(int i = 0; i < n; i++){
            tokens[i] = Integer.parseInt(br.readLine());
        }
        return tokens;
    }
}
