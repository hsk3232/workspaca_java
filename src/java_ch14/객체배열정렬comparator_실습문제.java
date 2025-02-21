package java_ch14;

/*
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class Student {
	String sno;
	String sname;

	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return "[" + sno + ", " + sname + "]";
	}
}

public class 객체배열정렬comparator_실습문제 {
	static void sortStudent(Student[] data, Comparator<Student> comp) {
		Student temp;
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++) {
				// if (data[i] < data[j] ) {//문제가 발생 :: 객체 비교가 안된다
				// if (data[i].compareTo(data[j])>0) {
				// if (Integer.parseInt(data[i].sno) > Integer.parseInt(data[j].sno)) {
				if (comp.compare(data[i], data[j]) > 0) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
	}

	public static void main(String[] args) {
		Comparator<Student> compSno = (s1, s2) -> {
			if (s1.sno.compareTo(s2.sno) < 0)
				return -1;
			else if (s1.sno.compareTo(s2.sno) > 0)
				return 1;
			else
				return 0;
		};

		Comparator<Student> compName = (s1, s2) -> {
			return (s1.sname.compareTo(s2.sname));
		};

		Student[] data = { new Student("612", "홍길동"), new Student("3", "김길순"), new Student("213", "최길춘"),
				new Student("119", "나길홍") };
			sortStudent(data, compName);
			Arrays.sort(data, compName);//이게 문제가 있어서 sortStudent()를 구현
			//Collections.sort(data, compName);

		Arrays.sort(data, (s1, s2) -> {
			if (s1.sno.compareTo(s2.sno) < 0)
				return -1;
			else if (s1.sno.compareTo(s2.sno) > 0)
				return 1;
			else
				return 0;

		});

		
		for (Student st : data)
			System.out.print(" " + st);
	}

}
