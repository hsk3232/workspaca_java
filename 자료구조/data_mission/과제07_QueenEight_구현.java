package data_mission;

import java.util.ArrayList;
import java.util.List;

class Point {
	private int ix;
	private int iy;

	// 생성자 구현
	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	// Getter, Setter 구현
	public int getIx() {
		return ix;
	}

	public void setIx(int ix) {
		this.ix = ix;
	}

	public int getIy() {
		return iy;
	}

	public void setIy(int iy) {
		this.iy = iy;
	}

	// List<Point> data; 때문에 만들어야함.
	@Override
	public String toString() {
		return "(" + ix + "," + iy + ")";
	}

	// Stack4.indexOf() 때문에 만들어야함.
	@Override
	public boolean equals(Object obj) {
		// 1. 같은 객체 참조일 경우 true
		if (this == obj)
			return true;

		// 2. null이거나 클래스 다르면 false
		if (obj == null || getClass() != obj.getClass())
			return false;

		// 3. Point 타입으로 다운캐스팅
		Point other = (Point) obj;

		// 4. 좌표 값 비교
		return ix == other.ix && iy == other.iy;
	}
}

class Stack4 {
	private List<Point> data; // 스택용 배열, Point 객체를 저장할 List
	private int capacity; // 스택의 크기, 최대 저장 개수 제한
	private int top; // 스택 포인터, 현재 스택의 크기 (인덱스 역할)

	// 생성자(constructor)
	public Stack4(int capacity) {
		this.data = new ArrayList<>();
		this.capacity = capacity;
		this.top = 0;
	}

	// [Custom_Exception]: 스택이 비어있음
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// [Custom_Exception]: 스택이 가득 참
	public class OverflowGenericStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	// [Push] : 스택에 x를 푸시
	public boolean push(Point x) throws OverflowGenericStackException {
		if (isFull())
			throw new OverflowGenericStackException("스택이 가득 찼습니다.");
		data.add(x);
		top++;
		return true;
	}

	// [Pop] : 스택에서 정상에 있는 데이터를 꺼냄
	public Point pop() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("스택이 비었습니다.");
		top--;
		return data.remove(top);
	}

	// [Peek] : 스택에서 정상에 있는 데이터를 들여다봄
	public Point peek() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("스택이 비었습니다.");
		return data.get(top - 1);
	}

	// [Clear] : 스택을 비움
	public void clear() {
		top = 0;
	}

	// [indexOf] : 스택에서 x를 찾아 인덱스 반환 (없으면 -1 반환)
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// [capacity] : 스택의 크기 반환
	public int getCapacity() {
		return capacity;
	}

	// [Size] : 스택에 쌓여있는 데이터 갯수를 반환
	public int size() {
		return top;
	}

	// [isEmpty] : 스택이 비어있는가?
	public boolean isEmpty() {
		return top <= 0;
	}

	// [isFull] : 스택이 가득 찼는가?
	public boolean isFull() {
		return top >= capacity;
	}

	// [dump] : 스택 안의 모든 데이터 출력(바닥 → 꼭대기 순서로)
	public void dump() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class 과제07_QueenEight_구현 {

	public static void EightQueen(int[][] d) {
		int numberOfSolutions = 0;
		int count = 0; // 퀸 배치 갯수
		int ix = 0, iy = 0; // 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy); // 현 위치를 객체로 만들고

		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		st.push(p);// 스택에 현 위치 객체를 push
		ix++;// ix는 행별로 퀸 배치되는 것을 말한다.
		iy = 0;// 다음 행으로 이동하면 열은 0부터 시작

		while (true) {
		    // 1. 해를 찾은 경우
		    if (count == 8) {
		        numberOfSolutions++;
		        System.out.println("=== Solution " + numberOfSolutions + " ===");
		        showQueens(d);

		        // 백트래킹
		        try {
		            Point last = st.pop();
		            ix = last.getIx();
		            iy = last.getIy();
		            d[ix][iy] = 0;
		            count--;
		            iy++;
		        } catch (Stack4.EmptyGenericStackException e) {
		            break;
		        }
		        continue; // 다음 해 탐색
		    }

		    // 2. 다음 열 찾기
		    if (ix >= 8 || (iy = nextMove(d, ix, iy)) == -1) {
		        // 백트래킹
		        try {
		            Point last = st.pop();
		            ix = last.getIx();
		            iy = last.getIy();
		            d[ix][iy] = 0;
		            count--;
		            iy++;
		        } catch (Stack4.EmptyGenericStackException e) {
		            break;
		        }
		        continue;
		    }

		    // 3. 퀸을 놓을 수 있는 경우
		    d[ix][iy] = 1;
		    st.push(new Point(ix, iy));
		    count++;
		    ix++;
		    iy = 0;
		}
	}

	// 배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		public static boolean checkRow(int[][] d, int row) {
			for (int i = 0; i < 8; i++) {
				if (d[row][i] == 1)
					return false;
			}
			return true;
		}

	// 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
	public static boolean checkCol(int[][] d, int col) {
		for (int i = 0; i < 8; i++) {
			if (d[i][col] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 행 x, 열 y에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int x, int y) {
		// 왼쪽 상단이 (0, 0) 기준임.
		// ↗ 방향 (북동)
		for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
			if (d[i][j] == 1)
				return false;
		}
		// ↙ 방향 (남서)
		for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			if (d[i][j] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 행 x, 열 y에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int x, int y) {
		// x++, y++ or x--, y--
		// 왼쪽 상단이 (0, 0) 기준임.
		// ↖ 방향 (북서)
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if (d[i][j] == 1)
				return false;
		}
		// ↙ 방향 (남서)
		for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			if (d[i][j] == 1)
				return false;
		}
		return true;
	}

	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {
		// (x,y)로 이동 가능한지를 check
		return checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {
		// 현재 row, col에 대하여 이동할 col을 return
		for (int j = col; j < 8; j++) {
			if (checkMove(d, row, j))
				return j;
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print((data[i][j] == 1 ? "Q " : ". "));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}
}
