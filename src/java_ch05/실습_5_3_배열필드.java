package java_ch05;

//Person 클래스 선언
class Person {
	//private 클래스 필드 선언
	private String name;
	private int age;
	private float weight;
	private String[] subjects = new String [3];
	private int[] years = new int [3];
	private int count; // 객체가 만들어질 때 값 = 0
	
	
	
	// 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * subjects을 교육과목 private 배열=> []
	 * years을 수강 연도 private 배열
	 * count 필드를 사용하여 수강 과목 증가시마다 ++count
	 */
	// 필드
	
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
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String[] getSubjects() {
		return subjects;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	public int[] getYears() {
		return years;
	}
	public void setYears(int[] years) {
		this.years = years;
	}
	// 메소드
	void show() {
		System.out.println("name=" + name + ", age = " + age + ", weight = " + weight);
		// 기본 정보 출력::name=**, age=**, weight=**로 출력
		
		// 교육과목 및 수강 연도 출력
		for(int i = 0; i<subjects.length; i++) {
			System.out.println(subjects[i]+":"+years[i]);
		}
		
	}
	void addSubjectYear(String subject, int year){//과목, 수강연도를 매개변수로 전달받아 배열에 추가
		subjects[count] = subject;
		years[count] = year;
		count++;
	}
}

public class 실습_5_3_배열필드 {

    public static void main(String[] args) {
        // 첫 번째 객체 생성 및 초기화
        Person p1 = new Person();
        //다음 코드를 setter, addSubjectYear를 사용하여 수정
        p1.setName("홍길동");
        p1.setAge(25);
        p1.setWeight(60.56f);
//        p1.subjects = new String[] {"Mathematics", "Science", "History"};
//        p1.years = new int[] {2020, 2021, 2022};
        p1.addSubjectYear("Mathematics", 2020);
        p1.addSubjectYear("Science", 2021);
        p1.addSubjectYear("History", 2022);
        
        

        // 메소드 호출
        p1.show();
        
        // 두 번째 객체 생성 및 초기화
//        Person p2 = new Person();
//        p2.name = "강감찬";
//        p2.age = 55;
//        p2.weight = 62.34f;
//        p2.subjects = new String[] {"Literature", "Philosophy", "Physics"};
//        p2.years = new int[] {2018, 2019, 2020};
//
//        // 메소드 호출
//        p2.show();
    }
    
}

