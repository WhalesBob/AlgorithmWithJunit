package Programmers;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MakeTwoQueuesEqual {
    public int solution(int[] queue1, int[] queue2) {
        // 길이가 같은 두 큐가 주어진다. 하나의 큐를 골라 원소를 추출하고, 추출된 원소를 다른 큐에 집어넣는
        // 작업을 통해, 각 큐의 원소 합이 같도록 만들려고 한다.
        // 필요한 작업의 최소 횟수를 구하고자 한다
        // 한번의 pop 과 한번의 insert 를 묶어서 작업을 1회 수행한 것으로 간주한다

        // 이 문제에서는 Queue 를 배열로 표현하며, 원소가 배열앞쪽에 있을수록 먼저 집어넣는 원소임을 의미힌다
        // Long Type 을 고려할 필요가 있다.
        int count = 0;
        long sumOne = summation(queue1), sumTwo = summation(queue2);
        SelfMakeQueue<Integer> queueOne = makeQueue(queue1), queueTwo = makeQueue(queue2);

        try{
            do{
                long value;
                if(sumOne < sumTwo){
                    value = popAndInsertValue(queueOne,queueTwo,sumOne,sumTwo);
                    sumTwo -= value; sumOne += value;
                }else{
                    value = popAndInsertValue(queueTwo,queueOne,sumTwo,sumOne);
                    sumOne -= value; sumTwo += value;
                }
                if(value == -1){
                    return -1;
                }
                count++;
            }while(sumOne != sumTwo);
        }catch(NoSuchElementException ex){
            return -1;
        }

        return count;
    }
    static long popAndInsertValue(SelfMakeQueue<Integer> small, SelfMakeQueue<Integer> large, long smallSum, long largeSum) throws NoSuchElementException{
        if(large.size() == 1 && smallSum < largeSum){
            return -1;
        }
        int value = large.pop();
        small.insert(value);
        return value;
    }
    static long summation(int[] array){
        long sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
    static SelfMakeQueue<Integer> makeQueue(int[] array){
        SelfMakeQueue<Integer> queue = new SelfMakeQueue<>();
        for(int i = 0; i < array.length; i++){
            queue.insert(array[i]);
        }
        return queue;
    }
}
class SelfMakeQueue<T>{
    // 링크드리스트로 큐 구현하기

    // 구현해야 할 것 : pop, insert, isEmpty 일단아정도
    // pop 인데 한번더 뺄라고 하면, 그냥 에러 던지기(NoSuchElementException)

    LinkedList<T> list;

    public SelfMakeQueue() {
        this.list = new LinkedList<>();
    }

    void insert(T element){
        list.addLast(element);
    }

    T pop(){
        try{
            return list.removeFirst();
        }catch(NoSuchElementException ex){
            ex.printStackTrace();
            throw new NoSuchElementException();
        }
    }

    int size(){return list.size();}
}