package data_ch04;

import java.util.ArrayList;
import java.util.Scanner;

import data_ch04.IntQueue3.EmptyIntQueue3Exception;
import data_ch04.IntQueue3.OverflowIntQueue3Exception;

import java.util.Random;

/*
 * 실습 4_5번 - 정수 배열 원형 큐
 * 교재 148 ~ 157 페이지
 * 교재 소스 코드를 보지 않고 구현 완성 연습 필요 
 * /*
 * num 변수를 사용하지 않고 front == rear 일 때 queue가 full인지 empty 인지를 판단
 * 큐에서는 예외 클래스를 만드는 연습
 */

/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */

//int형 고정 길이 큐
class IntQueue3 {
	private ArrayList<Integer> que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean isEmptyTag;
	private int num;
	// private int num;
	// 현재 데이터 개수>> 삭제한 후에 queue가 full, empty를 구분하는 실습
	// enque 하기전에 갯수를 세어 front==rear 조건을 체크한다
	// deque도 마찬가지임

//--- 실행시 예외: 큐가 비어있음 ---//

	@SuppressWarnings("serial")
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception(String msg) {
			super(msg);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//

	@SuppressWarnings("serial")
	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception(String msg) {
			super(msg);
		}
	}

//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		isEmptyTag = true;
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<Integer>(capacity);
		} catch (Exception e) {
			capacity = 0;
		}
	}

//--- 큐에 데이터를 인큐 ---//
	public boolean enque(int x) throws OverflowIntQueue3Exception {
		if (isFull())
			throw new OverflowIntQueue3Exception("enque full");

		que.add(x);
		rear++;
		num++;

		if (rear == capacity)
			rear = 0;
		isEmptyTag = false;

		return true;

	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		if (num <= 0)
			throw new EmptyIntQueue3Exception("deque empty");
		isEmptyTag = true;

		int val = que.get(front++);
		num--;
		if (front == capacity)
			front = 0;
		return val;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
		if (num<=0)
			throw new EmptyIntQueue3Exception("peek: que empty");
		return que.get(rear - 1);
	}

//--- 큐를 비움 ---//
	/*
	 * queue을 empty로 만들어야 한다. queue이 empty일 때 clear()가 호출된 예외 발생해야 한다
	 */
	public void clear() {
		if (num!=0)
			que.removeAll(null);
		throw new EmptyIntQueue3Exception("삭제할 데이터가 없습니다.");
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		while (capacity < rear - 1) {
			int front = rear - 1;
			for (int i = front; front > capacity; i--) {
				if (que.get(i) == x) {
					i = front;
					return que.indexOf(i);
				}
			}
			capacity = front;
		}
		return -1;
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		if (num == 0)
			return true;
		return false;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		if (num >= capacity)
			return true;
		return false;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num<=0)
			System.out.println("출력할 데이터가 없습니다.");
			
		System.out.print(que.toString());
	}
}

public class 실습4_5_정수원형큐_리스트 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ")");
				try {
					oq.enque(rndx);
				} catch (OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}
		}
	}

}
