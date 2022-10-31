package Programmers;

import java.util.HashMap;
import java.util.Map;

public class DiscountParty {
    static final int discountDay = 10;
    public int solution(String[] want, int[] number, String[] discount){
        // 일정 금액을 지불하면 10 일 동안 회원자격을 부여함
        // 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 함.
        // 자신이 원하는 제품과, 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려한다

        // 할인하는 제품은 하루에 "하나씩"만 구매할 수 있다.

        // ex) 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개
        // 15일간 회원을 대상으로 할인하는 제품이, 날짜 순서대로
        // 치킨,사과,사과,바나나,쌀,사과,돼지고기,바나나, 돼지고기. ...

        // 첫째 날부터 열흘간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입 하지 않는다
        // 둘째날부터 열흘 간에는 바나나를 원하는만큼 할인구매할 수 없기 때문에 둘째날에도 회원가입하지 않는다.
        // 3,4,5 째 날부터 각각 열흘은, 원하는 제품과 수량이 일치하기 때문에 셋 중 하루에 회원가입하려 한다.
        // 회원등록 시 정현이가 원하는 제품을 "모두 할인 받을 수 있는 회원등록 날짜의 "총 일수" 를 return
        // 하는 solution 을 만들자.

        // Want 와 Number 를 매핑하자. 그래서 Map 을 만들고
        // discount 길이가 100,000 이다 보니, 다 하는건 위험할 수 있다.
        // 실시간으로 읽어가면서, 맞으면 받...고,,,
        // 아니다. 이거는 어차피 모두 돌려줘야 함. 차라리 전체를 가는게 나을 수 있다.

        // 그래도 처음부터 읽어나가는 것이 좋다.
        // want, number 하는 거는 미리 만들고, discount 도 빼고넣는거는 만들자.
        // 그래서 포함관계에 있으면 count++, 아니면 안한다.

        // 바로 넣고, 부족한 부분은 디버깅으로 채우는 전략...? 나쁘지는 않은것 같아.
        int count = 0;
        Map<String, Integer> wantMap = makeMap(want,number);
        Map<String, Integer> discountMap = initialDiscountMap(discount);

        for(int i = 0; i <= discount.length - discountDay; i++){

            try{
                if(isDiscountContains(wantMap,discountMap)){
                    count++;
                }
            }catch(NullPointerException ignored){}

            if(i < discount.length - discountDay){
                updateDiscountMap(discountMap,discount,i);
            }
        }

        return count;
    }
    static Map<String,Integer> makeMap(String[] want, int[] number){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i],number[i]);
        }
        return map;
    }
    static Map<String, Integer> initialDiscountMap(String[] discount){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < discountDay; i++){
            try{
                int count = map.get(discount[i]);
                map.replace(discount[i],count + 1);
            }catch(NullPointerException ex){
                map.put(discount[i],1);
            }
        }
        return map;
    }
    static void updateDiscountMap(Map<String, Integer> map, String[] discount, int previousStart){
        int value = map.get(discount[previousStart]);
        if(value == 1){
            map.remove(discount[previousStart]);
        }else{
            map.replace(discount[previousStart], value -1);
        } // 기존것 삭제.(하나만 남았을 경우에는 아예 지우고, 아니면 그냥 하나 내리기

        // 다음 것 넣기
        // 0,1,2,3,4,5,6,7,8,9 번째 있었으면, 0번째 것 지우고,(previousStart : 0)
        // 10번째 것 넣기. ( previousStart + discountDay)

        try{
            int nextCount = map.get(discount[previousStart + discountDay]);
            map.replace(discount[previousStart + discountDay],nextCount + 1);
        }catch(NullPointerException ex){
            map.put(discount[previousStart + discountDay],1);
        }

    }
    static boolean isDiscountContains(Map<String, Integer> wantMap, Map<String, Integer> discountMap) throws NullPointerException{

        wantMap.forEach((wantKey,value) -> {
            int howMany = discountMap.get(wantKey);
            if( howMany < wantMap.get(wantKey)){
                throw new NullPointerException();
            }
        });
        return true;
    }
}
