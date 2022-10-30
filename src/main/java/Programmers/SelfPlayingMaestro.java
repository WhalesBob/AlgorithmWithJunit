package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class SelfPlayingMaestro {
    public int solution(int[] cards){

        // 카드는 총 100장 있으며, 각 카드에는 1부터 100까지 숫자가 적혀있다
        // 2 이상 100 이하 자연수를 하나 정해, 그 수보다 작거나 같은 숫자 카드들을 준비하고
        // 준비한 카드의 수만큼 작은 상자를 준비하면 게임을 시작한다

        // 준비된 상자 하나하나에 카드를 한장씩 넣고, 상자를 무작위로 섞어 일렬로 나열한다
        // 상자가 일렬로 나열되면, 상자가 "나열된 순서" 에 따라 1번부터 순차적으로 번호를 준다

        // 임의의 상자를 하나 선택하여, 선택한 상자 안의 숫자 카드를 확인한다.
        // 확인한 카드에 적힌 번호에 해당하는 상자를 열어, 카트에 적힌 숫자를 확인한다
        // 열어야 하는 상자가 이미 열려있을 때까지 반복한다

        // 이렇게 연쇄적으로 연 상자들은 1번그룹이다.

        // 1번 상자 그룹을 다른 상자들과 섞이지 않도록 따로 둔다
        // 만약 1번 상자 그룹을 제외하고 남는 상자가 없으면, 그대로 게임이 종료되며,
        // 이때 획득하는 점수는 0점이다

        // 남은 상자들 중 다시 임의의 상자를 하나 골라, 같은 방식으로 연쇄적으로 열었던 것이 2번 상자그룹이다

        // 1번 상자 그룹에 속한 상자 수와, 2번의 상자수를 곱한 것이 게임의 점수이다
        // 상자 안에 들어 있는 카트 번호가 순서대로 담긴 배열 cards 가 매개변수로 주어질 때
        // 게임에서 얻을 수 있는 최고점수를 리턴해라.

        // 이거는 직접 열어보면서 해야 된다.
        // 다행히 100번밖에 안된다. 이거는 그냥 신경안쓰면서 달려도 된다는 말이다.

        // 하나하나 열어보면서 달려도 된다는 말이다. 단, 한번 트라이된 배열은 저장하면서 달리는 게 좋다.
        // 그냥 그럴 것이 아니라 , 객체를 하나 새로 지정해서 그 안에서 boolean 식으로 저장하면서 달리는 것도 좋아 보인다.
        // 애초에, 지정된 것을 다 지정하고, 제일 큰거 두개로 달리면 될거같다.

        // 지정할 필요도 없는데? 애초에 그냥 카운팅만 하면 되는데? 굳이 Set 넣을 필요가 없는데?
        // 그럼 모임은 몇개로 지정되는지 알아보자. 그냥 ArrayList 에다가 집어넣으면 될것같다. 거기서 Sorting 하고, 맨끝 두개로 하면된다.
        // 만약에 ArrayList<> 한개밖에 없으면, 그냥 그것대로 0을 리턴하면 될것이다. ArrayList<> 가 한개인지, 여러개인지 판단하면서 진행하자 .

        // 교훈?
        // 딱히 뭐... 이거는 그냥 했는데 맞았다.
        // 다만 쪼끔? 아쉬운 부분이 있었다면, 그냥 reverseOrder() 놓고 역으로 해준 다음에, 0번째 1번째 넣었으면 딱 맞았을듯?

        ArrayList<Integer> cases = new ArrayList<>();
        CardNode[] nodes = new CardNode[cards.length];
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new CardNode(cards[i],i);
        }

        for(int i = 0; i < nodes.length; i++){
            if(!nodes[i].isChecked){
                collectCard(cases,nodes,i);
            }
        }

        Collections.sort(cases);

        int size = cases.size();
        return (size == 1) ? 0 : cases.get(size-1) * cases.get(size-2);
    }
    static void collectCard(ArrayList<Integer> cases, CardNode[] nodes, int start){
        int index = start;
        int count = 0;
        do{
            CardNode node = nodes[index];
            node.isChecked = true;
            index = node.number-1;
            count++;
        }while(index != start);

        cases.add(count);
    }
}
class CardNode{
    int number;
    int index;
    boolean isChecked;

    public CardNode(int number, int index) {
        this.number = number;
        this.index = index;
        this.isChecked = false;
    }
}
