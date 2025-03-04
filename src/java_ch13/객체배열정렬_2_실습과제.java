package java_ch13;

/*
 * 구글: [Java] 내가 만든 클래스 객체 배열 정렬하기 (comparable,
 * 티스토리, 22.1.9
 */

import java.util.Arrays;
import java.util.Comparator;

class Student3 {
	String sno;
	String sname;
	

	public Student3(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
}


//class StudentComparator implements Comparator<Student3> {
class SnoComparator implements Comparator<Student3> {
	public int compare(Student3 s1, Student3 s2) {
		return s1.sno.compareTo(s2.sno);
	}

}

class SnameComparator implements Comparator<Student3> {
	public int compare(Student3 s1, Student3 s2) {
		return s1.sname.compareTo(s2.sname);
	}
}

public class 객체배열정렬_2_실습과제 {

	static void swap(Student3[] data, int i, int j) {
		Student3 st = data[i]; data[i]=data[j]; data[j]=st;
	}
	static void sortStudent(Student3[]data) {//자바 과목에서는 어렵다 
		

	}
	
	public static void main(String[] args) {
		//StudentComparator sc= new StudentComparator();
		SnoComparator snocom = new SnoComparator();
		SnameComparator snamecom = new SnameComparator();
		
		Student3 [] data = {
				new Student3("12", "홍길동"),
				new Student3("121", "홍길순"),
				new Student3("213", "홍길춘"),
				new Student3("9", "홍길홍")
		};
		sortStudent(data);
		//Arrays.sort(data);//이게 문제(?)가 있어서 sortStudent()를 구현> 무슨 문제인지를 알아야
		for (Student3 st: data)
			System.out.print(" " + st);
		Arrays.sort(data, snocom);
		System.out.println("\n정렬후");
		for (Student3 st: data)
			System.out.print(" " + st);
	}

}

