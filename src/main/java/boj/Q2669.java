package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2669 {
    public static void main(String[] args){
        Set<OneRectangle> allSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 4; i++){
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            Set<OneRectangle> rectangle = OneRectangle.addAll(startX,startY,endX,endY);
            if(rectangle.size() == 0){
                continue;
            }
            allSet.addAll(rectangle);
        }

        System.out.println(allSet.size());
    }
}
class OneRectangle{
    int startX;
    int startY;

    public OneRectangle(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public static Set<OneRectangle> addAll(int startX, int startY, int endX, int endY){
        Set<OneRectangle> set = new HashSet<>();
        for(int i = startX; i < endX; i++){
            for(int j = startY; j < endY; j++){
                set.add(new OneRectangle(i,j));
            }
        }
        return set;
    }

    @Override
    public int hashCode(){
        String toHash = (startX + Integer.toString(startY));
        return toHash.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof OneRectangle)){
            return false;
        }
        OneRectangle rec = (OneRectangle)obj;
        return this.startX == rec.startX && this.startY == rec.startY;
    }
}
