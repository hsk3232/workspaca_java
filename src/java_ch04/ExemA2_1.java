package java_ch04;

import java.util.Scanner;

public class ExemA2_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i =1; i<6; i++) {
			System.out.print("이름 ["+i+"] : ");
			String name = sc.next();
			System.out.print("국어, 수학, 영어:");
			int kor = sc.nextInt();
			int mat = sc.nextInt();
			int eng = sc.nextInt();
			if (kor<0||kor>100||mat<0||mat>100||eng<0||eng>100) {
				i--;
				System.out.println("잘못된 점수 입니다.");
				continue;
			}
			
			String result = "통과";

			if (kor <= 60) {
				result = "과락";
			} else if (mat <= 50) {
				result = "과락";
			}
			else if (eng <=70) {
				result = "과락";
			}
			
			
			System.out.print("이름 =" + name + ", ");
			System.out.print("국어 = " + kor +", "+ "수학 = " + mat +", " + "영어 = " + eng + ", ");

			System.out.println(" : "+ result);
			//System.out.println("이름 = " + name);
		}

	}

}
