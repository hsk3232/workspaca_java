package data_mission;
/*
 * 미로 찾기 문제
 * 문제: 미로 테이블 (12, 15)을 상하좌우 울타리 친 maze[14][17]를 만들어라 단, 입구는 (1, 1), 출구는 (12, 15)이다.
 * 조건: stack을 사용한 backtracking 구현
 */

import java.util.Arrays;
import java.util.Stack;

//java에서 구현하면 좋으나 아직 배우지 않아서 다음 주에 enum 사용하는 방법 알려 줌.
enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	private int i;
	private int j;
	private int dir;

	public Items(int i, int j, int dir) {
		this.i = i;
		this.j = j;
		this.dir = dir;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

}

class Offsets {
	int x;
	int y;

	public Offsets(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class 과제06_미로찾기 {

	// 움직이는 방향 8가지 //static을 선언하는 이유를 알아야 한다
	static Offsets[] moves = new Offsets[8];

	// 미로와 경로에 관한 상태 값
	int maze[][] = new int[14][17];
	int mark[][] = new int[14][17];

	// 내가 만들어야 하는 메서드
	static void path(int maze[][], int mark[][], int m, int p) {
		// 우선법에 의해 오른쪽으로 먼저 가야 함으로 east부터 감.
		Items t = new Items(1, 1, 2);

		// 스택 생성
		Stack<Items> st = new Stack<>();
		// 첫 번째 값을 푸시
		st.push(t);


		// 스텍에 미로를 다 넣고 꺼낼 건데, 다 없어질 때까지 해라.
		while (!st.isEmpty()) {
			// 스택에 저장한 위치를 꺼낸다.
			t = st.pop();

			int i = t.getI();
			int j = t.getJ();
			int dir = t.getDir();
			
			//움직인 위치에 2로 마크
			mark[i][j] = 2;

			
			
			while (dir < 8) {
				// (g,h) = 이동 가능 위치
				// 현재 위치 (i,j)에 대하여 이동 가능한 방향을 대입
				int g = i + moves[dir].x;
				int h = j + moves[dir].y;


				// i, j 넣고
				if (maze[g][h] == 0 && mark[g][h] == 0) {
					
					mark[g][h] = 2;
					st.push(new Items(i, j, dir + 1));
					i = g; 
					j = h;
					dir = 0;

				} 
				else {
					dir++;
				}
				
				//
				if ((g == m) && (h == p)) {
					System.out.println("미로찾기 성공!");
					return;
				}

			}
			mark[i][j] = 0;
		}
		//while문을 돌면서 모든 스택의 미로를 다 꺼냈음에도 내가 갈 길이 없다면,
		System.out.println("실패");

	}

	static void show(String msg, int[][] arr) {
		System.out.println(msg);
		for (int[] a : arr)
			System.out.println(Arrays.toString(a));
	}

// 모든 코드는 메인으로부터 멀면 멀수록 나중에 짜도 됨
	// 메인에서 나선형으로 돌아서 나가야함.
	// 메인의 코드부터 완결 시켜야 함. 빈부분을 먼처 채우고 컴파일해서 디벨롭 가능함.

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };

		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0); // 배열에 offsets 객체를 치환해야 한다.

	
		moves[0].x = -1; moves[0].y = 0; 	// N
		moves[1].x = -1; moves[1].y = 1; 	// NE
		moves[2].x = 0; moves[2].y = 1; 	// E
		moves[3].x = 1; moves[3].y = 1; 	// SE
		moves[4].x = 1; moves[4].y = 0; 	// S
		moves[5].x = 1; moves[5].y = -1; 	// SW
		moves[6].x = 0; moves[6].y = -1; 	// W
		moves[7].x = -1; moves[7].y = -1; 	// NW

		// 울타리를 만들어서 쳐라.
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				// i
				if (i == 0 || i == 13 || j == 0 || j == 16) {
					maze[i][j] = 8;
				} else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;
			}
		}

		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);
		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

	}
}
