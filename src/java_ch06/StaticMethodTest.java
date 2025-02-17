package java_ch06;

public class StaticMethodTest {
	public static void main(String[] args) {
		StaticMethodTest.print1();
		StaticMethodTest exam = new StaticMethodTest();
		exam.print2();
	}
	public static void print1() { //스테틱을 사용하면, 클래스 내에 인스턴트를 안 만들고 메소드가 없어도 프린트 됨
		System.out.println("hello");
	}

	public void print2() {
		System.out.println("java");

	}
	
}
