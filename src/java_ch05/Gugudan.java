package java_ch05;

import java.lang.annotation.Repeatable;

public class Gugudan {
//num단 한개를 출력하는 메소드

	public void print(int num) {
		for (int i = 1; i < 10; i++) {
			
			System.out.println(num + "*" + i + "=" + (num * i));
			

		}

	}

	// 코드 작성

	// 구구단을 순서대로 출력하는 메소드
	public void printVertical() {
		for (int j = 2; j < 10; j++) {
			System.out.println(j+"단");
			print(j);
			System.out.println("-".repeat(20));
		} // 2단~9단을 출력해라 코드
			// print 메소드를 사용하도록 코드 작성

	}
	
}
