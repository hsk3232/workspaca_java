package data_ch02;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	@Override
	public String toString() {//Object 클래스 상속
		return " ";
	}
	@Override
	public int compareTo(PhyscData p) {

	}
	public boolean equals(Object ob) {//Object 클래스 상속
		 PhyscData p = (PhyscData) ob;

	}
}
public class 제출_실습2_14_1객체배열정렬 {
	swap() {
		
	}
	sortData() {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
	}
	binarySearch() {
		//if (data[i].equals(key)) ***으로 구현
		
	} //equals()를 사용하여 구현
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);
		int resultIndex = binarySearch(data, "사이다")
		if (resultIndex >= 0)
			System.out.println("사이다가 존재하면 인덱스 = "+resultIndex);
		else
			System.out.println("사이다가 존재하지 않는다");
		PhyscData[] newData= insertObject(data, new PhyscData("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		
	}
	showData() {
		//교재 89 printf() 사용 
	}
	insertObject(){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		
	}

}
