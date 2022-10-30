package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelfPlayingMaestroTest {

    @Test
    void case1() {
        SelfPlayingMaestro self = new SelfPlayingMaestro();
        int[] cards = {8,6,3,7,2,5,1,4};
        Assertions.assertEquals(12,self.solution(cards));
    }
}