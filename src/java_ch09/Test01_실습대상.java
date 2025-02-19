package java_ch09;

/* 교재 397 - 405 실습 코드> 아래 코드를 이해할 수 있어야 한다.
*/

class MyObject {
	int id;
	public MyObject() {
		id=0;
	}
	
	public MyObject(int num) {
		id=num;
	}

	public String toString() {
		return "MyObject";
	}
}

public class Test01_실습대상 {
		public static void main(String[] args) {
			String st = "java coding";
			
			Object obj1 = new Object();
			Object obj2 = new Object();
			Object obj3 = new MyObject();
			MyObject mo = new MyObject();
			System.out.println("1. obj1.hashCode()=" + obj1.hashCode());//출력이 정수
			System.out.println("2. " +Integer.toHexString(obj1.hashCode()));//16진수를 써서 나타낸 것, 위치는 이것으로 주로 나타냄
			System.out.println("3. " +obj2.hashCode());
			System.out.println("4. " +obj3.hashCode());
			

			Class c = obj3.getClass();//c는 객체이고 toString()이 있음
			System.out.println("5. " +c);
			
			System.out.println("6.객체의 클래스 이름:: " + c.getName());
			
			if ((c.getName()).compareTo("6. MyObject")== 1)//클래스 이름에 패키지 이름도 있으므로
				System.out.println("7. 클래스는 " + c.getName()); 
			
			System.out.println("8. " +obj1);//toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임 > 정수를 hexa로 변경한 것
			System.out.println("9. " +obj1.toString());//399 페이지 하단의 클래스 이름이 string
			System.out.println("10. " +obj2);
			System.out.println("11. " +obj3);//재정의된 toString() 호출

			
			//403쪽
			MyObject obj4 = new MyObject(123);
			System.out.println("12. " +obj4);
			
			MyObject obj5 = new MyObject(123);
			//obj4.equals(obj5) //MyObject의 equals()가 실행됨
			if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
				System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
			} else {
				System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
			}
			System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
			if (obj4 == obj5) {
				System.out.println("동일 객체이다.");
			} else {
				System.out.println("다른 객체이다.");
			}
			System.out.println("obj4 = " + obj4);
			MyObject mo2 = new MyObject();//402페이지의 toString() 오버라이딩
			System.out.println(mo2);
		}
	}
