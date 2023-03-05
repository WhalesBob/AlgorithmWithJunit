package boj.codingStudy;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayDeque<Integer> arrayDeque = Stream.iterate(1, x -> x + 1).limit(n).collect(Collectors.toCollection(ArrayDeque::new));
        while(arrayDeque.size() != 1){
            arrayDeque.removeFirst();
            arrayDeque.addLast(arrayDeque.removeFirst());
        }
        System.out.println(arrayDeque.removeFirst());
    }
}