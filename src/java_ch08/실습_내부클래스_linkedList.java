package java_ch08;
/*
 * 주석을 삭제하고 소스코드를 보지 않고 작성하는 훈련 실습
 */
class LinkedList {

	private Node head = null;

	private class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}

	public void add(String data) {
		/*
		//코드 이해해야 한다 - 자료구조 수업에 도움이 됨
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;

		}
		*/
	}

	public void print() {
		/*
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
		*/
	}
	
	public void delete(String data) {
		/*
		if (head == null) {
			System.out.println("삭제할 데이터가 없습니다.");
		} else {
			Node p = head;
			Node q = p;
			while (p != null) {
				if (p.data.compareTo(data) == 0) {
					q.link = p.link;
					//삭제할 데이터
					System.out.println("삭제 완료");
					return;
				}
				q = p;
				p = p.link;
			}
			System.out.println("삭제할 데이터가 없읍니다.");
			return;
		}
		*/
	}
}
public class 실습_내부클래스_linkedList {
	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.print();

		myList.add("11");
		myList.add("55");
		myList.add("77");
		myList.add("177");
		myList.add("33");
		myList.print();
		myList.delete("177");
		System.out.println("삭제후 출력: ");
		myList.print();
		//Node ndx = new Node("kim");
		//MyLinkedList.Node nd = myList.new Node("Hong");//not visible
		//nd.data = "hello";
	}
}

}

