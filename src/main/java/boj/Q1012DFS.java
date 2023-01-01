package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Q1012DFS {
    static int cabbageGroupCount;
    static List<List<Integer>> direct = List.of(List.of(-1,0),
                                                List.of(0,-1),
                                                List.of(1,0),
                                                List.of(0,1));
    public static void main(String[] args) throws IOException {
        // 만약에, DFS 로 이거를 한다면 어떻게 하면 되는가?
        // 원래는 Node 로 하고, for 문을 돌면서 방문한다.

        // visited 나, 다른 부분을 어떻게 처리하면 되는가?
        // 방문하지 않은 좌표에서, dfs 로써 돌수 있는 것이 나오면 싹 다 집어넣으면 된다.
        // 그럼 아예 상하좌우 돌면서 visited 할 수 있는 부분은 모두 집어넣고 끝낸다.
        // 여기서 기존에 있는거 최적화할 수 잇는 방법이 없나?

        // 그냥 해보자.
        cabbageGroupCount = 0;
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
        searchGround(cabbageGround);
        System.out.println(cabbageGroupCount);
        cabbageGroupCount = 0;
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
    static void searchGround(int[][] cabbageGround){
        for(int y = 0; y < cabbageGround.length; y++){
            for(int x = 0; x < cabbageGround[0].length; x++){
                if(cabbageGround[y][x] == 1){
                    findByDFS(x,y,cabbageGround);
                    cabbageGroupCount++;
                }
            }
        }
    }
    static void findByDFS(int x, int y, int[][] cabbageGround){
        // 처음에 없으면 여기서 해야 한다.

        cabbageGround[y][x] = 0;
        for (List<Integer> forDirection : direct) {
            int moveY = y + forDirection.get(1);
            int moveX = x + forDirection.get(0);
            if (isInBound(moveX, moveY, cabbageGround) && cabbageGround[moveY][moveX] == 1) {
                findByDFS(moveX, moveY, cabbageGround);
            }
        }
    }
    static boolean isInBound(int x, int y, int[][] cabbageGround){
        return (0 <= y && y < cabbageGround.length) && (0 <= x && x < cabbageGround[0].length);
    }
}
