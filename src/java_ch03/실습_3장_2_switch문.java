package java_ch03;

import java.util.Scanner;

public class 실습_3장_2_switch문 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("자판기 사용 비용");
			System.out.println("1. 커피 - 2000원");
			System.out.println("2. 맥주 - 2400원");
			System.out.println("3. 콜라 - 1500원");
			System.out.println("4. 주스 - 1200원");

			int choice = sc.nextInt();
			int price = 0;
			switch (choice) {
			case 1:
				price = 2000;
				break;

			case 2:
				price = 2400;
				break;

			case 3:
				price = 1500;
				break;

			case 4:
				price = 1200;
				break;
			}
			System.out.println("주문한 금액은 " + price + "원 입니다.");
		}
	}

}
