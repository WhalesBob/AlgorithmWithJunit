package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NightTacticalWalks2Test {

    @Test
    void case1() {
        int distance = 10;
        int[][] scope = {{3,4},{5,8}};
        int[][] times = {{2,5},{4,3}};
        Assertions.assertEquals(8,NightTacticalWalks2.solution(distance,scope,times));
    }

    @Test
    void case2() {
        int distance = 12;
        int[][] scope = {{7,8},{4,6},{11,10}};
        int[][] times = {{2,2},{2,4},{3,3}};
        Assertions.assertEquals(12,NightTacticalWalks2.solution(distance,scope,times));
    }

    @Test
    void case3() {
        int distance = 10;
        int[][] scope = {{0,2},{6,8}};
        int[][] times = {{4,2},{1,5}};
        Assertions.assertEquals(1,NightTacticalWalks2.solution(distance,scope,times));
    }
    @Test
    void case4() {
        int distance = 10_000_000;
        int[][] scope = {{3,4},{5,8}};
        int[][] times = {{2,5},{4,3}};
        Assertions.assertEquals(8,NightTacticalWalks2.solution(distance,scope,times));
    }

    @Test
    void case5(){
        int distance;
        int[][] scope;
        int[][] times;

    }
}