package data_ch02;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;
import java.util.Objects;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getVision() {
		return vision;
	}

	public void setVision(double vision) {
		this.vision = vision;
	}

	@Override
	public String toString() {// Object 클래스 상속
		return String.format("이름:%s 키:%s 시력:%s", name, height, vision);
	}

	// 스트링만 비교하기 위해 만든 함수이다.
	@Override
	public int compareTo(PhyscData p) {
		int a = name.compareTo(p.name);
		if(a == 0) {
			a = Integer.compare(height, p.height);
		} else if(a == 0) {
			a = Double.compare(vision, p.vision);
		}
		return a; //비교문을 더 넣어라.
	}

	
	//같은 객체인지 비교하는 함수
	@Override
	public boolean equals(Object ob) {
	    if (this == ob) return true; // 같은 객체면 true
	    if (!(ob instanceof PhyscData p)) return false; // 타입 확인 및 형변환

	    return Objects.equals(name, p.name) // 이름 비교 (null-safe)
	        && height == p.height // 키 비교
	        && Double.compare(vision, p.vision) == 0; // 시력 비교 (부동소수점 안전 비교)
	}
}

public class 제출_실습2_14_1객체배열정렬 {
	static void swap(PhyscData[] arr, int ind1, int ind2) {
		PhyscData a = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = a;
	}

	static void sortData(PhyscData[] data) {// 객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로
		// compareTo()를 사용하여 구현
		int i = 0;
		while (i < data.length - 1) {
			int last = data.length - 1;
			for (int j = 0; j < data.length - 1; j++)
				if (data[j].name.compareTo(data[j + 1].name) > 0) { // 만약, 배열의 필드 중 이름이 같다면
					swap(data, j, j + 1);
					last = j;
				}
			i = last;
		}

	}

	static int binarySearch(PhyscData[] data, String key) {
		int i = 0;
		int j = data.length - 1;
		do {
			int k = (i + j) / 2;
			if (data[k].name.equals(key)) { // 만약, 배열의 필드 중 이름이 같다면
				return k;
			} else if (data[k].name.compareTo(key) < 0) {
				i = k + 1;
			}

			else {
				j = k - 1;
			}

		} while (i <= j);
		return -1;
	}
	// if (data[i].equals(key)) ***으로 구현

	// equals()를 사용하여 구현

	public static void showData(String msg, PhyscData[] data) {
		// System.out.printf();
		// 교재 89 printf() 사용
		System.out.printf(msg);
		for (PhyscData arr : data) {
			System.out.println(arr.toString());
		}
		System.out.println();
	}

	static PhyscData[] insertObject(PhyscData[] args, PhyscData k) {// 배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다
																	// 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		PhyscData[] newArr = new PhyscData[args.length + 1]; // 새로운 배열을 만듦
		 int i = 0, j = 0;
	        
	        while (j < args.length) {
	            if (args[j].compareTo(k) > 0) break;
	            newArr[i++] = args[j++];
	        }
	        
	        newArr[i++] = k;  // 새로운 객체 삽입
	        while (j < args.length) newArr[i++] = args[j++];
	        
	        return newArr;
	    }
		
		
//		for (int i = newArr.length; i >= 0; i--) 
//			for (int j = args.length; j >= 0; j--) {
//				if (args[j].name.compareTo(k.name) > 0) {
//					newArr[i] = args[j];
//				} else {
//					newArr[i] = k;
//				}
//			}
//			return newArr;
//	}

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7), new PhyscData("사이다", 172, 0.3), new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2), new PhyscData("다정해", 169, 0.5) };
		showData("정렬 전\n", data);

		sortData(data);
		showData("정렬 후\n", data);
		int resultIndex = binarySearch(data, "사이다");
		if (resultIndex >= 0)
			System.out.println("\n사이다가 존재하면 인덱스 = " + resultIndex);
		else
			System.out.println("사이다가 존재하지 않는다");

		PhyscData[] newData = insertObject(data, new PhyscData("소주다", 179, 1.5));// 배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰
																					// 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후 \n", newData);

	}

}
