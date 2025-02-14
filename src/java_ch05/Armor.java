package java_ch05;

import java.util.Random;
import java.util.Scanner;

class Student { // public이 없는 것을 default라고 함.
	int sno;
	public void setSno(int num) {
		String name = "HongGilDong";
		sno = num;
	}
}

//class Armor { // Armor라는 클래스
//	private String name; // 필드
//	public int height;
//
//	public void takeOff() { // void는 함수다, //메소드
//
//	}// {}는 함수 body라고 한다.

public class Armor {
	public static void main(String[] args) {
		Student st = new Student();
		st.sno = 99;
		st.setSno(11);
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
	}

}
