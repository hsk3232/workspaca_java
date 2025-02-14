package java_ch04;

public class Test32 {
	public static void main(String[] args) {
		
		/*
		 * int[] arr = new int[5]; // [5]를 인덱스라 함. 
		 * for (int i = 0; i < arr.length; i++)
		 * { // 객체명.length = 인덱스 숫자 그대로 가져옴 arr[i] = 10 * (i + 1); }
		 * 
		 * int j = 0; while (j < arr.length) { System.out.println(arr[j++]); }
		 */
		
		int score[] = {1,2,3,4,5};
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
		for (int n : score)
			System.out.println(n);
		
	}
}
