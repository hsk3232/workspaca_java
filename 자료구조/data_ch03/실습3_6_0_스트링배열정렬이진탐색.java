package data_ch03;

/*
* 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색  
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;

public class 실습3_6_0_스트링배열정렬이진탐색 {

	private static void showData(String msg, String[] data) {
		System.out.println(msg);
		System.out.println(Arrays.toString(data));
		System.out.println();
	}

	private static void swap(String[] arr, int a, int b) {
		String c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}

	// 올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
	private static void sortData(String[] data) {
		int start = 0;
		int last = data.length - 1;
		while(start < last) {
			for (int i = last; i > start; i--) {
				if (data[i-1].compareTo(data[i]) > 0) {
					swap(data, i - 1, i);
					last = i;
				}
			

			}
		}	start = last;
	}

	// 교재 100 페이지 선형검색 seqSearch() 함수로 구현
	private static int seqSearch(String[] data, int a, String b) {
		// 배열의 요소 갯수
		a = data.length;

		// 배열을 돌면서 검색어 b와 같은 인덱스를 찾으면 반환
		for (int i = 0; i < data.length; i++) {
			if (data[i] == b) {
				return i;
			}
		}
		// 없으면 -1 반환 => 검색 실패
		return -1;
	}

	private static int linearSearch(String[] data, String key) {
		int a = data.length;
		int b = seqSearch(data, a, key);
		return b;
	}

	private static int binarySearch(String[] data, String key) {
		// 인덱스 맨앞
		int start = 0;
		// 인덱스 맨 끝
		int last = data.length - 1;

		// 인덱스 중앙
		int mid = (start + last) / 2;

		do {
			if (data[mid] == key) {
				return mid;
			}

			// 인덱스 중앙값 보다 비교값이 크면, 검색 범위를 뒤쪽 절반으로 좁힘
			else if (data[mid].compareTo(key) > 0) {
				start = mid + 1;
			} // 중앙값 보다 작을 경우 검색 범위를 앞쪽 절반으로 좁힘
			else {
				last = mid - 1;
			}
		} while (start <= last);
		return -1;
	}

	public static void main(String[] args) {
		String[] data = { "사과", "포도", "복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외" };
		showData("정렬전", data);
		sortData(data);//
		showData("정렬후", data);

		String key = "포도";
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "배";
		resultIndex = binarySearch(data, key);// 교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색 public final class String implements
		 * java.io.Serializable, Comparable<String>, CharSequence {
		 * 
		 * @Override public int compareTo(String anotherString) { return
		 * this.compareTo(anotherString); } }
		 *
		 * binarySearch(String[], String key)를 호출하면, 내부적으로 String 배열이 자동으로
		 * Comparable<String>[]로 해석.
		 */
		key = "산딸기";
		resultIndex = Arrays.binarySearch(data, key);// 교재 120 페이지 API 참조
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}
}
