import java.util.LinkedList;

public class LittleTest {
    public static void main(String[] args) {

        try{
            LinkedList<Integer> list = new LinkedList<>();
            list.pop();
        }catch(Exception ex){
            ex.printStackTrace(); // NoSuchElementException 이면, 새로운 Exception 으로 만들어서
            // 구현해보자.



        }
    }
}
