package swea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumPrizeD3Test {

    MaximumPrizeD3 toCheck = new MaximumPrizeD3();

    @Test
    void case1(){
        int input = 123;
        int output = 321;
        int maxCount = 1;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case2(){
        int input = 2737;
        int output = 7732;
        int maxCount = 1;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case3(){
        int input = 757148;
        int output = 857147;
        int maxCount = 1;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case4(){
        int input = 78466;
        int output = 87664;
        int maxCount = 2;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case5(){
        int input = 32888;
        int output = 88832;
        int maxCount = 2;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case6(){
        int input = 112233;
        int output = 332211;
        int maxCount = 3;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case7(){
        int input = 436659;
        int output = 966354;
        int maxCount = 2;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }

    @Test
    void case8(){
        int input = 777770;
        int output = 777770;
        int maxCount = 5;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }


    @Test
    void case9(){
        int input = 456789;
        int output = 987645;
        int maxCount = 10;
        Assertions.assertEquals(toCheck.makeSolution(input,maxCount),output);
    }
}