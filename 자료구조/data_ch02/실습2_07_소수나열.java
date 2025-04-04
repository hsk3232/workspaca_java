package data_ch02;

/*
 * 어떤 정수를 나누어 떨어지게 만드는 수를 약수(divisor)
 * N % d == 0을 만족하는 d를 N의 약수
 * 
 * 소수(prime number)는 1과 자기 자신만을 약수로 가지는 수
 * 약수가 1과 자기 자신 두 개뿐인 자연수를 소수(즉 약수가 2개일 것)
 * 
 * 0은 모든 수로 나누어지므로 소수가 아님.
 * 1은 약수가 하나뿐이라 소수가 될 수 없음.
 * 2는 약수가 두 개(1과 자기 자신)뿐이므로 소수이며, 유일한 짝수 소수
 */
public class 실습2_07_소수나열 { 
	// 0 이상 n 이하의 소수 개수를 반환하는 함수
	static int a = 0;
	static int primeCount(int n, int[] data) {
		if (isPrime(n)) {
			data[a++] = n;
			}
					
		return a;
	}

	// 소수 판별 함수
	public static boolean isPrime(int num) {
		if(num == 2 || num ==3) {
			return true;
		}
		else{
			for(int i=2; i<=num; i++) {
				if(num%i == 0) {
					break;
				}
				if(num == i+1) {
					return true;
				}
			}
			return false;
		} 
	}

	// 최대 공약수(GCD) 계산 함수 (유클리드 호제법 사용)
	/*
	 * 두 수 a와 b(a > b)가 있을 때, a를 b로 나눈 나머지를 이용하여 재귀적으로 GCD를 구할 수 있음. 나머지가 0이 될 때,
	 * 나누는 수가 최대 공약수(GCD).
	 * 
	 * 예제: GCD(56, 98) 구하기 98 % 56 = 42 → GCD(56, 42) 56 % 42 = 14 → GCD(42, 14) 42
	 * % 14 = 0 → GCD(14, 0), 즉 최대 공약수는 14.
	 */
	public static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y; // 나머지 계산
			x = temp; // x를 이전 y로 업데이트
		}
		return Math.abs(x);

	}

	// 최소 공배수(LCM) 계산 함수
	/*
	 * GCD(최대 공약수)와의 관계 LCM(a, b) = (a × b) / GCD(a, b)
	 */
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b); // LCM 공식: (a * b) / GCD(a, b)
	}

	public static void main(String[] args) {
		int[] primeArr = new int[100];
		for (int i = 0; i <= 20; i++) {
			int num = primeCount(i, primeArr);
			System.out.print("\n0부터 " + i + "까지의 소수 개수: " + num + ", ");
			if (num > 0)
				for (int j = 0; j < num; j++)
					System.out.print(primeArr[j] + " ");
		}
		int num1 = 56, num2 = 98;
		System.out.println("\n\n" + num1 + "와 " + num2 + "의 최대 공약수: " + gcd(num1, num2));

		int num3 = 12, num4 = 18;
		System.out.println("\n\n" + num3 + "과 " + num4 + "의 최소 공배수: " + lcm(num3, num4));
	}

}
