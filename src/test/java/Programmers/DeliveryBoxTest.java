package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryBoxTest {

    @Test
    void case1(){
        DeliveryBox box = new DeliveryBox();
        int[] order = {4,3,1,2,5};
        Assertions.assertEquals(2,box.solution(order));
    }

    @Test
    void case2(){
        DeliveryBox box = new DeliveryBox();
        int[] order = {5,4,3,2,1};
        Assertions.assertEquals(5,box.solution(order));
    }

    @Test
    void case3(){
        DeliveryBox box = new DeliveryBox();
        int[] order = {2,1,4,3,6,5,8,7,10,9};
        Assertions.assertEquals(10,box.solution(order));
    }
    @Test
    void case4(){
        DeliveryBox box = new DeliveryBox();
        int[] order = {1,2,4,3,5};
        Assertions.assertEquals(5,box.solution(order));
    }
    @Test
    void case5(){
        DeliveryBox box = new DeliveryBox();
        int[] order = {1,2,3,4,5};
        Assertions.assertEquals(5,box.solution(order));
    }

    @Test
    void case6(){
        DeliveryBox box = new DeliveryBox();
        int[] order = {5,1,3,2,4};
        Assertions.assertEquals(1,box.solution(order));
    }
    @Test
    void case7(){

        DeliveryBox box = new DeliveryBox();
        int[] order = {5,1,3,2,4};
        Assertions.assertEquals(1,box.solution(order));
    }
}