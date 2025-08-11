package data_ch06;

public class 실습6_12_1MergeSort정수2 {

	// --- 두 정렬된 부분 배열을 병합하는 함수 --- //
	static void merge(int[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int temp[] = new int[30]; // 임시 배열 (정렬된 결과를 저장)
		int tempIdx = 0;        // temp 배열의 현재 인덱스
		int leftIdx = leftStart;    // 왼쪽 부분 배열의 시작 인덱스
		int rightIdx = rightStart;  // 오른쪽 부분 배열의 시작 인덱스

		// 왼쪽과 오른쪽 부분 배열의 값을 비교하면서 작은 값을 temp에 넣음
		while (leftIdx <= leftEnd && rightIdx <= rightEnd) {
			if (arr[leftIdx] < arr[rightIdx]) {
				temp[tempIdx++] = arr[leftIdx++];
			} 
			else if (arr[leftIdx] > arr[rightIdx]) {
				temp[tempIdx++] = arr[rightIdx++];
			} 
			else {
				// 두 값이 같으면 둘 다 temp에 넣음 (중복 허용)
				temp[tempIdx++] = arr[leftIdx++];
				temp[tempIdx++] = arr[rightIdx++];
			}
		}

		// 왼쪽 배열에 남은 요소가 있으면 temp에 복사
		while (leftIdx <= leftEnd) {
			temp[tempIdx++] = arr[leftIdx++];
		}

		// 오른쪽 배열에 남은 요소가 있으면 temp에 복사
		while (rightIdx <= rightEnd) {
			temp[tempIdx++] = arr[rightIdx++];
		}

		// temp에 정렬된 값을 원래 배열의 해당 위치에 복사
		System.out.println("-----");
		for (int i = 0; i < tempIdx; i++) {
			arr[leftStart + i] = temp[i];
			System.out.print(" " + arr[leftStart + i]);
		}
		System.out.println();
	}

	// --- 비재귀 머지 정렬 (재귀 없이 반복문으로 구현) --- //
	static void MergeSort(int[] arr, int left, int right) {
		int totalLen = right - left + 1;  // 정렬 대상의 길이

		// 병합할 블록 크기를 1부터 시작해 두 배씩 늘려감 (1, 2, 4, 8...)
		for (int blockSize = 1; blockSize < totalLen; blockSize *= 2) {

			// 현재 blockSize 크기의 쌍을 병합하기 위해 시작 위치를 설정
			for (int start = left; start <= right - blockSize; start += 2 * blockSize) {
				int mid = start + blockSize - 1;             // 왼쪽 구간의 끝
				int end = start + 2 * blockSize - 1;         // 오른쪽 구간의 끝 (배열 끝을 넘지 않게 조정)
				if (end > right) end = right;

				// 정렬된 두 부분 배열을 병합
				merge(arr, start, mid, mid + 1, end);
			}
		}
	}

	// --- 테스트용 메인 함수 --- //
	public static void main(String[] args) {
		int[] data = new int[20];  // 정렬 대상 배열 생성

		// 배열에 0~49 사이의 난수를 채움
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 50);
		}

		// 정렬 전 출력
		System.out.println("정렬 전:");
		for (int value : data) {
			System.out.print(" " + value);
		}
		System.out.println();

		// 비재귀 머지 정렬 실행
		MergeSort(data, 0, data.length - 1);

		// 정렬 후 출력
		System.out.println("오름차순으로 정렬했습니다.");
		for (int value : data) {
			System.out.print(" " + value);
		}
	}
}
