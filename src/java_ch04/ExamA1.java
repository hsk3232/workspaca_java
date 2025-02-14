package java_ch04;

import java.util.Scanner;

public class ExamA1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름:");
		String name = sc.next();
		
		System.out.print("과목:");
		String subject = sc.next();
		
		System.out.print("성적:");
		int grade = sc.nextInt();


		String result = "";
		
		System.out.print("이름=" + name + ", ");
		System.out.print("과목=" + subject + ", ");
		System.out.print("성적=" + grade + ", ");

		if (grade <= 60) {
			result = "과락";
		} else if (grade > 60) {
			result = "합격";
		}
		System.out.println(result);

	}

}
