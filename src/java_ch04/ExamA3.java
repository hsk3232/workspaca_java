package java_ch04;

public class ExamA3 {
	public static void main(String[] args) {
		String[] names = { "홍길동", "김유신", "계백", "강감찬", "을지문덕" };
		for (int i = 0; i < names.length; i++) {
			System.out.println("[" + names[i] + "]");

			String[] subjs = { "수학", "국어", "영어", "과학", "역사" };
			int[][] scores = { { 85, 90, 78, 88, 92 }, { 75, 80, 85, 90, 95 }, { 65, 70, 75, 80, 85 },
					{ 95, 92, 88, 84, 91 }, { 88, 76, 85, 79, 90 } };
			/*
			 * for (int j = 0; j < subjs.length; j++) { for (int k = 0; k < scores.length;
			 * k++) { System.out.println(subjs[j] + " : " + scores[k][0]);
			 * 
			 * }
			 * 
			 * }
			 */
			for (int j =0; j<5;j++) {
				for(int k=0;k<5;k++) {
					System.out.println(subjs[k] + " : "+ scores[j][k]);
				}
			}
		}
	}
}
