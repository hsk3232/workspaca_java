package java_ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test01 {
public static void main(String[] args) {
	//b.txt가 있는지 확인
	
		File file = new File("b.txt");
			if(file.exists()){
				System.out.println("b.txt 파일이 존재합니다. 덮어쓸까요?");
				
			
				Scanner sc = new Scanner(System.in);
				String ans = sc.next();
				if(ans.equalsIgnoreCase("N")) {
					System.out.println("종료");
					return;
				}
				
			}

	try(

	FileInputStream fi = new FileInputStream("a.txt");
//	try(FileReader fi = new FileReader("a.txt"))
	FileOutputStream fo = new FileOutputStream("b.txt");)
	{
		int c = 0;
		while ((c = fi.read()) != -1) {
			// fo.write(c);
			System.out.println((char) (c));
		}
	}catch(
	Exception e)
	{
		System.out.println(e.getMessage());
		e.printStackTrace(); // 에러 왜 났는지 말해 주는 것.
	}System.out.println("파일이 저장 됐다능");
}}
