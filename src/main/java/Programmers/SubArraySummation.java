package Programmers;

import java.util.HashSet;
import java.util.Set;

public class SubArraySummation {
    static int sumOfAll;
    public int solution(int[] elements){

        // 5개 원소 있으면, 5,4,3 까지만 해도된다.
        // 아니면 아예 함수를 새로 파서, generator 만드는것도 답
        // 5 빼기 로 해서, 만들기 도 괜찮다.
        
        // 이번 것의 교훈.
        // 테스트 케이스를, 다양하게 만들어 보자.
        // 무조건 홀수 개가 아니라, 짝수 개일수도 있었다. 이때 돌려보니까 어땠지?
        // 바로 어디가 잘못되었는지 잡아낼 수 있었다

        sumOfAll = 0;
        for (int element : elements) {
            sumOfAll += element;
        }

        Set<Integer> sumSet = new HashSet<>();

        for(int i = elements.length; i >= elements.length/2; i--){
            summary(sumSet,elements,i);
        }
        return sumSet.size() - 1;
    }
    static void summary(Set<Integer> set, int[] elements, int howMany){
        // 주어진 갯수 더하기를 가장 쉽게 하는 방법은?
        // 정렬한다면 ? >> 1,1,4,7,9
        // 하나를 뽑는건 괜찮지. 어차피 나머지 다빼니까 상관없지
        // 두개부터는?
        // 이중 for?

        // 아예 다 엎고 수학적으로 가는 방법은?
        // 그렇다고 합이 다 다르다는 것을 보장할 수는 없다. {1,2,3,4,5}

        // 그렇다면 DP?
        // 3개의 합은, 2개의 합에다가 나머지 하나 더하는 것과 같음?
        // 그렇다면 2개의 합이라는 것을 어떻게 저장할 수 있는지? (값, 배열?)

        // 연속하는!!!! 부분 수열의 합

        for(int index = 0 ; index < elements.length; index++){
            int toAdd = sumOfSubArray(elements,index,howMany);
            set.add(toAdd);
            set.add(sumOfAll - toAdd);
        }
    }
    static int sumOfSubArray(int[] elements, int start, int howMany){
        int sum = 0;
        for(int i = 0; i < howMany; i++){
            int index = (start + i) % elements.length;
            sum += elements[index];
        }
        return sum;
    }
}
