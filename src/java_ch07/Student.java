package java_ch07;

public class Student extends Person {


	private String major;
	
	public Student(String name, int age, String major){
		super(name, age);
		this.major = major;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
//		return this.getName() + ", "+ this.getAge() + ", " + major;
//		return super.getName() + ", " + super.getAge() + "," + major;
		return super.toString() + "-" + major;
	}

	
}
