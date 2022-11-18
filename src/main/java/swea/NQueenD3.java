package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class NQueenD3 {
    static int count;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        ArrayList<Coordinate> alreadyPuttedQueen = new ArrayList<>();
        for(int test_case = 1; test_case <= T; test_case++){
            count = 0;
            int n = sc.nextInt();
            putQueen(n,0,alreadyPuttedQueen);
            System.out.printf("#%d %d\n",test_case,count);
        }
    }

    static void putQueen(int n,int y,ArrayList<Coordinate> puttedQueen){
        if(y == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(promising(y,i,puttedQueen)){
                ArrayList<Coordinate> newPutList = makeClone(puttedQueen);
                newPutList.add(new Coordinate(y,i));
                putQueen(n,y+1,newPutList);
            }
        }
    }

    static boolean promising(int y, int x,ArrayList<Coordinate> alreadyPuttedQueen){
        Coordinate newPut = new Coordinate(y, x);
        for (Coordinate coordinate : alreadyPuttedQueen) {
            if (Coordinate.isSameLine(coordinate, newPut)) {
                return false;
            }
        }
        return true;
    }
    static ArrayList<Coordinate> makeClone(ArrayList<Coordinate> alreadyExists){
        return new ArrayList<>(alreadyExists);
    }
}
class Coordinate{
    int y;
    int x;

    public Coordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static boolean isSameLine(Coordinate A, Coordinate B){
        boolean isSameColumn = (A.x == B.x);
        boolean isSameLineOne = (A.x + A.y) == (B.x + B.y);
        boolean isSameLineTwo = (A.y-A.x) == (B.y- B.x);

        return isSameColumn || isSameLineOne || isSameLineTwo;
    }
}
