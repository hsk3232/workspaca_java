package data_ch09;

/*
 * 9장 tree
 * 1. 난수를 생성하여 binary search tree를 만든다 - insert()함수: 삽입되는 x가 root보다 작으면 left, 크면 right child로 이동
 * 2. 임의 숫자 x를 delete: x가 leaf node, one child node, two child nodes를 가질 수 있다
 * 3. stack을 이용한  non-recursive inorder 알고리즘
 * 4. queue를 사용한 level order 알고리즘의 구현
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class TreeNode5 {
	TreeNode5 LeftChild;
	int data;
	TreeNode5 RightChild;

	public TreeNode5() {
		LeftChild = RightChild = null;
	}
}

class ObjectStack5 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	@SuppressWarnings("serial")
	public class EmptyGenericStackException extends Exception {
		public EmptyGenericStackException (String msg) {
			super(msg);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	@SuppressWarnings("serial")
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException (String msg) {
			super(msg);
		}
	}

	private List<TreeNode5> data; // list를 사용: 배열은 크기를 2배로 늘리는 작업 필요
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public ObjectStack5(int capacity) {
		capacity = top = 0;
		
		try {
			data = new ArrayList<>();
		}
		catch (Exception e) {
			capacity =0;
			e.printStackTrace();
		}
		
	}

//--- 스택에 x를 푸시 ---//
	public boolean push(TreeNode5 x) throws OverflowGenericStackException {
		if(!isFull()) 
			data.add(x);
			capacity++;
			top++;
		throw new OverflowGenericStackException("스택에 자리 없음");
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public TreeNode5 pop() throws EmptyGenericStackException {
		if(!isEmpty()) {
			TreeNode5 val = data.get(top-1);
			top--;
			return val;
		}
		throw new EmptyGenericStackException ("데이터 없음");
	}	

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public TreeNode5 peek() throws EmptyGenericStackException {
		if(!isEmpty()) {
			TreeNode5 val = data.get(top-1);
			return val;
		}
		throw new EmptyGenericStackException("피크할 데이터 없음");
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
//	public int indexOf(TreeNode5 x) {
//		int front = 0;
//		int last = capacity-1;
//		
//		do{
//			int mid = (front+last)/2;
//			if(data.get(mid) == x) {
//				return mid;
//			}
//			else if(data.get(mid) < x) {
//				front = last +1; 
//			}else front = last-1;
//		} while (front <= last); 
//		
//		return -1;
//	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		if(capacity == 0)
			return true;
		return false;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		if(capacity == top)
			return true;
		return false;
		
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {

	}
}

//정수를 저정하는 이진트리 만들기 실습
class ObjectQueue5 {
	private TreeNode5[] que;// 큐는 배열로 구현
	// private List<Integer> que; // 수정본
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num;

//--- 실행시 예외: 큐가 비어있음 ---//
	@SuppressWarnings("serial")
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String msg) {
			super(msg);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	@SuppressWarnings("serial")
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException (String msg) {
			super(msg);
		}
	}

//--- 생성자(constructor) ---//
	public ObjectQueue5(int maxlen) {
		front = rear = 0;
		
		capacity = maxlen;
		
		try {
			que = new TreeNode5 [maxlen];
		}
		catch (Exception e) {
			capacity = 0;
		}
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(TreeNode5 x) throws OverflowQueueException {
		if(!isEmpty()) {
			que[rear-1] = x;
		}
		throw new OverflowQueueException("데이터가 다 찼음");
		
	}

//--- 큐에서 데이터를 디큐 ---//
	public TreeNode5 deque() throws EmptyQueueException {
		if(!)
		throw new EmptyQueueException("데이터가 없음");

	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public TreeNode5 peek() throws EmptyQueueException {
		
		throw new EmptyQueueException("데이터가 없음");

	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(TreeNode5 x) {

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
		
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {

	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {

	}
}

class Tree5 {
	TreeNode5 root;

	Tree5() {
		root = null;
	}

	/*
	 * inorderSucc()는 current 노드 다음에 방문할 노드를 찾는다 inorder traversal를 이해하는 것이 필요하다
	 * 트리에서 delete 구현시에 사용된다
	 */
	TreeNode5 inorderSucc(TreeNode5 current) {
		TreeNode5 temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		System.out.println("inordersucc:: temp.data = " + temp.data);
		return temp;
	}

	boolean isLeafNode(TreeNode5 current) {// current 가 leaf node 인지 조사
		if(current.LeftChild ==null && current.RightChild ==null) {
			return true;
		}
		return false;
	}
	
	boolean isOneChildNode(TreeNode5 current) {// current 가 leaf node 인지 조사
		if(current.LeftChild ==null && current.RightChild !=null) {
			return true;
		}
		else if(current.LeftChild !=null && current.RightChild ==null) {
			return true;
		}
		return false;
	}
	
	// main에서 호출되는 driver function
	void inorder() {
		inorder(root);
	}
	
	// main에서 호출되는 driver function
	void preorder() {
		preorder(root);
	}
	
	// main에서 호출되는 driver function
	void postorder() {
		postorder(root);
	}

	/*
	 * 주어진 노드 x, left child를 Tl, right child를 Tr이라 할 때 inorder: Tl - x - Tr 순서로 방문
	 * preorder: x - Tl - Tr 순서로 방문 postorder: Tl - Tr - x 순서로 방문
	 */
	
	// inorder traversal을 구현하는 recursive function - workhorse라고 부름
	void inorder(TreeNode5 CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}
	
	// preorder traversal을 구현하는 recursive function - workhorse라고 부름
	void preorder(TreeNode5 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}
	
	// postorder traversal을 구현하는 recursive function - workhorse라고 부름
	void postorder(TreeNode5 CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	// void Tree5::inorder(TreeNode5 *CurrentNode)와 비교
	// stack을 사용한 inorder 출력
	// non-recursive 코드를 이해하는 학습 필요
	void NonrecInorder(){
		ObjectStack5 s = new ObjectStack5(20);
		TreeNode5 CurrentNode = root;
		while (true) {
			while (CurrentNode != null) {
				s.push(CurrentNode);
				CurrentNode = CurrentNode.LeftChild;
			}
			if (!s.isEmpty()) {
				try {
					CurrentNode = s.pop();
				} catch (data_ch09.ObjectStack5.EmptyGenericStackException e) {
					e.printStackTrace();
				}
				System.out.println(" " + CurrentNode.data);
				CurrentNode = CurrentNode.RightChild;
			} else
				break;
		}
	}

	void levelOrder() // level 별로 출력한다. level이 증가하면 다음줄에 출력한다 >> 선택 사항
	// 난이도: 최상급 구현
	// queue를 사용한 구현
	{
		ObjectQueue5 q = new ObjectQueue5(20);
		Queue<Integer> que = new LinkedList<>();

	}

	boolean insert(int x) {// binary search tree를 만드는 입력 : left subtree < 노드 x < right subtree
		// inorder traversal시에 정렬된 결과가 나와야 한다
		TreeNode5 p = root;
		TreeNode5 q = null;
		TreeNode5 newNode = new TreeNode5();
		newNode.data = x;
		
		//p가 null일 때 첫 값으로 X값인 newNode로 난수를 입력
		if(p == null) {
			p = newNode;
			return true;
		}
		
		while (p != null) {
			//q에 p를 복사
			q = p;
			
			//p.data가 x와 같다면 중복 값으로 false 리턴
			if(x == p.data) 
				return false;
			
			//p.data가 x보다 크다면, p를 leftchild로 이동 => child는 null 상태로 p가 null이 돼 while문 탈출
			if(x < p.data)
				p = p.LeftChild;
			
			//작다면, p를 rightchile로 이동 => child는 null 상태로 p가 null이 돼 while문 탈출
			else 
				p = p.RightChild;
		}
		
		//q는 p를 복사했음으로 
		 if (x < q.data) 
			q.LeftChild = newNode;
		else 
			q.RightChild = newNode;
		
		return true;

	}

	boolean delete(int x) {
		// binary search tree에서 임의 값을 갖는 노드를 찾아 삭제한다.
		// 난이도 중상
		// 삭제 대상이 leaf node인 경우, non-leaf node로 구분하여 구현한다
		
		
		TreeNode5 p = root, q = null, parent = null;
		int branchMode = 0; // 1은 left, 2는 right
		
		while (p != null) {
			if (x > p.data) {
				q = p;
				p = p.RightChild;
			}
			else if ( x < p.data){
				q = p;
				p = p.LeftChild;
			}
			else {
				//삭제할 노드는 p
				if(isLeafNode(p)) {
					
				}
				else if (isOneChildNode(p)) {
					
				}
				else {
					TreeNode5 temp = inorderSucc(p);
					
				}
			}
		}
		
		//자식노드가 없는 경우 -> 메서드 isLeafNode(TreeNode5 current)를 활용해서 함.
		
		//자식노드가 1개인 경우 -> 메서드 oneChildNode 활용
		
		//자식 노드가 2개인 경우
		
		return false;

	}

	boolean search(int num) {// num 값을 binary search tree에서 검색
		TreeNode5 p = root;
		while (p !=null) {
			if(p.data == num) {
				return true;
			}
			else {
				if(p.data <num) {
					p = p.LeftChild;
				}
				else {
					p = p.RightChild;
				}
			}
		}
		return false;
	}
}

public class train_실습과제9_1_정수이진트리 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("정렬출력"), LevelorderPrint("레벨별출력"),
		StackInorderPrint("스택정렬출력"), PreorderPrint("prefix출력"), PostorderPrint("postfix출력"), Exit("종료");

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
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree5 t = new Tree5();
		Menu menu; // 메뉴
		int count = 7;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: //
				int[] input = new int[count];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(50);
				}
				for (int n : input)
					System.out.print(n + " ");
				for (int i = 0; i < count; i++) {
					if (!t.insert(input[i]))
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 임의 정수 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num))
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				// t.NonrecInorder();
				break;
			case LevelorderPrint: //
				t.levelOrder();
				System.out.println();
				// t.NonrecInorder();
				break;
			case StackInorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.NonrecInorder();
				break;
			case PreorderPrint:// prefix 출력
				t.preorder();
				System.out.println();
				break;
			case PostorderPrint:// postfix로 출력
				t.postorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
