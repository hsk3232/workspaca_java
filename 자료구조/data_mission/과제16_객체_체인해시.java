package data_mission;

import java.util.Comparator;
//hash node가 student 객체일 때를 구현하는 과제
//체인법에 의한 해시
import java.util.Scanner;

//체인법에 의한 해시

class SimpleObject50 {
	static final int NO = 1;
	static final int NAME = 2;
	String no; // 회원번호
	String name; // 이름

	// --- 입력/표현 & 비교자 추가 (main에서 사용) --- //
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);
		if ((sw & NO) == NO) {
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	@Override
	public String toString() {
		return "(" + no + ") " + name;
	}

	public static final Comparator<SimpleObject50> NO_ORDER = new Comparator<SimpleObject50>() {
		@Override
		public int compare(SimpleObject50 a, SimpleObject50 b) {
			return a.no.compareTo(b.no);
		}
	};

	public static final Comparator<SimpleObject50> NAME_ORDER = new Comparator<SimpleObject50>() {
		@Override
		public int compare(SimpleObject50 a, SimpleObject50 b) {
			return a.name.compareTo(b.name);
		}
	};

}

class ChainHash5 {
//--- 해시를 구성하는 노드 ---//
	class Node2 {
		private SimpleObject50 data; // 키값
		private Node2 next; // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		Node2(SimpleObject50 d, Node2 n) {
			this.data = d;
			this.next = n;
		}
	}

	private int size; // 해시 테이블의 크기
	private Node2[] table; // 해시 테이블

//--- 생성자(constructor) ---//
	public ChainHash5(int capacity) {
		this.size = capacity;
		this.table = new Node2[size];

	}

	private int hash(String key) {
		if (key == null)
			return 0;
		int h = key.hashCode();
		if (h == Integer.MIN_VALUE)
			h = 0;
		h = Math.abs(h) % size;
		return h;
	}

//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	public int search(SimpleObject50 st, Comparator<? super SimpleObject50> c) {
		int idx = hash(st.no);
		Node2 p = table[idx];
		while (p != null) {
			if (c.compare(p.data, st) == 0)
				return 1;
			p = p.next;
		}
		return 0;
	}

//--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	public int add(SimpleObject50 st, Comparator<? super SimpleObject50> c) {
		int idx = hash(st.no);
		Node2 p = table[idx];
		while (p != null) {
			if (c.compare(p.data, st) == 0)
				return 1; // 중복
			p = p.next;
		}
		// 버킷 앞에 삽입
		table[idx] = new Node2(st, table[idx]);
		return 0;
	}

//--- 키값이 key인 요소를 삭제 ---//
	public int delete(SimpleObject50 st, Comparator<? super SimpleObject50> c) {
		int idx = hash(st.no);
		Node2 p = table[idx];
		Node2 prev = null;
		while (p != null) {
			if (c.compare(p.data, st) == 0) {
				if (prev == null)
					table[idx] = p.next;
				else
					prev.next = p.next;
				return 1;
			}
			prev = p;
			p = p.next;
		}
		return 0;
	}

//--- 해시 테이블을 덤프(dump) ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			System.out.print(String.format("%2d : ", i));
			Node2 p = table[i];
			if (p == null) {
				System.out.println("-");
				continue;
			}
			StringBuilder sb = new StringBuilder();
			while (p != null) {
				sb.append(p.data.toString());
				if (p.next != null)
					sb.append(" -> ");
				p = p.next;
			}
			System.out.println(sb.toString());
		}

	}
}

public class 과제16_객체_체인해시 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		Scanner stdIn = new Scanner(System.in);
		ChainHash5 hash = new ChainHash5(15);
		SimpleObject50 data;
		int select = 0, result = 0;
		do {
			switch (menu = SelectMenu()) {
			case Add:
				data = new SimpleObject50();
				data.scanData("삽입", SimpleObject50.NO | SimpleObject50.NAME);
				result = hash.add(data, SimpleObject50.NO_ORDER);
				if (result == 1)
					System.out.println(" 중복 데이터가 존재한다");
				else
					System.out.println(" 입력 처리됨");
				break;
			case Delete:
				// Delete
				data = new SimpleObject50();
				data.scanData("삭제", SimpleObject50.NO);
				result = hash.delete(data, SimpleObject50.NO_ORDER);
				if (result == 1)
					System.out.println(" 삭제 처리");
				else
					System.out.println(" 삭제 데이터가 없음");
				break;
			case Search:
				data = new SimpleObject50();
				data.scanData("검색", SimpleObject50.NO);
				result = hash.search(data, SimpleObject50.NO_ORDER);
				if (result == 1)
					System.out.println(" 검색 데이터가 존재한다");
				else
					System.out.println(" 검색 데이터가 없음");
				break;
			case Show:
				hash.dump();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
