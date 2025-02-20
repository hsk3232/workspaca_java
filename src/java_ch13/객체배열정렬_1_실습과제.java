package java_ch13;

import java.util.Arrays;

class Student2 implements Comparable<Student2>{
	//Studen2의 객체를 비교할 때 Comaparable interface를 가져와서 하겠다 선언.
	String sno;
	String sname;
	
	public Student2(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	
	@Override //Comparable 사용하려면 추상메서드 선언을 해야 함으로 Override 해야 함.
	public int compareTo(Student2 s2) {
		return sno.compareTo(s2.sname);
	}
	@Override
	public String toString() {
		return "[" + sname+ ", " + sno + "]";
	}
	
}
public class 객체배열정렬_1_실습과제 {

	static void swap(Student2[] data, int i, int j) {
		
	}
	static void sortStudent(Student2[]data) {//자바 과목에서는 어렵다
		//Arrays.sort(data);
		//Arrays.sort(null, null); compara()
		for(int i = 0; i<data.length; i++)
			for(int j = i+1; j<data.length; j++) {
				swap(data, i, j); 
			}
		
	}
	
	public static void main(String[] args) {
		Student2 [] data = {
				new Student2("512", "길동"),
				new Student2("7121", "이길순"),
				new Student2("2213", "박길춘"),
				new Student2("39", "나길홍")
		};
		sortStudent(data);
		//Arrays.sort(data);//이게 문제(?)가 있어서 sortStudent()를 구현> 무슨 문제인지를 알아야
		for (Student2 st: data)
			System.out.println(" " + st); // st.toSting 해야함
			//printla의 괄호 안에는 String 값을 원하기 때문에 객체를넣어도 toStrig이 자동으로 붙음.
	}

}

//interface Comparable <T> {
	//publice int compareTo();
//}로 자바 컴파일러에 의해 추상메소드 선언되어 있음 / compareTo(T t);가 언제 사용되는지를 알아야 함. 자료 구조에서 쓰임
//compare(T1 o1, T2 o2); 둘의 차이도 알아야 함.