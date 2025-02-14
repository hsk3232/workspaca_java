package java_ch03;

import java.util.Scanner;

public class 실습_3장_6_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 항의 수
		int first = 0;
		int second = 1;
		System.out.println(first);

		int i =2;
		do {
			System.out.println(second);
			++i;
			int next = first + second;
			first = second;
			second = next;
			System.out.println(next);
		}

		while (i < n - 1);

		
		
	}
}
