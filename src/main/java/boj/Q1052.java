package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N,K));
    }
    static int solution(int N, int K){
        List<Integer> binaryList = whatBinaryNumberNHave(N);
        if(binaryList.size() <= K){
            return 0;
        }
        return whatNumberToAdd(binaryList,K);
    }
    static List<Integer> whatBinaryNumberNHave(int N){
        List<Integer> binaryList = new ArrayList<>();
        int binaryCheck = 23;

        while(N > 0){
            int powNumber = (int)Math.pow(2,binaryCheck);
            if(N >= powNumber){
                binaryList.add(binaryCheck);
                N -= powNumber;
            }
            binaryCheck--;
        }
        return binaryList;
    }
    static int whatNumberToAdd(List<Integer> binaryList, int K){
        int sum = 0, numberToAdd = binaryList.get(K-1)-1;
        while(Math.pow(2,numberToAdd) != 0){
            if(numberToAdd != binaryList.get(K)){
                sum += Math.pow(2,numberToAdd);
            }else{
                if(++K >= binaryList.size()){
                    sum += Math.pow(2,numberToAdd);
                    break;
                }
            }
            numberToAdd--;
        }
        return sum;
    }
}
