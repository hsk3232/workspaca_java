package data_ch05;

import java.util.Arrays;

/*
 * 마방진: 마법 magic + 정방형 배열 + 배치 진열의 진 > 숫자를 특이하게 배열하여 모든 방향의 합이 일정
 * **매직 스퀘어(Magic Square)**는 n×n 크기의 정사각형 배열에 숫자를 배치하되, 
 * 모든 행, 열, 대각선의 숫자 합이 동일하게 되는 배열을 말합니다. 
 * 이때 이 동일한 합을 **매직 상수(Magic Constant)**라고 합니다.
 * n은 3,5,7 등 홀수일 때
 */
public class train_5_5_1마방진_실습 {

	public static void main(String[] args) {
        int n = 3; // 마방진의 크기
        int[][] magicSquare = new int[n][n];
/*
 * 루벤스의 방법 단계:
1. 첫 번째 숫자를 첫 번째 행의 가운데 열에 배치합니다.
2. 다음 숫자는 항상 대각선 위 오른쪽(북동쪽)으로 이동하여 배치합니다.
    2.1 만약 배열의 경계를 벗어나면 반대편으로 이동합니다.
        예를 들어, 열이 배열의 오른쪽 끝을 벗어나면 맨 왼쪽 열로 이동하고, 
        행이 배열의 맨 위를 벗어나면 맨 아래로 이동합니다.
3. 이미 숫자가 있는 칸에 도달한 경우, 현재 위치 바로 아래의 행으로 이동하여 다음 숫자를 배치합니다.
 */
        // 마방진 생성 알고리즘 (루벤스의 방법)
        int row = 0, col = n / 2; // 시작 위치
        for (int num = 1; num <= n * n; num++) {
        	// 현재 위치에 숫자 배치
        	magicSquare[row][col] = num;
        
        
        int newRow = row - 1;  // 북쪽(위)
        int newCol = col + 1;  // 동쪽(오른쪽)

        // 경계를 벗어나면 반대쪽으로 이동
        if (newRow < 0) newRow = n - 1;  // 맨 위로 가면 맨 아래로 이동
        if (newCol >= n) newCol = 0;     // 맨 오른쪽을 넘어가면 맨 왼쪽으로 이동

        // 이미 숫자가 있는 경우, 아래쪽(↓)으로 이동
        if (magicSquare[newRow][newCol] != 0) {
            newRow = row + 1;
            newCol = col;
        }

        row = newRow;
        col = newCol;
        }
        
		// 마방진 출력
			showSquare(magicSquare);

        
        // 마방진의 합 확인
        int magicSum = n * (n * n + 1) / 2;
        System.out.println("가로, 세로, 대각선의 합 =  " + magicSum );
        System.out.println("마방진 검사 = " + checkSquare(magicSquare, magicSum));
	}
    

     // 마방진 출력 메서드
        static void showSquare(int[][] magicSquare) {
        	//구현
//        	for(int i=0; i<magicSquare.length; i++)
//        		for(int j=0; j<magicSquare.length; j++)
//        			System.out.println(magicSquare[i][j] + "\t");
        	
        	for (int[] num : magicSquare) {
    			System.out.println(Arrays.toString(num));
    		}
    		System.out.println();
        }
        
        

        // 마방진 유효성 검증 메서드
        static boolean checkSquare(int[][] magicSquare, int magicSum) {
        	// 구현 
        	int n = magicSquare.length;
        	int sum1 = 0;
        	int sum2 = 0;
        	int sum3 = 0;
        	int sum4 = 0;
        	
        	for(int i = 0; i<n; i++) 
	    		for(int j = 0; j <n; j++) {
	    			sum3 += magicSquare[i][j];
	    			sum4 += magicSquare[j][i];
	    		}
	    		if(magicSum != sum3 || sum3 != sum4) {
	    			return false;
	    			}
	    		
	    	for(int i = 0; i<n; i++) {
	    		sum1 += magicSquare[i][i];
	    		sum2 += magicSquare[i][n-i-1];
	    		if(magicSum != sum1 || sum2 != sum1)
	    			return false;
	    	}
    	    	return true;
    	    	
        }			
    	
     	 
    
}
