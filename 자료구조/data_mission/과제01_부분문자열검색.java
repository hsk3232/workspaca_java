package data_mission;

import java.util.ArrayList;
import java.util.List;

/*
 * 주어진 긴 문자열 text에서 패턴 문자열 pattern이 등장하는 모든 시작 인덱스를 찾으세요.
 *
 * 입력: text = "abxabcabcabyabcaby", pattern = "abcaby"
 * 출력: [6,12]
 * 
 * 패턴이 나타나는 인덱스를 반환
 */
public class 과제01_부분문자열검색 {
	public static void searchSubstring(String text, String pattern) {
//		List<Integer> result = new ArrayList<Integer>();
//		for (int i = 0; i <= text.length() - pattern.length(); i++) {
//			int j;
//			for (j = 0; j < pattern.length(); j++) {
//				if (text.charAt(i + j) != pattern.charAt(j)) {
//					break;
//				}
//			}
//			if (j == pattern.length()) {
//				result.add(i);
//			}
//		}
//		System.out.println(result);
//
//	}
		System.out.print("[" + text.indexOf(pattern)+  ", ");
		System.out.println(text.lastIndexOf(pattern)+ "]");
	
	}
		
		
	public static void main(String[] args) {
		String text = "ababcabcabababd";
		String pattern = "ababd";
		searchSubstring(text, pattern);

		text = "abxabcabcabyabcaby";
		pattern = "abcaby";
		searchSubstring(text, pattern);
	}
}
