package java_ch09;

//iterator 개념 실습 
import java.util.StringTokenizer;

public class Test14_실습대상 {
	public static void main(String[] args) {

		String msg = "Although the world is full of suffering, it is full also of the overcoming of it.";
		
		String arrayMessage[] = msg.split(" "); // " " => regular expression으로 빈칸을 썼다. 빈간을 기준으로 토큰을 나눈다. 446쪽 참조
		//이것의 값은 배열로 온다.
		for (String st: arrayMessage)
			System.out.println(st);
		
		StringTokenizer st1 = new StringTokenizer(msg);//st1은 객체임, 배열이 아님
		//st1은 객체이기 때문에 객체명+ . 을 하면 쓸 수 있는 메소드가 많음.
		//st1. //dot 후에 나타나는 메소드를 확인하는 것이 필요함 - 교재 433페이지 표
		
		
		System.out.println("단어 수 : " + st1.countTokens());
		while (st1.hasMoreTokens()) {
			System.out.print(st1.nextToken() + " + " );
		}
		StringTokenizer st11 = new StringTokenizer(msg, ",. ");//delimiter 사용
		System.out.println("단어 수 : " + st11.countTokens());
		while (st11.hasMoreTokens()) {
			System.out.print(st11.nextToken() + " + " );
		}
		System.out.println("\n================");
		String s = "id=guest&name=Amy&pwd=1004";
		StringTokenizer st2 = new StringTokenizer(s, "&");
		while (st2.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}

		System.out.println("================");
		StringTokenizer st3 = new StringTokenizer(s, "=&");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
	}
}