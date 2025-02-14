package java_ch03;

import java.util.Scanner;

public class 실습_3장_5_for_구구단 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("숫자를 입력해 주세요.");

			int dan = sc.nextInt();
			for (int i = 0; i < 10; i++) {
				System.out.println(dan + "x" + i + "=" + dan * i);
			}
		}
	}
}
