package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            calculate(br);
        }
    }
    static void calculate(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int xLength = Integer.parseInt(st.nextToken());
        int yLength = Integer.parseInt(st.nextToken());
        int cabbageCount = Integer.parseInt(st.nextToken());

        int[][] cabbageGround = makeGround(br,xLength,yLength,cabbageCount);
        System.out.println(countCabbageGroup(cabbageGround));
    }
    static int[][] makeGround(BufferedReader br,int xLength, int yLength, int cabbageCount) throws IOException{
        int[][] ground = new int[yLength][xLength];
        for(int i = 0; i < cabbageCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ground[y][x] = 1;
        }
        return ground;
    }
    static int countCabbageGroup(int[][] ground){
        Set<Set<Cabbage>> cabbageSet = new HashSet<>();

        for(int y = 0; y < ground.length; y++){
            for(int x = 0; x < ground[0].length; x++){
                if(ground[y][x] == 1){
                    Set<Cabbage> oneCabbageGroup = alreadyInSet(cabbageSet,y,x);
                    if(oneCabbageGroup != null){
                        oneCabbageGroup.add(new Cabbage(x,y));
                    }else{
                        Set<Cabbage> newSet = new HashSet<>();
                        newSet.add(new Cabbage(x,y));
                        cabbageSet.add(newSet);
                    }
                }
            }
        }
        // 만약 그룹들이 "인접" 하는 것이 존재한다면, 그룹들끼리 합쳐야 한다.
        // 이렇게 해서 통과하는 것이 존재한다면, 이렇게도 통과시키고 DFS 로도 풀어 보자.
        // 그리고 어떤 논리적 허점을 갖고 있는 것인지, 더 연습해야 한다.
        // 근데 둘다 Set 으로 해서, 힘들다.

        return cabbageSet.size();
    }
    static Set<Cabbage> alreadyInSet(Set<Set<Cabbage>> cabbageSet, int y, int x){
        for(Set<Cabbage> oneSet : cabbageSet){
            for(Cabbage oneCabbage : oneSet){
                if(isInGroup(oneCabbage,y,x)){
                    return oneSet;
                }
            }
        }
        return null;
    }
    static boolean isInGroup(Cabbage cabbage, int y, int x){
        if(cabbage.y == y){
            return Math.abs(cabbage.x - x) == 1;
        }
        if(cabbage.x == x){
            return Math.abs(cabbage.y - y) == 1;
        }
        return false;
    }

}
class Cabbage{
    int x;
    int y;

    public Cabbage(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
