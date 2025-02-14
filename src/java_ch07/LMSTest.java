package java_ch07;

public class LMSTest {//클래스 선언
	public static void main(String[] args) {
		Employee e = new Employee("홍길동", 22, "세일즈"); // 참조변수 생성 (클래스 객체 생성과 동시에 참조 변수를 선언)
		Professor p = new Professor("홍길순", 23, "문화예술");
		Student s = new Student("임윤아", 37, "국어국문학"); // new 부분은 생성자
		
		
		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}

}
