package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CuttingRollCake {
    public int solution(int[] topping){
        // 잘라보고, 어느쪽이 먼저 더 큰지 파악한 다음에 한쪽으로만 잘라가면 되는거 아닌가?
        // 중앙을 먼저 잘라본다.
        // 형한테 전부다 맵으로 준 다음에, 하나씩 넘기면 된다는데?


        // Set 이 아니라 처음부터 Map 으로 잡고, 맨 끝에서부터 하나씩 주면서 동생을 Set 으로 하고
        // 형이 Map 에서 하나씩 지우면?

        int count = 0;
        Map<Integer, Integer> olderMap = new HashMap<>();
        Set<Integer> youngerSet = new HashSet<>();

        for (int toppingElement : topping) {
            if (olderMap.containsKey(toppingElement)) {
                olderMap.replace(toppingElement, olderMap.get(toppingElement) + 1);
            } else {
                olderMap.put(toppingElement, 1);
            }
        }

        for(int i = topping.length-1; (i >= 0) && (olderMap.size() >= youngerSet.size()); i--){

            int thatToppingCount = olderMap.get(topping[i]);
            if(thatToppingCount == 1){
                olderMap.remove(topping[i]);
            }else{
                olderMap.replace(topping[i],thatToppingCount -1);
            }

            youngerSet.add(topping[i]);

            if(olderMap.size() == youngerSet.size()){
                count++;
            }
        }
        return count;

    }
}
