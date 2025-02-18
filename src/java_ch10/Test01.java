package java_ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(); // <> 안에 String 안 써도 됨. 앞에 따라감
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		//1
		for (int i = 0; i < list.size(); i++) { // 특정 인덱스가 필요할 때는 이렇게
			System.out.println(list.get(i));
		}
		//2
		System.out.println("-".repeat(10));
		for (String s : list) { // list로부터 데이터 타입 s를 전체로 받아을 때는 "확장 for문 사용"
			System.out.println(s);
		
		}
		//3
		list.forEach(s -> System.out.println(s));
		//1~3다 같은 결과 값으로 표현이 다른 것.
		
		
		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");

		System.out.println("1 : " + list.toString());

		list.add(1, "LA"); //list 1번에 LA를 넣어라.
		print(2, list);
		System.out.println("3 : " + list.indexOf("서울"));
		System.out.println("4 : " + list.lastIndexOf("서울"));

		list.remove("LA");
		print(5, list);
		
		list.remove(2);
		print(6, list);
		
		System.out.println("7 : " + list.contains("LA"));
		//list에 LA를 caontains하고 있나? => false
		
	
		Object obj[] = list.toArray();
		System.out.println("8 : " + Arrays.toString(obj));

		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9 : " + Arrays.toString(cities));

		list.clear(); //리스트를 모두 비워라.
		print(10, list);

		System.out.println("11 : " + list.isEmpty());

		list.add("파리");
		list.add("방콕");
		list.add("LA");

		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");
		print(12, list2);

		list.addAll(list2);
		print(13, list);

		System.out.println("14 : " + list.containsAll(list2));

		list.retainAll(list2);
		print(15, list);

		list.removeAll(list2);
		print(16, list);

	}

	private static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);
	}

}
