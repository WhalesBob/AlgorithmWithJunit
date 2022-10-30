package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubArraySummationTest {

    SubArraySummation sum = new SubArraySummation();

    @Test
    void case1() {
        int[] elements = {7,9,1,1,4};
        Assertions.assertEquals(18,sum.solution(elements));
    }

    // 다양하게 넣어 보자.
    // 1. 다 같으면?
    @Test
    void case2(){
        int[] elements = {1,1,1,1,1};
        Assertions.assertEquals(5,sum.solution(elements));
    }
    // 2. 두가지 밖에 없으면?
    @Test
    void case3(){
        int[] elements = {1,2,3}; // 1,2,3,4,5,6
        Assertions.assertEquals(6,sum.solution(elements));
    }

    @Test
    void case4(){
        int[] elements = {1,2,4}; // 1,2,3,4,5,6,7
        Assertions.assertEquals(7,sum.solution(elements));
    }

    @Test
    void case5(){
        int[] elements = {1,1,1,1,1,1,1,1,1,1}; // 1,2,3,4,5,6,7,8,9,10
        Assertions.assertEquals(10,sum.solution(elements));
    }

}