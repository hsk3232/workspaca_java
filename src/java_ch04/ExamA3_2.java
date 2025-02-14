package java_ch04;

public class ExamA3_2 {
	public static void main(String[] args) {
		String[] names = { "홍길동", "김유신", "계백", "강감찬", "을지문덕" };
		String[] subjs = { "수학", "국어", "영어", "과학", "역사" };
		int[][] scores = { { 85, 90, 78, 88, 92 }, { 75, 80, 85, 90, 95 }, { 65, 70, 75, 80, 85 },
				{ 95, 92, 88, 84, 91 }, { 88, 76, 85, 79, 90 } };

		

		for (int i = 0; i < names.length; i++) {
			System.out.println("[" + names[i] + "]");
			for (int j = 0; j < subjs.length; j++) {
				
				
				int mat = scores[i][0];
				String result1 = (mat>49)?" => 통과":" =>과락";

				int kor = scores[i][1];
				String result2 = (kor>59)?" => 통과":" =>과락";

				int eng = scores[i][2];
				String result3 = (eng>69)?" => 통과":" =>과락";

				int sic = scores[i][3];
				String result4 = (sic>79)?" => 통과":" =>과락";

				int his = scores[i][4];
				String result5 = (his>89)?" => 통과":" =>과락";
				
				System.out.println(subjs[j] + " : " + scores[i][j] + result1 + result2 + result3 + result4 + result5);

			}

			/*
			 * if (scores[i][0] <= 50) { result = "과락"; } else if (mat <= 50) { result =
			 * "과락"; } else if (eng <=70) { result = "과락";
			 */
		}

	}

}