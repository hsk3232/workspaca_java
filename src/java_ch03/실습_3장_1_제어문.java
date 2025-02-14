package java_ch03;

public class 실습_3장_1_제어문 {
	/*
	 * 택배 요금 계산 1000g 이하 3000원 1kg<w<5kg 5000 5kg<= w < 10kg 8000 10kg<= w 12000 출력은
	 * "택배 요금 = 000원 입니다"
	 * 
	 */
	public static void main(String[] args) {
		int weight = 1000;
		int price = 0;

		if (weight <= 1000) {
			price = 3000;
		} else if (weight > 10000 && weight < 5000) {
			price = 5000;
		} else if (weight >= 50000 && weight < 10000) {
			price = 8000;
		} else if (weight >= 10000) {
			price = 12000;
		}

		System.out.println("택배 요금 = " + price + "원 입니다.");

	}

}
