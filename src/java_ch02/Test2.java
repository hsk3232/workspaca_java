package java_ch02;

public class Test2 {

	public static void main(String[] args) {
		int depositAmount;
		depositAmount = 50000;
		boolean Male = true;
		char gender;
		gender = 'F';
		String name = "Hong jimin";//string literal
		long d = 23232323232L;
		float exchangeRate = 1480;//소수점 숫자는 double 실수로 인식함
		double dollarRate = 1480.0f;//1480.0f는 4byte 실수
		System.out.println("depositAmount = " +depositAmount );
		System.out.println("male/female = " + Male);
		System.out.println("gender = " + gender);
		System.out.println("name : : " + name);
		
		int a= 10;
		a = a + 1;
		int b = a++;
		System.out.println("b = " + b+", a = " + a);
		
		int num1 = 017;// 8진법
		int num2 = 0xf;//16진법 =>0x로 표기한 것임
		System.out.println("num1=" + num1);
		System.out.println("num2=" + num2);
		
		int num3 = 14;
		System.out.println(Integer.toBinaryString(num3));
		System.out.println(Integer.toHexString(num3));
	}
}
