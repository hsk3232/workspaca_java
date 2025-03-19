package data_ch05;
/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 * 
 *  mark[g][h] = 1;
	  dir = next direction to try;
	  //출발점 (1,1), 이동 방향 dir = 2(2는 동쪽) 을 스택에 push
	  //initialize stack to the maze entrance coordinates and direction east;
	  add (i,j,dir) to top of stack;
	  i = g; j = h; dir = N;
 */

import java.util.Stack;

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요
enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	int i;
	int j;
	int dir;
	
	public Items(int i, int j, int dir) {
		this.i = i;
		this.j = j;
		this.dir = dir;
	}

}

class Offsets {
	int a;
	int b;
	
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class train_실습_미로찾기실습과제 {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다
	int maze[][]; // 미로
	int mark[][]; //내 발자국
	Items t = new Items(i, j, dir);
	
	void path(int maze[][], int mark[][], int m, int p) {
		int i = 1;
		int j = 1;
		int dir = 2;
		
		Stack<Integer> st = new Stack<>();
		
		
		
		st.push(t);
		
		while (!st.isEmpty()) //스텍이 비어있지 않다면,
		{
			//there are more moves
			   while ()
			   {
			     // (g,h) = 다음으로 움직일 곳 //현재 위치 (i,j)에 대하여 이동 방향 계산
				   if ((g == m) && (h == p)) {
			//success;
			//(i,j)와 (g,h)에 대하여 mark 표시
					   		break;
			      		}
			   		}
			   }
			
			if((!maze[g][h])&&(!mark[g][h])){
			 }else d++; // try next direction
			//(i,j) 현위치에 대한mark를 취소
			//cout<<"No path found"<<endl;
			
		//현재 위치 (i,j)에 대하여 mark[][]을 2로 설정
		//8가지 방향중에서 남은 방향에 대하여
	}
		
		
		
		
		
		
	
	
		
		
	 
	     
	
	static void show(String msg, int[][] maze) {
		
	}


	

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		
		for (int ia = 0; ia < 8; ia++) {
			moves[ia] = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
			moves[0].a = -1;	moves[0].b = 0;
			moves[1].a = -1;	moves[1].b = 1;
			moves[2].a = 0;		moves[2].b = 1;
			moves[3].a = 1;		moves[3].b = 1;
			moves[4].a = 1;		moves[4].b = 0;
			moves[5].a = 1;		moves[5].b = -1;
			moves[6].a = 0;		moves[6].b = -1;
			moves[7].a = -1;	moves[7].b = -1;
		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				//input[][]을 maze[][]로 복사

			}
		}

		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);


		}
	}
}
