package data_mission;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap

	// ★ 마지막 생성된 Heap 인스턴스를 보관( showData 가 삽입할 때 사용 )
	static Heap lastCreated;

	public Heap(int sz) {
		// 빈 부분 구현
		MaxSize = sz;
		heap = new int[MaxSize + 1]; // 1-based index
		n = 0;
		lastCreated = this; // 최신 인스턴스 등록
	}

	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		// 빈 부분 구현
		if (n == 0) {
			System.out.println("[heap empty]");
			return;
		}
		System.out.println("[index : value]");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " : " + heap[i]);
		}
	}

	@Override
	public void Insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		// 빈 부분 구현 (percolate up)
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		int i = n;
		while (i > 1 && heap[i / 2] < x) {
			heap[i] = heap[i / 2];
			i = i / 2;
		}
		heap[i] = x;
	}

	@Override
	public int DeleteMax() {//heap에서 가장 큰 값을 삭제하여 리턴한다.
		// 빈 부분 구현 (percolate down)
		if (n == 0) {
			HeapEmpty();
			int elm = 0;
			return elm;
		}
		int x = heap[1];      // 최댓값
		int last = heap[n];   // 말단 노드 값
		n--;

		int i = 1;
		int j = 2;
		while (j <= n) {
			// 더 큰 자식 선택
			if (j < n && heap[j] < heap[j + 1]) j++;
			// 제자리면 종료
			if (last >= heap[j]) break;
			heap[i] = heap[j];
			i = j;
			j = 2 * i;
		}
		heap[i] = last;
		return x;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class 과제11_heap_정렬 {
	static void showData(int[] d) {
		// 빈 부분 구현: 난수 채우기 + Heap 에 삽입 + 배열 출력
		if (d == null || d.length <= 1) {
			System.out.println("[empty]");
			return;
		}
		Random rnd = new Random();
		// x[0]은 사용하지 않으므로 1..length-1 사용
		for (int i = 1; i < d.length; i++) {
			d[i] = rnd.nextInt(100) + 1; // 1~100
		}
		// 마지막 생성된 Heap 에 삽입
		if (Heap.lastCreated != null) {
			for (int i = 1; i < d.length; i++) {
				Heap.lastCreated.Insert(d[i]);
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < d.length; i++) {
			sb.append(d[i]);
			if (i < d.length - 1) sb.append(' ');
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count+1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    int[] sorted = new int[count];//heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
			     showData(x);
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 
				// 빈 부분 구현
				int idx = 0;
				for (int i = 0; i < count; i++) {
					int v = heap.DeleteMax();
					if (v == 0) break; // 비었으면 종료(우린 1~100만 넣으므로 0은 empty 신호)
					sorted[idx++] = v; // 내림차순으로 채워짐
				}
				if (idx == 0) {
					System.out.println("[nothing to sort]");
				} else {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < idx; i++) {
						sb.append(sorted[i]);
						if (i < idx - 1) sb.append(' ');
					}
					System.out.println(sb.toString());
				}
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}