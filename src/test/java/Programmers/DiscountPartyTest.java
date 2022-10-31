package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountPartyTest {

    @Test
    void case1() {
        DiscountParty party = new DiscountParty();
        String[] want = {"banana","apple","rice","pork","pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana",
                "rice", "apple", "pork", "banana",
                "pork", "rice", "pot", "banana", "apple", "banana"};

        Assertions.assertEquals(3,party.solution(want,number,discount));
    }
    @Test
    void case2() {
        DiscountParty party = new DiscountParty();
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana",
                "banana", "banana", "banana", "banana"};

        Assertions.assertEquals(0,party.solution(want,number,discount));
    }
}