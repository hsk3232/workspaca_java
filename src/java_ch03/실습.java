package java_ch03;

public class 실습 {

	public static void sum1() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("짝수합" + sum);
	}

	public static void sum2() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("짝수합" + sum);
	}

	public static void main(String[] args) {
		System.out.println("*".repeat(30));
		sum1();
		System.out.println("-".repeat(30));
		sum2();
	}
	
	/*
	 * int sum = 0; for (int i = 1; i <= 100; i++) { if (i % 2 == 0) { sum += i; }
	 */

	/*
	 * System.out.println("짝수합" + sum);
	 * 
	 * sum = 0; for (int i = 1; i <= 100; i++) {
	 * 
	 * sum += (i%2 == 0)? i : 0;
	 * 
	 * }
	 */

}
