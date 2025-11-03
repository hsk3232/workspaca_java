package 프로그래머스;

import java.util.Arrays;

public class 배열 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{45, 50, 75}, {89}};
        System.out.println(arr[0].length);
        System.out.println(arr.length);
        System.out.println(arr[1].length);
        System.out.println(arr[0][0]);
        // System.out.println(arr[1][1]); 오류
    }
}
