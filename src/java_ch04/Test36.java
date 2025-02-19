package java_ch04;

public class Test36 {
	public static void main(String[] args) {
		int [][]arr = new int [2][];
		arr[0] = new int [5];
		arr[1] = new int [3];
		
		char letter = 'A';
		char[] alpha = new char[26];
		int b = letter + 1; //implicit type casting 
		System.out.println((char)b);
		
		for (int i = 0; i < alpha.length; i++) {
			//alpha[i] = letter + i; 에러남, ()로 type casting 해야 함
			alpha[i] = (char)(letter + i); //explicit type casting
		}
		for (char c: alpha)
			System.out.println(c);
	}
}
