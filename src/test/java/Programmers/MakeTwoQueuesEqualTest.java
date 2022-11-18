package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeTwoQueuesEqualTest {

    MakeTwoQueuesEqual equal = new MakeTwoQueuesEqual();

    @Test
    void case1() {
        int[] queue1 = {3,2,7,2};
        int[] queue2 = {4,6,5,1};
        Assertions.assertEquals(2, equal.solution(queue1,queue2));
    }

    @Test
    void case2() {
        int[] queue1 = {1,2,1,2};
        int[] queue2 = {1,10,1,2};
        Assertions.assertEquals(7, equal.solution(queue1,queue2));
    }

    @Test
    void case3() {
        int[] queue1 = {1,1};
        int[] queue2 = {1,5};
        Assertions.assertEquals(-1, equal.solution(queue1,queue2));
    }
}