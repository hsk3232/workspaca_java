package java_ch06;

import java.util.Scanner;

public class PrimeNumber1 {

public static boolean isPrime(int num) {
	for(int i = 2; i<=Math.sqrt(num); i++) {
		//sqrt는 제곱근을 붙이는 함수로 이것을 사용할 경우 num-1, num/2보다 훨씬 루프 횟수를 줄일 수 있음
		if (num%i==0){
			return false; //값을 		
		} 		
			
	}
	return true;

}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Number[0:exit]:");
			int num = sc.nextInt();
			if (num == 0)
				break;
			if (isPrime(num) == true)
				System.out.println(num + " is a Prime.");
			else
				System.out.println(num + " is not a Prime.");

		}
		sc.close();
		System.out.println("Done!");
	} //num이 소수면 true, 그렇지 않으면 false를 리턴


}
