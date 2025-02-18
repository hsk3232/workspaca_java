package java_ch10;

import java.util.ArrayList;
import java.util.Iterator;


public class Test02 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		
		for(int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("===========");
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			//Iterator 방식으로 list를 불러 올 수 있으나 그다지 많이 사용하지는 않는다.
			//대부분 for문이나 람다식 사용한다.
		}

	}

}
