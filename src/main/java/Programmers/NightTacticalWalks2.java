package Programmers;

public class NightTacticalWalks2 {
    public static int solution(int distance, int[][] scope, int[][] times){
        // 이번문제의 교훈.
        // 1. 먼저 풀이 생각하고 바로 옮기기 전에, 이게 말이 되는 시간복잡도인지? 생각하기
        // 2. 그냥 있는 그대로 문제를 받아들여 보기. 그냥 지나갈 때 하나하나 체크하면 되는거아닌가? 생각하기
        // 3. 일단 단순하게 생각해 보기. 제일 괜찮은것은 오히려 심플일 때도 있다!
        // 3.1 심플하게 생각하지 못한다면 다른 방법을 생각해 보자.

        for(int i = 1; i <= distance; i++){
            for(int j = 0; j < scope.length; j++){
                int after = Math.max(scope[j][0],scope[j][1]);
                int before = Math.min(scope[j][0],scope[j][1]);
                if(before <= i && i <= after){
                    if((i-1) % (times[j][0] + times[j][1]) < times[j][0]){
                        return i;
                    }
                    break;
                }
            }
        }
        return distance;
    }
}
