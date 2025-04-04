package data_mission;


import java.util.Random;
import java.util.Stack;

//stack 1개를 사용한 non-recursve QuickSort() 구현

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

public class 과제08_QuickSort {


//퀵 정렬(비재귀 버전)
	

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	
	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {
		if(a == null || a.length == 0) {
			return;
		}
		
		
		Stack<Point> st = new Stack<>();		
		Point pt = new Point(left, right);
		st.push(pt);
		
		
		while (!st.isEmpty()) {
			pt = st.pop();
			int pl = left = pt.getX();
			int pr = right = pt.getY();
			int x = a[(left + right) / 2];
				
				//배열을 양분함
			do {
				while (a[pl] < x) {pl++;}
				while (a[pr] > x) {pr--;}
					if(pl<=pr)
						swap(a, pl++, pr--);
				
				} while (pl<=pr);
			
			if(left<pr) {
				pt = new Point(left, pr);
				st.push(pt);
			}
			if (pl < right) {
				pt = new Point(pl, right);
				st.push(pt);
			}
		}
			
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
