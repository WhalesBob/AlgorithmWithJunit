package boj.codingStudy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author WhalesBob
 * @since 2023-03-04
 */
public class Q1427 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strArray = sc.next().split("");
        Arrays.sort(strArray, Collections.reverseOrder());
        for (String str : strArray) {
            bw.write(str);
        }
        bw.flush();
        bw.close();
    }
}