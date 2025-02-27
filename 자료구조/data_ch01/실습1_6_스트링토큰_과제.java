package data_ch01;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 실습1_6_스트링토큰_과제 {
	/*
	 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
	 * parseDouble(stringArray[i])
	 */
	// 문자열을 실수로 추출하여 배열에 저장하고 정렬하는 함수
//	int count = 0;
//	while (st.hasMoreTokens()) {
//		arr[count++]= st.nextToken();
//	}
//	 

	
	
	public static String[] extractSortStrings(String msg) {
		StringTokenizer st = new StringTokenizer(msg);
		String[] arr = new String[st.countTokens()];
		while (st.hasMoreTokens()) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = st.nextToken();
				
			} Arrays.sort(arr);
		}
		return arr;
	}

	// 문자열 배열을 실수 배열로 변환한 후 정렬하는 함수
	public static double[] convertSortToDouble(String[] arr) {
		double[] st = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			st[i] = Double.parseDouble(arr[i]);
		}
		Arrays.sort(st);
		return st;
	}

	// 문자열 배열을 실수 배열로 변환

	// 문자열 배열 출력 함수
	public static void printStringArray(String[] array) {
		System.out.println(Arrays.toString(array));
	}

	// 실수 배열 출력 함수
	public static void printDoubleArray(double[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";

		// 실수를 문자열로 추출하고 정렬 후 출력
		String[] sortedStringArray = extractSortStrings(msg);
		System.out.println("정렬 스트링 배열:");
		printStringArray(sortedStringArray);

		// 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
		double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
		System.out.println("정렬 실수 배열:");
		printDoubleArray(sortedDoubleArray);
	}
}
