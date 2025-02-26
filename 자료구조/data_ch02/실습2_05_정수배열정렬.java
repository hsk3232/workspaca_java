package data_ch02;

public class 실습2_05_정수배열정렬 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬후", data);
		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);

		reverseSort(data);//역순으로 정렬
		showData("역순 정렬후", data);
		sortData(data);
		int realData = 15;
		int []result = insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", result);
	}
	
	static int[] insertData(int[] d, int k) {
		int[]newArr = new int[d.length+1]; // 새로운 배열을 만듦
		for(int i = 0; i < newArr.length; i++) 
			for(int j =0; j < newArr.length; j++) {
			if(d[i]<k) {
				newArr[j++] = d[i];
			} else {
					newArr[j++] = k;
						}
		} return newArr;
	}
	
	static void showData(String msg, int[]data) {

	}
	static void inputData(int []data) {

	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지

	}
	static void sortData(int []arr) {

	}
	static void reverse(int[] a) {//교재 67페이지

	}
	static void reverseSort(int []arr) {

	}
	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 */
	static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length+1];

		
	}


}
