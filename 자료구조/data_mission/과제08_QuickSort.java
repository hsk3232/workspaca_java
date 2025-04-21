package data_mission;


import java.util.Stack;

//stack 1개를 사용한 non-recursve QuickSort() 구현

class Point20 {
	private int ix;
	private int iy;

	public Point20(int x, int y) {
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
		
		
		Stack<Point20> st = new Stack<>();		
		Point20 pt = new Point20(left, right);
		st.push(pt);
		
		
		while (!st.isEmpty()) {
		    pt = st.pop();
		    int l = pt.getX();
		    int r = pt.getY();
		    int pl = l;
		    int pr = r;
		    int x = a[(l + r) / 2]; 

		    // 분할
		    do {
		        while (a[pl] < x) pl++;
		        while (a[pr] > x) pr--;
		        if (pl <= pr)
		            swap(a, pl++, pr--);
		    } while (pl <= pr);

		    if (l < pr)
		        st.push(new Point20(l, pr));
		    if (pl < r)
		        st.push(new Point20(pl, r));
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
