package data_mission;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
문제 설명:
괄호로 이루어진 문자열이 주어졌을 때, 각 괄호가 제대로 짝을 이루고 있는지 확인하는 프로그램
괄호에는 <>, (), {}, []가 포함 
여는 괄호가 있을 때, 반드시 짝이 맞는 닫는 괄호가 나와야 하고, 
괄호는 올바르게 중첩되어야 한다.

조건:
  1. 여는 괄호는 반드시 닫는 괄호와 짝을 이뤄야 한다.
  2. 괄호들은 올바르게 중첩되어야 한다.
  3. 괄호 외의 문자는 무시한다.

입력 형식:
  한 줄에 괄호 문자열이 주어지고, 문자열은 괄호 외에도 다른 문자를 포함.

출력 형식:
  괄호가 유효하면 "Valid"를, 유효하지 않으면 "Invalid"를 출력.


*/

public class 과제05_스택응용_괄호매칭검사 {
	public static boolean isValid(String s) {
		// Map<Character, Character> pairs = *** // 사용 추천 "[ ]"을 map 쌍으로 정의
		// 파라미터로 넘어온 String을 배열로 변환
		String[] arr = s.split("");

		// 괄호를 char map으로 키와 값으로 설정
		Map<String, String> pairs = new HashMap<>();
		pairs.put("[", "]");
		pairs.put("{", "}");
		pairs.put("<", ">");
		pairs.put("(", ")");

		// arr 배열 중 pairs의 key와 value를 같이 저장하는 stack 생성
		Stack<String> temp = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			// arr 배열과 pairs의 key 값이 일치하는 여는 괄호를 찾아 stack에 삽입
			if (pairs.containsKey(arr[i])) {
				temp.add(arr[i]);
			}
			// arr 배열과 pairs의 value 값이 일치하는 닫는 괄호를 찾기
			else if (pairs.containsValue(arr[i])) {
				// Stack이 빈배열인지 확인해 여는 괄호가 있는지 확인(빈배열이라면, 닫는 것만 있음으로 짝이 안맞음)
				if (temp.isEmpty()) {
					return false;
				}
				// Stack에 저장된 여는 괄호를 key값으로 value값 불러서 닫는 괄호와 일치하는지 확인 (문자비교는 equals)
				else if (!pairs.get(temp.pop()).equals(arr[i])) {
					return false;
				}
			}
		}
		// for loop를 돌면서 stack에 저장된 배열을 보두 꺼내 비교하고 남았다면, 여는 괄호만 있는 것으로 false / 비었다면 true
		// 리턴
		return temp.isEmpty();

	}

	public static void main(String[] args) {

		String[] cases1 = { 
				"(12{as[33<1q2w3e>90]kkk}4r)fg", "<111{ddd[4r(1q2w3e)44]77}jj>kk",
				"zz{w(a+b)*[c/d]-<q-e>1+2}w*t", "dd[a+b+c(y*u[abstract]go{234}2w3e)444]ttt",
				"a+b<c-d<e%r{123{waste[go[stop(a+b+c(?)$)@]!]*}12}33>c-d>drop" };

		String[] cases2 = { "a-b-c{1234[3.14(hello)kkk]1>d-w", "a*b*c(121<good[days)gostop>q-w]t-1",
				"123{hello[a-w-e(w/e/r]\n)\t}qq", "q*t&w{12-34[a+b]*(c/d]-e}123",
				"12<a/b/c/d{q-t-t[a=c(78::]23;)'8}sss>x+y+w" };

		System.out.println("예제1:");
		for (String test : cases1) {
			System.out.println(test + " → " + isValid(test));
		}

		System.out.println("\n예제2:");
		for (String test : cases2) {
			System.out.println(test + " → " + isValid(test));
		}
	}
}
