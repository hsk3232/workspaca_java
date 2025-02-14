package java_ch07;

public class Employee extends Person {

	private String dept; // getter, setter 단축키 'alt + shift + S'

	public Employee(String name, int age, String dept) {
		//this.name = name; 
		super(name, age);
//		super.setName(name);
//		super.setAge(age);
		this.dept = dept;
	}
	
	
	//	default 생성자
//		public Employee() {		
//		
////		name = null; // 위의 이름과 나이 생성자는 이 파일이 아니라 슈퍼 클레스에 있기 때문에, 만들면 오류일 뿐아니라 만들지 않아도 슈퍼 클래스에서 컴파일러가 자동(default) 생성자를 만듦.
////		age = 0;
//		super(); //상위 클레스의 생성자를 부르는 것
//		dept = null; 
		
//	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
//		return this.getName() + ", "+ this.getAge() + ", " + dept;
//		= return super.getName() + ", " + super.getAge() 
		return super.toString()+", " + dept;
	}

}
