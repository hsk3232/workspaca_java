package java_ch06;

public class Gugudan {


	// 구구단을 순서대로 출력하는 메소드
	public void printHorizontal() {
		for(int i = 1; i <10; i++) {
		for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i+"=" +(j*i)+"\t");
			}
			System.out.println();
		} // 2단~9단을 출력해라 코드
			// print 메소드를 사용하도록 코드 작성

	}
}
