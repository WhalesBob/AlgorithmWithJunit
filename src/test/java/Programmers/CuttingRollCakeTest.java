package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuttingRollCakeTest {

    @Test
    void case1() {
        CuttingRollCake cake = new CuttingRollCake();
        int[] topping = {1,2,1,3,1,4,1,2};
        Assertions.assertEquals(2,cake.solution(topping));
    }

    @Test
    void case2() {
        CuttingRollCake cake = new CuttingRollCake();
        int[] topping = {1,2,3,1,4};
        Assertions.assertEquals(0,cake.solution(topping));
    }
}