package java_ch03;

import java.util.Scanner;

public class 실습_3장_8_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 항의 수
		int first = 0;
		int second = 1;
		System.out.println(first);

		int i = 0;
		while (i < n - 1) {
			System.out.println(second);
			++i;
			int next = first + second;
			first = second;
			second = next;
		}
	}
}
