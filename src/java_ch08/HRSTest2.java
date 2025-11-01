//package java_ch08;
//
//public class HRSTest2 {
//
//	public static void calcTax(Employee e) {
//		if(e instanceof Salesman) {
//			System.out.println("Salesman 입니다."); // 1줄 안에 작성할 때는 중괄호 안 써도 작동 됨.
//		} else if (e instanceof Manager) {
//			System.out.println("Manager 입니다.");
//		} else if (e instanceof Consultant) {
//			System.out.println("Consultant 입니다.");
//		} else {
//			System.out.println("Employee 입니다.");
//
//		}
//	}
//
//	public static void main(String[] args) {
//		Salesman s = new Salesman();
//		Manager m = new Manager(); // 추상클래스라 인스턴스를 가질 수 없음.
//
//		Consultant c = new Consultant();
//
//		//자식 클레스에만 선언이 된 필드 같은 것들은 타입케스트를 통하면,
//
//		calcTax(s);
//		calcTax(m);
//		calcTax(c);
//
//
//	}
//}
//
