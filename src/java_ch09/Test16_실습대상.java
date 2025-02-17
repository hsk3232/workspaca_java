package java_ch09;

import java.util.Arrays;

public class Test16_실습대상 {

	public static void main(String[] args) {
		int score[] = { 85, 90, 95, 100, 75 };
		int score2[] = Arrays.copyOf(score, score.length);
		int score3[] = Arrays.copyOfRange(score, 3, 5);

		int score4[] = new int[score.length];
		System.arraycopy(score, 0, score4, 0, score.length);

		System.out.println(Arrays.toString(score)); //Arrays를 찍으면, 대괄호[] 안에 콤마,로 배열을 나타내 줌.
		System.out.println(Arrays.toString(score2));
		System.out.println(Arrays.toString(score3));
		System.out.println(Arrays.toString(score4));

		System.out.println(Arrays.equals(score, score2));

		Arrays.sort(score);
		System.out.println(Arrays.toString(score));
		System.out.println("score와 score2 equals 비교 : " + Arrays.equals(score, score2));

		int index = Arrays.binarySearch(score, 99);
		System.out.println("score 배열에 100에 대한 이진 탐색: " + index);
		//*** string array 정렬후 이진탐색하는 코드 작성 실습 
	}
}