package data_ch02;

import java.util.Arrays;
import java.util.Random;

public class 실습2_05_정수배열정렬 {
	static int[] insertData(int[] d, int k) { // insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int[] newArr = new int[d.length + 1]; // 새로운 배열을 만듦
//		int j = 0;
//		boolean tag = false;
//		for (int i = 0; i < newArr.length; i++) {
//			if (!tag) {
//				if (k < d[j]) {
//					newArr[i] = k;
//					j++;
//					tag = true;
//				}
//
//			} else {
//				newArr[i] = d[j];
//			}
//
//		}
//		return newArr;

		int i = 0, j = 0;

		while (j < d.length) {
			if (d[j] < k)
				break;
			newArr[i++] = d[j++];
		}

		newArr[i++] = k; // 새로운 객체 삽입
		while (j < d.length)
			newArr[i++] = d[j++];

		return newArr;

	}

	static void showData(String msg, int[] data) {
		System.out.print(msg + ":");
		System.out.println(Arrays.toString(data));
	}

	static int[] inputData(int[] data) {
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(20);
		}
		return data;
	}

	static void swap(int[] arr, int ind1, int ind2) {// 교재 67페이지
		int a = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = a;
	}

	static void reverse(int[] arr) {// 교재 67페이지
		int[] a = arr;
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1);
		}

	}

	static void sortData(int[] arr) {
		Arrays.sort(arr);
	}

	static void reverseSort(int[] arr) {
		int start = 0;
		int last = arr.length - 1;
		for (start = 0; start < arr.length; start++) {
			for (int i = last; i > start; i--) {
				if (arr[i] > arr[i - 1]) {
					swap(arr, i - 1, i);
					last = i;
				}
			}
			start = last;
		}
	}
	/*
	 * 난이도가 매우 높은 알고리즘 구현 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존
	 * 배열을 copy할 때 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 */

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData("난수 입력", data);

		reverse(data);// 역순으로 재배치 - 정렬 아님
		showData("역순 재배치", data);

		sortData(data);
		showData("정렬후", data);

		reverseSort(data);// 역순으로 정렬
		showData("역순 정렬후", data);

		sortData(data);
		int realData = 15;
		int[] result = insertData(data, realData);// 입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", result);
	}

}
