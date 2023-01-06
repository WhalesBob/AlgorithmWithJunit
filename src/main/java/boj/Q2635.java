package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q2635 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        count = 2;

        int firstData = sc.nextInt();

        int startData = (int)Math.ceil((firstData * (0.61)));
        int endData = (int)Math.ceil((firstData * (0.67)));

        int maxCount = 1;
        int maxData = 0;
        for(int i = startData; i <= endData; i++){
            findData(firstData, i);
            if(maxCount < count){
                maxCount = count;
                maxData = i;
            }
            count = 2;
        }
        bw.write(String.format("%d\n",maxCount));

        int before = maxData;
        int after = firstData - maxData;
        bw.write(String.format("%d %d ",firstData,maxData));
        for(int i = 0; i < maxCount-2; i++){
            bw.write(String.format("%d",after));
            if(i < maxCount - 3){
                bw.write(" ");
            }
            bw.flush();
            int temp = before-after;
            before = after;
            after = temp;
        }
    }
    static void findData(int a, int b){
        if(a - b >= 0){
            count++;
            int newValue = a-b;
            findData(b,newValue);
        }
    }
}
