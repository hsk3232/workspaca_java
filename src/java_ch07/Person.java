package java_ch07;

public class Person {
	private String name;
	private int age;
	
	public	Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
//	public Person() {이 부분은 디폴트(default) 생성자로 컴파일러에서 자동생성 되어 메모리를 할당하고 값을 초기화 함. 
//		name =null;
//		age = 0;
//	}  
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() { //Person 객체를 출력하려면, 문자인 이름을 읽고 ":"를 찍고 정수인 숫자를 같이 호출해서 
		return name + "," + age;
		
	}
	
	
}
