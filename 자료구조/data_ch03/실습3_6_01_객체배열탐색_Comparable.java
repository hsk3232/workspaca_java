package data_ch03;

/*
 * 3장 3번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparable 구현
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 * 
 * Comparable Interface
 * 
 * public interface Comparable<T> {
 *     int compareTo(T o);
 * }
 */

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 * 
 * binarySearch(T[], T key)는 API에서 직접 지원하지 않음.
 * 하지만 binarySearch(Comparable<T>[] a, T key)를 사용할 수 있음.
 * 배열이 Comparable<T>을 구현하는 객체라면 정상적으로 동작함.
 * 만약 비교 기준을 다르게 설정하고 싶다면 binarySearch(T[], T key, Comparator<? super T> c)를 사용해야 함
 * 
 * Arrays.sort(Object[])가 존재하는 이유 > 
 * 배열의 원소가 Comparable을 구현하면, Object[] 배열에서도 정렬 가능
 * String[], Integer[], Double[] 등 Comparable을 구현한 기본 래퍼 클래스의 배열을 정렬하는 데 유용
 * 
 *  Object[] numbers = {5, 2, 9, 1, 3}; // Integer 배열 (Integer는 Comparable<Integer> 구현)
 *  Arrays.sort(numbers); // 정상 작동
 *  
 *  Arrays.sort(T[]) (제네릭 버전)
 *  제네릭 배열 T[]을 정렬할 때 더 적합한 방식.
 *  T가 Comparable<T>를 구현했을 경우, 자동으로 compareTo()가 호출됨.
 *  T[] 배열의 원소가 Comparable<T>를 구현하면 Arrays.sort(T[])를 사용할 수 있음.
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2> {
	String name;
	int height;
	double vision;

	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	// [홍길동,162,0.3] 형태로 리턴한다
	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, height, vision);
	}

	@Override
	public int compareTo(PhyscData2 p) {
		// name 비교 버젼
		// height 비교 버젼

		int a = name.compareTo(p.name);
		if (a == 0) {
			a = Integer.compare(height, p.height);
		} else if (a == 0) {
			a = Double.compare(vision, p.vision);
		}
		return a; // 비교문을 더 넣어라.
	}
}

public class 실습3_6_01_객체배열탐색_Comparable {

	// 결과 프린트
	private static void showData(String msg, PhyscData2[] data) {
		System.out.println(msg);
		System.out.println(Arrays.toString(data));
	}

	// 정렬 Method 6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
	private static void sortData(PhyscData2[] data) {
		int j;
		for (int i = 1; i < data.length; i++) {
			PhyscData2 tmp = data[i];
			for (j = i; j > 0 && data[j - 1].compareTo(tmp) > 0; j--) {
					data[j] = data[j - 1];				
			}data[j] = tmp;
		}
	}

	private static void swap(PhyscData2[] data, int a, int b) {
		PhyscData2 c = data[a];
		data[a] = data[b];
		data[b] = c;
	}

	// 역순 배열
	private static void reverse(PhyscData2[] data) {
		int start = 0;
		while (start < data.length - 1) {
			int last = data.length - 1;
			for (int j = last; j > start; j--) {
				if (data[j-1].compareTo(data[j]) < 0) {
					swap(data, j-1, j);
					j = last;
				}
			}
			start = last;
		}
	}

	// compareTo()를 사용하여 key 검색 구현
	private static int linearSearch(PhyscData2[] data, PhyscData2 key) {
		int start = 0;
		while(start < data.length-1) {
			int last = data.length-1;
			for(int j = last; last > start; j--) {
				if(data[j].compareTo(key) == 0) {
					j = last;
					return last;
				} 
			}
			start = last;
		}				
		return start;
	}

	// compareTo()를 사용하여 key 검색 구현
	private static int binarySearch(PhyscData2[] data, PhyscData2 key) {
		int start = 0;
		int last = data.length;
		do {
			int mid = (start + last) / 2;
			if(data[mid].compareTo(key) > 0) {
				last = mid - 1;
			} if else(data[mid])
		}
		
		return -1;
	}

	public static void main(String[] args) {
		PhyscData2[] data = { new PhyscData2("홍길동", 162, 0.3), 
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7), 
				new PhyscData2("홍길동", 162, 0.3), 
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2), 
				new PhyscData2("길동", 167, 0.5), };
		showData("정렬전", data);
		sortData(data);// 6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
		showData("\n정렬후", data);
		reverse(data);
		showData("\n역순 재배치후", data);
		Arrays.sort(data);// 사용된다 그 이유는? [중요] 이해가 되어야 한다 - compareTo() 구현을 변경하여 실행결과를 확인
		showData("\nArrays.sort() 정렬후", data);

		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
		int resultIndex = linearSearch(data, key);// compareTo()를 사용하여 구현
		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);

		key = new PhyscData2("박동", 167, 0.6);
		/*
		 * 교재 109~113
		 */
//		resultIndex = binarySearch(data, key);// compareTo()를 사용하여 구현
		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		key = new PhyscData2("나동", 164, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);// compareTo()를 사용되는지를 확인-이해할 수 있어야 한다
		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}

}
