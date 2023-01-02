package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        answer = 0;
        solution(N,r,c);
        System.out.println(answer);
    }
    static void solution(int N, int r, int c){
        // 일단 N 이 어떤 수인지, 그리고 r,c 가 어떤 "사분면" 에 속하는지 파악해야 한다.

        // 필요한 로직
        // 사분면 파악하는 로직.
        // 재귀를 타기 전에, 얼마가 더 필요한지 파악하는 로직.
        // 애초에 그러면 재귀를 타고타면, 전역 변수 answer 를 만들어서 더해주는 게 좋다.

        // 애초에 N = 8 을 기준으로 하면, 16,32,48,64 순으로 시작한다.
        // 그렇게 치면, 그냥 1부터 시작한다 치고 맨 마지막에 하나 빼주면 된다.

        // N = 8 이었을 때, 하나 나누어 주고, 얼마를 더해야 하는지 파악한 후에 더해 준다.
        // 그런 뒤에, N 을 하나 나누어 주고, startX, startY 를 파악해서 거기서 새로 시작하면 된다.

        // 만약에 맨 처음 재귀를 탄다 치자. 4,3 이다.
        // 그러면 4,3 을 읽고, 3번째 사분면에 간다는 사실을 파악하면 된다.
        // 그럼 그냥 16 * 2 를 더해 주고, startX, startY 를 기입해 준 뒤, N = 4 로 줄인다.

        findValue(r,c,0,0,N);
    }
    static void findValue(int y,int x,int startX, int startY, int N){
        if(N == 0){
            return;
        }

        int halfValue = (int)Math.pow(2,N-1);

        boolean lessY = (y < startY + halfValue);
        boolean lessX = (x < startX + halfValue);
        boolean firstQuarter = lessX && lessY;
        boolean secondQuarter = !lessX && lessY;
        boolean thirdQuarter = lessX && !lessY;

        if(firstQuarter){
            findValue(y,x,startX,startY,N-1);
        }else if(secondQuarter){
            answer += (int)Math.pow(halfValue,2);
            findValue(y,x,startX + halfValue,startY, N-1);
        }else if(thirdQuarter){
            answer += (int)Math.pow(halfValue,2) * 2;
            findValue(y,x,startX, startY + halfValue, N-1);
        }else{
            answer += (int)Math.pow(halfValue,2) * 3;
            findValue(y,x,startX + halfValue, startY + halfValue,N-1);
        }
    }
}
