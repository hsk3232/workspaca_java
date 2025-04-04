package data_ch05;

import java.util.Arrays;

/*
 * void permutate(char []arr, int k)
 * {
 *generate all the permuations of arr[0],..., arr[m] where m은 사이즈
    if (k ==m) {//permutation 출력
    	for (char c : arr)
    		sysout
    }
    else {
    	for (int i = k; i <= m; i++) {
    		swap(arr, k,i);
    		permutate(arr, k+1);
    		swap(arr, k,i);
    	}
    }
 */
public class 실습5_5_2문자열순열실습 {
	static int count = 1;
	
	// 두 요소를 교환하는 함수
    public static void swap(char[] arr, int i, int j) {
    	char t = arr[i]; 
    	arr[i] = arr[j]; 
    	arr[j] = t;
    }
		
    // 주어진 문자 배열의 순열을 생성하는 함수
    public static void permutate(char[] arr, int index) {
    	int m = arr.length;
    	
//    	char[][] temp = new char[arr.length][m];
//    	temp[i][j] = arr[j];
    	
    	
    	if(index == m) {
    		System.out.print("["+ count++ + "]");
    		System.out.println(Arrays.toString(arr));
    		
    		
    	}
    	else {
    		for (int i = 0; i < m; i++) {
    			swap(arr, index, i);
    			permutate(arr, index+1);
    			swap(arr, index, i);
    		}	
    	}
    }

    

    public static void main(String[] args) {
        // 문자열을 문자 배열로 변환
        String l = "abc";
        char[] arr = l.toCharArray();

        // 순열 생성 및 출력
        permutate(arr, 0);
    }
}
