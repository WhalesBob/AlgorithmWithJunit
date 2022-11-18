package swea;

import java.util.Scanner;

public class SumOfPartialNumbersD3 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            count = 0;
            int[] numberArray = makeNumberArray(sc, n);
            countCases(0,0,numberArray,k);
            // 부분 수열의 합이 K 가 되는 경우의 수?
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
    static void countCases(int sum,int index,int[] numberArray, int k){
        if(sum == k){
            count++;
            return;
        }
        if(index >= numberArray.length || sum > k){
            return;
        }

        int added = sum + numberArray[index];
        countCases(added,index + 1,numberArray,k);
        countCases(sum,index+1,numberArray,k);
    }

    static int[] makeNumberArray(Scanner sc, int n){
        int[] numberArray = new int[n];
        for(int i = 0; i < n; i++){
            numberArray[i] = sc.nextInt();
        }
        return numberArray;
    }
}