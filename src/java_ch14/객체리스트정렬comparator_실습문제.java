package java_ch14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student4 {
	String sno;
	String sname;

	public Student4(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return "[" + sno + ", " + sname + "]";
	}

}

public class 객체리스트정렬comparator_실습문제 {
	static void sortStudent(List<Student4> data, Comparator<Student4> comp) {
		Student4 temp;

		for (int i = 0; i < data.size(); i++)
			for (int j = i + 1; j < data.size(); j++) {
				// if (data[i] < data[j] ) {//문제가 발생 :: 객체 비교가 안된다
				// if (data[i].compareTo(data[j])>0) { //puablic Comparable<Student>
				// if (Integer.parseInt(data[i].sno) > Integer.parseInt(data[j].sno)) {
				if (comp.compare(data.get(i), data.get(j)) > 0) {
					temp = data.get(i);
					data.set(i, data.get(j));
					data.set(j, temp);
				}
			}
	}

	public static void main(String[] args) {
		Comparator<Student4> compSno = (s1, s2) -> {
			if (s1.sno.compareTo(s2.sno) < 0)
				return -1;
			else if (s1.sno.compareTo(s2.sno) > 0)
				return 1;
			else
				return 0;
		};

		Comparator<Student4> compName = (s1, s2) -> {
			return (s1.sname.compareTo(s2.sname));
		};

		ArrayList<Student4> al = new ArrayList<>();
		al.add(new Student4("2", "홍길동"));
		al.add(new Student4("12", "김길동"));
		al.add(new Student4("52", "남길동"));
		al.add(new Student4("7", "마길동"));
		al.add(new Student4("33", "박길동"));

		sortStudent(al, compName);
		// Arrays.sort(data, compName);//이게 문제가 있어서 sortStudent()를 구현
		Collections.sort(al, compName);
		// al.sort(compSno);

		Collections.sort(al, (s1, s2) -> {
			return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
		});

		// 람다식에 대한 인터페이를 자동으로 찾는다.
		// Collections.sort(T t1, Comparator<? super T> c1)이므로 (s1,s2)를 compare(s1,s2)로
		// 인식한다
		Collections.sort(al, (s1, s2) -> Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno));

		/*
		 * Arrays.sort(data, new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student s1, Student s2) { if
		 * (s1.sno.compareTo(s2.sno) < 0) return -1; else if (s1.sno.compareTo(s2.sno) >
		 * 0) return 1; else return 0; } });
		 */
		
		
		
		Arrays.sort(data, (s1, s2) -> {
				if (s1.sno.compareTo(s2.sno) < 0)
					return -1;
				else if (s1.sno.compareTo(s2.sno) > 0)
					return 1;
				else
					return 0;
					});

		for (Student4 st : al)
			System.out.print(" " + st);
	}

}
