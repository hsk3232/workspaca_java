package data_ch08;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;
	
	//클래스 Node1의 생성자
	public Node1(int element) {
		//실제 저장되는 값
		data = element;
		
		//다음 노드를 가르키는 링크 -> null로 초기화
		link = null;
	}
}


class LinkedList1 {
	//리스트의 시작(헤드 노드)
	Node1 first;
	
	//클래스 LinkedList1의 생성자
	public LinkedList1() {
		//처음에는 리스트가 비어있음.
		first = null;
	}
	
	//삭제 Method - 전달된 element 값이 존재 하면 삭제하고 true로 리턴
	public boolean Delete(int element) 
	{	
		Node1 q, current = first;
		q = current;
		
		return true;
	}
	

	
	//출력 Method - 전체 리스트를 순서대로 출력
	public void Show() { 
		//변수의 타입이 node임
		Node1 p = first;
		int num = 0;

	}
	
	//[삽입] - 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	public void Add(int element) {
		//1. 입력받은 숫자를 저장할 새 노드 생성
		Node1 newNode = new Node1(element);
		
		//2. 맨 앞에 삽입할지 검사
		//[경우 1] 리스트가 빈 경우 / [경우 2] 첫 번째 노드보다 작은 값인 경우
		//[경우 1] -> 아무 노드도 없는 상태로 바로 삽입 / [경우 2] -> 새 노드를 맨 앞에 삽입.
		if (first == null || element < first.data) {
			//first는 기존 노드의 첫번째 값을 가르키고 있음.
			//새 노드의 다음 노드를 리스트의 첫번째 값을 가르키도록 해, 새 노드를 연결함.
			newNode.link = first;
			
			//리스트의 시작을 새 노드로 갱신함.
			first = newNode;
			return;
		}
		Node1 p = first, q = null;
		while (p != null && p.data < element ) {
			q = p;
			p = p.link;
				
			}
		newNode.link = p;
		if(q !=null) {
			q.link = newNode;
		}
	}
	
	//전달된 data 값을 찾아 존재하면 true로 리턴, 없으면 false로 리턴
	public boolean Search(int data) { 
		
		Node1 ptr = first;

		return false;
	}
	void Merge(LinkedList1 b) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상
		 * a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */

	}
}

public class train_실습과제8_1정수연결리스트 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");
		// 표시할 문자열
		private final String message; 
		// 순서가 idx번째인 열거를 반환
		static Menu MenuAt(int idx) { 
			
			//.values()는 자바 라이브러리에서 제공하는 함수임.
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}
		//"Add" 상수가 정의될 때 Menu("삽입") 생성자가 호출되어 message 필드가 "삽입"으로 초기화
		//생성자는 각 상수가 정의될 때 호출되며, 해당 상수의 message 필드를 초기화하는 역할
		//enum 상수가 언제 정의되는가를 찾아 보아야 한다 
		
		// 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다 
		Menu(String string) { 
			message = string;
			System.out.println("\nMenu 생성자 호출:: " + string);
		}
		
		// 표시할 문자열을 반환
		String getMessage() { 
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			//m으로 생성자 호출, 중요함.
			for (Menu m : Menu.values()) {
				//n%3은 3으로 나누어 나머지를 계산한다 
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				
				//메뉴 출력시에 다음행에 출력하라는 의미
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			//메뉴 선택 번호로 입력된 값이 key이다
			key = sc.nextInt(); 
			//입력된 key가 음수이거나 Exit에 대한 enum 숫자보다 크면 다시 입력받는다 
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		// 메뉴 참조 변수일 뿐이다 
		Menu menu; 
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 난수 숫자 개수::");
		int count = sc.nextInt(); //난수 생성 갯수

		int data = 0;
		do {
			//Menu 생성자 호출 - menu 객체를 리턴한다
			switch (menu = SelectMenu()) { 
			// 난수를 삽입하는데 올림차순으로 정렬되도록 구현
			case Add: 
				for (int i =0; i < count; i++) {
					data = rand.nextInt(100);
					l.Add(data);
				}
				break;
				
			case Delete:
				System.out.println("삭제할 값을 입력: ");
				data = sc.nextInt();
				boolean tag = l.Delete(data);
				System.out.println("삭제 데이터 존재여부: " + tag);
				break;
				
			//리스트 전체를 출력
			case Show: 
				l.Show();
				break;
				
			//입력 숫자 n을 검색한다.
			case Search: 
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + " 데이터가 존재합니다.");
				break;
				
			//리스트 l과 l2를 합병하여 올림차순 정렬이 되게 구현한다 
			case Merge:
				LinkedList1 l2 = new LinkedList1();
				for (int i =0; i < count; i++) {
					data = rand.nextInt(20);
					l2.Add(data);
				}
				System.out.println("리스트 l::");
				l.Show();
				System.out.println("리스트 l2::");
				l2.Show();
				
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				l.Merge(l2);
				System.out.println("병합 리스트 l::");
				l.Show();
				break;
				
			// 꼬리 노드 삭제
			case Exit: 
				break;
			}
		} while (menu != Menu.Exit);
	}
}
