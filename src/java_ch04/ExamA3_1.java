package java_ch04;

public class ExamA3_1 {
	public static void main(String[] args) {

		String[] names = { "홍길동", "김유신", "계백", "강감찬", "을지문덕" };
		String[] subjs = { "수학", "국어", "영어", "과학", "역사" };
		int[][] scores = { { 85, 90, 78, 88, 92 }, { 75, 80, 85, 90, 95 }, { 65, 70, 75, 80, 85 },
				{ 95, 92, 88, 84, 91 }, { 88, 76, 85, 79, 90 } };

		for (int i = 0; i < names.length; i++) {
			System.out.println("[" + names[i] + "]");
			for (int j = 0; j < subjs.length; j++) {
				int score = scores[i][j];

				// 삼항 연산자로 과목별 과락 기준 적용
				String result = (j == 0 && score < 50) ? " => 과락"
						: (j == 1 && score < 60) ? "=> 과락"
								: (j == 2 && score < 70) ? "=> 과락"
										: (j == 3 && score < 80) ? "=> 과락" 
												: (j == 4 && score < 90) ? "=> 과락" : "통과";

				System.out.println(subjs[j] + " : " + score + " " + result);
			}
			System.out.println(); // 학생별 줄바꿈
		}
	}
}
