package java_ch08;

abstract class Employee {
	String name;
	int salary;
	
	//<---부모 클래스 추상 메서드 총 2개--->
	public abstract void calcSalary();

	public abstract void calcBouns();

}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매수당");
	}

	public void calcBouns() {
		System.out.println("Salesman 보너스 = 기본급 *12*4");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 판매수당");
	}

	public void calcBouns() {
		System.out.println("Consultant 보너스 = 기본급 *12*2");
	}

}

abstract class Manager extends Employee { // 부모 클래스의 '추상 메서드'를 모두 구현하지 않으면, 
	//자기 자신도 추상클래스가 된다. abstract 붙이면..
	//<--- 추상클래스는 new 명령문을 써서 인스턴스를 만들 수 없음--->
//	public  void calcBouns(){}// 이거 없으면 오류남
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 판매수당");
	}

}
//추상 클래스 Manager를 상속받는 Director는 Manager가 Employee 클래스 abstract method 중
//구현하지 않은 method를 반드시 Overriding으로 구현해야 일반 class가 될 수 있다.
class Director extends Manager {
	public void calcBouns() {
		System.out.println("Manager 보너스 = 기본급 *12*6" + '\n');
	}
}

public class HRSTest {
//	public static void calcTax(Employee e) { 
//		System.out.println("소득세를 계산합니다.");
//	}

	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		//Manager m = new Manager();
		// 추상클래스라 인스턴스를 가질 수 없으나, abstract 때고 추가 해줘서 오류 없앰
		
		//m.calcBouns();
		s.calcBouns();
		c.calcBouns();
		d.calcBouns();

//		calcTax(s);
//		calcTax(c);
//		calcTax(d);

//		System.out.println(s.toString()); // 가장 가까운 조상 중 toString을 구현해 놓은 곳으로 가나 지금은 구현 한 곳이 없어서 Object로 감
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//
		////		if(s.equals(c)) { //object에 구현된 코드로 클레스의 인스턴스의 헤쉬코드가 같은지 확인하는 코드로 같은 객체인지 확인하는 코드, ==와 다르며 ==는 같은 값인지 확인하는 것.
////			System.out.println("동일한 객체입니다.");
////		} else {
////			System.out.println("서로 다른 객체입니다.");
////		}
////		
//		Salesman s2 = s;
//		System.out.println(s2.toString());
//
//		if (s.equals(s2)) {
//			System.out.println("동일한 객체입니다.");
//		} else {
//			System.out.println("서로 다른 객체입니다.");
//		}

	}
}
