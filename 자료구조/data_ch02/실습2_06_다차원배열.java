package data_ch02;

import java.util.Arrays;
import java.util.Random;

public class 실습2_06_다차원배열 {

	// 행렬 생성 및 난수 데이터 입력
	static void inputData(int[][] data) {
		Random rad = new Random();
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = rad.nextInt(5);
			}
	}

	// 행렬 데이터 출력
	static void showData(String msg, int[][] items) {
		System.out.println(msg);
		for (int[] num : items) {
			System.out.println(Arrays.toString(num));
		}
		System.out.println();
	}

	// 행렬 a,b의 행의 수, 열의 수가 같아야 하고 각 원소가 같아야 한다.
	static boolean equals(int[][] a, int[][] b) {
		 if(Arrays.equals(a, b)) {
				 return true;
			 }
			 return false;
	}

	// 행렬 덧셈
	static int[][] addMatrix(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][X[0].length];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[0].length; j++) {
				Z[i][j] = X[i][j] + Y[i][j];
			}
		return Z;
	}

	// 행렬 곱셈
	static int[][] multiplyMatrix(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][Y[0].length];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < Y[0].length; j++) {
				int a = 0;
				while (a < X[0].length) {
					int c = X[i][a] * Y[a][j];
					c += c;
					Z[i][j] = c;
					a++;
				}

			}
		return Z;
	}

	// 행렬 전치
	static int[][] transposeMatrix(int[][] X) {
		int[][] Z = new int[X[0].length][X.length];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[0].length; j++) {
				Z[j][i] = X[i][j];
			}
		return Z;
	}

	// 행렬 곱셈 결과-전치행렬 사용
	static int[][] multiplyMatrixTransposed(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][Y.length];
		for (int a = 0; a < X.length; a++) 
			for (int j = 0; j < Y.length; j++) {
				int i = 0;
				while(i < X[0].length) {
				 int c = X[a][i] * Y[j][i];
					c += c;
					Z[a][j] = c;
					i++;
				}

			}
		return Z;
	}

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		

		inputData(A);
		inputData(B);
		int[][] D = A.clone();// 교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);

		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);

		int[][] E = addMatrix(A, D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);

		C = multiplyMatrix(A, B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int[][] F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);

		C = multiplyMatrixTransposed(A, F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);

		boolean result = equals(A, C);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}

}
