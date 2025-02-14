package java_ch07_추상클래스;

abstract class Employee {
	String name;
	int salary;

	public abstract void calcSalary();
	public abstract void calcBouns(); 

}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여");
	}

	public void calcBouns() {
		System.out.println("Salesman 보너스");
	}


}

 class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여");
	}

	public void calcBouns() {
		System.out.println("Consultant 보너스");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여");
	}


	public void calcBouns() {
		System.out.println("Manager 보너스");
	}
}

public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
//		Manager m = new Manger();

		s.calcSalary();
		c.calcSalary();
//		m.calcSalary();
		s.calcBouns();
		c.calcBouns();
//		m.calcBouns();
		

	}
}