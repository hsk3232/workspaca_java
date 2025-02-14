package java_ch03;

import java.util.Scanner;

public class 실습_3장_7_for피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 항의 수
		int first = 0;
		int second = 1;
		System.out.println(first);

		for (int i = 1; i < n; ++i) {
			System.out.println(second);
			int next = first + second;
			first = second;
			second = next;
		}

	}

}