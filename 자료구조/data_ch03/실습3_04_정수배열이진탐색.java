package data_ch03;

/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class 실습3_04_정수배열이진탐색 {
	static Random rnd = new Random();

	private static void inputData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(100);
		}
	}

	private static void showList(String msg, int[] data) {
		System.out.println(msg);
		System.out.println(Arrays.toString(data));
	}

	private static boolean linearSearch(int[] data, int key) {
		int k = key;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == k) {
				return true;
			}
		}

		return false;
	}
	
	private static boolean binarySearch(int[] data, int key) {
		//인덱스 맨 앞
		int pl = 0;
		
		//인덱스 맨 끝
		int pr = data.length-1;
		
		//인덱스 중앙
		int i = (pl + pr) / 2;
		
		
		do {
			//반을 쪼갠 값이 키와 같냐?
			if(data[i] == key)
				//네 같아요
				return true;
			//아니면, 인덱스 중앙 값보다 키가 크냐?
			else if (data[i] < key)
				//네 그럼 검색 범위를 뒤쪽 절반으로 좁혀라.
				pl = i + 1;
			//인덱스 중앙 값보다 작아요.
			else
				//그럼 검색 범위를 앞쪽 절반으로 좁혀라.
				pr = i - 1;
			//줄여 나갔는데도 찾는 애가 없어요.
		} while (pl <= pr);
			//그렇다면 배열 안에 없는 것이란다. 거짓을 반환해라.
			return false;

	}
	

	public static void main(String[] args) {
		int[] data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data); // 구현 반복 숙달 훈련

		int key = rnd.nextInt(100);
		boolean resultIndex = linearSearch(data, key);// 교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		// Arrays 클래스에 linear search는 없기 때문에 구현해야 한다
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = rnd.nextInt(100);
		/* 교재 109~113 */
		resultIndex = binarySearch(data, key);// 함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);

		
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		
		key = rnd.nextInt(100);
		int a = Arrays.binarySearch(data, key);
		if(a == -1) {
			resultIndex = true;
		}
		
		if(resultIndex = true) {
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);
	} else {
		System.out.println("검색 결과에 없습니다.");
	}

}
}
