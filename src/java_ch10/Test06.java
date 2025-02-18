package java_ch10;

import java.util.HashMap;

public class Test06 {
public static void main(String[] args) {
	String word[] = {"BUNBLEBEE", "HEAVEN", "ALTHOUGH", "WONDER"};
	String meaning[] = {"꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다"};
	
	HashMap<String, String> dic = new HashMap<String, String>();
	for(int i = 0; i <word.length; i++) {
		dic.put(word[i], meaning[i]);
	}
	
	System.out.println("1. "+ dic);
	System.out.println("2. "+dic.size());
	
	System.out.println("3. "+ dic.keySet());
	System.out.println("4. "+dic.values());
	
	System.out.println("5. "+"HEAVEN : " + dic.get("HEAVEN"));
	
	dic.replace("HEAVEN", "아주 행복한 감정");
	System.out.println("6. "+"HEAVEN : " + dic.get("HEAVEN"));
	
	dic.put("HEAVEN", "이상적인 세상");
	System.out.println("7. "+"HEAVEN : " +dic.get("HEAVEN"));
	
	System.out.println("8. "+dic.containsKey("BUNBLEBEE"));
	System.out.println("9. "+dic.containsValue("자장가"));
	
	dic.remove("HEAVEN");
	System.out.println("10. "+dic.containsKey("HEAVEN"));
	
	dic.clear();
	
	System.out.println("11. "+dic.isEmpty());
	System.out.println("12. "+dic.size());
	
}
}
