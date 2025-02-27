package data_ch02;

import java.util.Arrays;

/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;

public class 실습2_04_메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;

	static void inputData(int[] data) {// 함수 body가 호출될 때 받을 매개변수를 지정해 줘야 함.
		// 난수를 생성해 입력 //교재 63 - 난수의 생성 //top이 배열에 저장된 갯수를 저장
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(20);
		}
	}

	public static void showData(String msg, int[] db) {
		// top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		System.out.println(msg + Arrays.toString(db));
	}

	public static int findMax(int[] data) {
		int max = 0;
		for (int i = 0; i < data.length; i++) { // data[i]의 값과 max를 비교해서 data가 크면, max로 바꾼다.
			if (data[i] > max) {
				max = data[i];
			}
		}
		return max; // 최대값을 리턴한다
	}

	public static boolean findValue(int[] items, int num) {
		// items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		int n = num;
		boolean a = true;
		for (int i = 0; i < items.length; i++) {
			if (items[i] == n) {
				return a;
			}
		}
		return false;
	}

	public static int[] reverse(int[] data) {
			int[] st = new int[data.length];
		for (int i = 0; i < data.length; i++) { 
//			for (int j = data.length-1; j > 0; j--) {
//				st[i] = data[j];
				st[i] = data[data.length - 1 - i];
				
			}	return st;
	}

	public static void main(String[] args) {
		int[] data = new int[10];

		inputData(data); // 함수를 호출하면 매개변수 전달 함.

		showData("소스데이터", data);

		int max = findMax(data);
		System.out.println("\nmax = " + max);

		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);

		int[] arr = reverse(data);// 역순으로 출력
		showData("\n역순 데이터", arr);

	}
}
