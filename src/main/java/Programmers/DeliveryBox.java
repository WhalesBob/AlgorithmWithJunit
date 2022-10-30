package Programmers;

import java.util.EmptyStackException;
import java.util.Stack;

public class DeliveryBox {
    public int solution(int[] order){
        // 택배상자를 트럭에 싣자.
        // 택배상자는 크기가 모두 같으며, 1번 상자부터 n번 상자까지 번호가 증가하는 순서대로 컨테이너
        // 벨트에 놓여 일렬로 영재에게 전달된다

        // 컨테이너 벨트에 놓인 순서대로 택배상자를 내려 바로 트럭에 싣게 되면,
        // 기사님이 배달하는 순서와 택배상자가 실려 있는 순서가 맞지 않아, 배달에 차질이 생긴다
        // 택배 기사님이 미리 알려준 순서에 맞게 택배 상자를 실어야 한다

        // 컨테이너 벨트의 맨 앞에 놓인 상자가, 현재 트럭에 실어야 하는 순서가 아니라면
        // 그 상자를 트럭에 실을 순서가 될때까지 잠시 다른곳에 보관해야 한다
        // 고객의 물건을 함부로 땅에 둘수 없어, 보조 컨테이너 벨트에 추가 설치했다.

        // 보조 컨테이너 벨트는 앞뒤 이동이 가능하지만, 입구 외에 다른 면이 막혀 있어(Stack)
        // 맨 앞의 상자만 뺄수 있따.

        // 보조 컨테이너 벨트를 이용해도 기사님이 원하는 순서대로 상자를 싣지 못한다면,
        // 상자를 싣지 않는다.

        // 스택 하나를 써서, 제대로 실을 수 있는데까지 실어 보자.

        // order : 택배 기사님이 원하는 상자 순서를 나타내는 정수 배열

        // order 의 길이는 1~ 1_000_000
        // oder 에는 1이상 order 길이 이하의 모든 정수가 한번씩 등장함
        // order[i] 는, 기존의 컨테이너 벨트에 order[i] 번째 상자를 i+1(0으로 치면 i번째) 실어야 함을 의미
        // 그냥 0번째 1번째 순서대로 가자.

        // 1,000,000개 있다 하면, 중간에 끊어야 함. 그래서 무조건 앞에서부터 실시간으로 가는게 좋다
        // Stack은 하나만 선언하면 된다.

        Stack<Integer> stack = new Stack<>();

        // 전략 : 먼저 원하는게 나올때 까지 Stack 에다가 밀어 넣는다
        // 그리고 원하는 게 나왔으면, 그 뒤에 것을 어디에서 빼야하는지 확인한다
        // if) 그 뒤에 것이 더크면, order 에서, 작으면 stack 에서 빼야 한다.
        // 이때, stack 에서 뺀다 하더라도, 바로 stack 앞에 잇는게 아니면, 그냥 거기서 끝낸다.

        int count = 0, n = 0, beltItem = 1;
        while(true){
            if(order[n] != beltItem){
                stack.push(beltItem++);
            }else{
                beltItem++; n++; count++;
                break;
            }
        }// 이렇게 1,2,3 이 들어간다.

        // 없는데 뺄려고 하면?
        // 어케 해야 없는데 빼지?
        // 1,4,2,3,
        try{
            while(n < order.length){
                if(order[n] == beltItem){
                    n++; count++; beltItem++;
                }else{
                    if(order[n] < order[n-1]){ // 앞에 1이라
                        if(stack.pop() == order[n]){
                            count++; n++;
                        }else{
                            break;
                        }
                    }else{
                        stack.push(beltItem++);
                    }
                }
            }
        }catch(EmptyStackException ignored){

        }
        return count;

        // 오늘의 교훈
        // 1. 런타임이 났을 때, 어느 부분에서 유일하게 날법한지? 보기
        // 2. Stack 을 쓰는데 RuntimeError 가 난다? 빈 스택에 접근해서 뺄려고해서 그런건 아닌지? 확인하기


    }
}
