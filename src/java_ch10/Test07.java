package java_ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test07 {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<>(); // 순서를 지키지 않는다.
		
		
		//방법 1
		Iterator<String> keys = dic.keySet().iterator();
		//↓이거 풀면 이렇게 됨. 
		//Set<String> keyset = dic.keySet();
		//Interator<String> keys = keyset.iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
		
		//방법2 => 잘 안씀.
		for (Map.Entry<String, String> elem : dic.entrySet()) {
			System.out.println(String.format("%s : %s", elem.getKey(), elem.getValue()));
		}
		
		//방법 3
		for (String key : dic.keySet()) {
			System.out.println(String.format("%s:%s", key, dic.get(key)));
		}

	}

}
