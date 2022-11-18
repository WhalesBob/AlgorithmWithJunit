package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumPrizeD3 {
    static int realCount;
    public static void main(String[] args) {
        MaximumPrizeD3 sol = new MaximumPrizeD3();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int maxCount = sc.nextInt();
        realCount = 0;
        System.out.println(sol.makeSolution(input,maxCount));
    }
    public int makeSolution(int input, int maxCount){
        int maxNumber = makeMaxNumber(maxCount,input,0);
        int remainCount = maxCount - realCount;
        if(remainCount % 2 == 1){
            return swapTwo(makeNumberArray(maxNumber));
        }else{
            return maxNumber;
        }
        // 먼저 선택정렬 부분에다가 while 문을 같이 비빈다

    }
    int makeMaxNumber(int count, int number, int firstIndex){
        if(count == 0){
            return number;
        }

        int[] numberArray = makeNumberArray(number);
        ArrayList<Integer> maxIndexes = makeMaxIndexes(numberArray,firstIndex);
        // 그래서, 가장 큰 같은 숫자가 2개 이상이면?
        // maxIndexes 가 null 이면, 그 숫자에서는 바꿀게 없는거디.
        // 그냥 count 낮추지 말고, 다음 것이랑 비교해서 보자.
        if(maxIndexes == null){
            if(firstIndex == numberArray.length-1){
                return number;
            }else{
                return makeMaxNumber(count,number,firstIndex+1);
            }
        }else{
            return selectMax(maxIndexes,numberArray,firstIndex,count);
        }
    }
    int selectMax(ArrayList<Integer> maxIndexes, int[] numberArray, int firstIndex, int count){
        if(maxIndexes.size() == 1){
            realCount++;
            return makeMaxNumber(count-1,swapNumber(numberArray,firstIndex,maxIndexes.get(0)),firstIndex+1);
        }else{
            // 2 이상이면?
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < maxIndexes.size(); i++){
                realCount++;
                int value = makeMaxNumber(count-1,swapNumber(numberArray,firstIndex,maxIndexes.get(i)),firstIndex+1);
                if(max < value){
                    max = value;
                }
            }
            return max;
        }
    }

    ArrayList<Integer> makeMaxIndexes(int[] numberArray, int firstIndex){
        int max = numberArray[firstIndex];
        ArrayList<Integer> maxIndexes = new ArrayList<>();
        for(int i = firstIndex; i < numberArray.length; i++){
            if(max <= numberArray[i]){
                if(max < numberArray[i]){
                    max = numberArray[i];
                    maxIndexes.clear();
                    maxIndexes.add(i);
                }else{
                    maxIndexes.add(i);
                }
            }
        }
        if(max == numberArray[firstIndex]){
            return null;
        }else{
            return maxIndexes;
        }
    }
    int[] makeNumberArray(int input){
        String[] stringArray = Integer.toString(input).split("");
        int[] numberArray = new int[stringArray.length];
        for(int i = 0; i < numberArray.length; i++){
            numberArray[i] = Integer.parseInt(stringArray[i]);
        }
        return numberArray;
    }

    int swapNumber(int[] array, int a, int b){
        int[] newArray  = array.clone();
        int t;
        t = newArray[a];
        newArray[a] = newArray[b];
        newArray[b] = t;
        return arrayToInteger(newArray);
    }

    int arrayToInteger(int[] array){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            builder.append(array[i]);
        }
        return Integer.parseInt(builder.toString());
    }
    int swapLastTwo(int[] array){
        int indexA = array.length - 1;
        int indexB = array.length - 2;
        return swapNumber(array,indexA,indexB);
    }
    int swapTwo(int[] array){
        int[] newArray = array.clone();
        Arrays.sort(newArray);
        boolean isSameExists = false;

        for(int i = 1; i < newArray.length; i++){
            if(newArray[i-1] == newArray[i]){
                isSameExists = true;
                break;
            }
        }

        return isSameExists ? arrayToInteger(array) : swapLastTwo(array);
    }
}
