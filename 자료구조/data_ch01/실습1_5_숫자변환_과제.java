package data_ch01;

import java.util.Arrays;

public class 실습1_5_숫자변환_과제 {
	/*
	 * split(" ") parseInt(stringArray[i])
	 */
	// 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
	public static String[] splitSortString(String data) {
		String[] st = data.split(" ");
		Arrays.sort(st);
		return st;
		 
	}

	// 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
	public static int[] convertSortToIntArray(String[] txtArr) {
		int[] arr = new int[txtArr.length];
		for (int i = 0; i < txtArr.length; i++) {
			arr[i] = Integer.parseInt(txtArr[i]);
			
		} Arrays.sort(arr);
		return arr;
	}

	// 문자열 배열 출력 함수
	public static void printStringArray(String[] sortedString) {
//		for (String st : sortedString) {
//			System.out.println(st);
//		}
		System.out.println(Arrays.toString(sortedString));
	}

	// 정수 배열 출력 함수
	public static void printIntArray(int[] sortedString) {
		System.out.println(Arrays.toString(sortedString));
	
	}

	public static void main(String[] args) {
		String input = "12 111 911 921 94 23 214 222";

		// 문자열 배열 정렬 및 출력
		String[] sortedStringArray = splitSortString(input);
		System.out.println("Sorted String Array:");
		printStringArray(sortedStringArray);

		// 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
		int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
		System.out.println("Sorted Integer Array:");
		printIntArray(sortedIntArray);
	}
}
