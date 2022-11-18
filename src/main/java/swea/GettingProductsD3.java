package swea;

import java.util.Scanner;

public class GettingProductsD3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int length = sc.nextInt();
            int[][] fields = makeFields(sc,length);
            int sum = getUpRightFiend(fields) + getDownField(fields);
            System.out.printf("#%d %d\n",test_case,sum);
        }
    }
    static int[][] makeFields(Scanner sc, int length){
        int[][] fields = new int[length][length];
        for(int i = 0; i < length; i++){
            String[] get = sc.next().split("");
            for(int j = 0; j < length; j++){
                fields[i][j] = Integer.parseInt(get[j]);
            }
        }
        return fields;
    }
    static int getUpRightFiend(int[][] fields){
        int sum = 0;
        int middle = fields.length / 2;
        for(int i = 0; i <= middle; i++){
            int start = middle - i;
            int end = middle + i;
            for(int j = start; j <= end; j++){
                sum += fields[i][j];
            }
        }
        return sum;
    }
    static int getDownField(int[][] fields){
        int sum = 0;
        int middle = fields.length / 2;
        for(int i = fields.length - 1; i > middle; i--){
            int start = Math.abs(i-middle);
            int end = fields.length - 1 - Math.abs(i-middle);
            for(int j = start; j <= end; j++){
                sum += fields[i][j];
            }
        }
        return sum;
    }
}
