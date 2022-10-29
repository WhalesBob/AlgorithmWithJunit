package Programmers;

import java.util.Arrays;

public class NightTacticalWalks {
    public static int solution(int distance, int[][] scope, int[][] times) {

        ScopeAndTimes[] st = new ScopeAndTimes[scope.length];
        for(int i = 0; i < scope.length; i++){
            st[i] = new ScopeAndTimes(scope[i],times[i]);
        }

        Arrays.sort(st);

        for(int i = 0; i < st.length; i++){
            Patrol patrol = new Patrol(st[i].scope,st[i].times);
            if(patrol.activeTime != -1){
                return patrol.activeTime;
            }
        }
        return distance;
    }
}
class ScopeAndTimes implements Comparable<ScopeAndTimes> {
    int[] scope;
    int[] times;

    public ScopeAndTimes(int[] scope, int[] times) {
        this.scope = new int[2];
        this.scope[0] = Math.min(scope[0],scope[1]);
        this.scope[1] = Math.max(scope[0],scope[1]);
        this.times = times;
    }

    @Override
    public int compareTo(ScopeAndTimes o) {
        if(this.scope[0] == o.scope[0]){
            return 0;
        }else{
            return (this.scope[0] > o.scope[0]) ? 1 : -1;
        }
    }
}
class Patrol {
    int[] scope;
    int activeTime;

    public Patrol(int[] scope, int[] time) {
        this.scope = scope;
        this.activeTime = activeTime(scope,time[0],time[1]);
    }
    static int activeTime(int[] scope,int active, int inactive){

        int term = active + inactive;
        int start = 0;
        //active 끝날 때 바로 scope[0] 에 들어오면, 잡은걸로 하자.
        if(active >= scope[0]){
            //return scope[0] == 0 ? 1 : scope[0];
            return active == scope[0] ? scope[0] : scope[0] + 1;
            // 두쪽 다 에서 잡아야 한다는 말.
            // 1번은 여기에 걸린다. 바로 잡을 때의 경우
            // active 가 scope 시작이랑 겹치면 잡음.
            // active 가 scope 과 한칸 겹치면, 다음 부분에서 잡힘.
        }else{
            while(start < scope[0]){
                start += term;
            }// 딱 시작할 때의 경우도 잡아야 한다.
            if(start == scope[0]){
                return scope[0];
            }else{
                return (start < scope[1]) ? start + 1 : -1;
            }
        }
    }
}
